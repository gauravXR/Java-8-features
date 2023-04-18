package java8.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TryStream {
    public static void main(String[] args) throws Exception {
      List<String> t=  Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(t+"-------------------------------");

        List<Integer> list1
                = Arrays.asList(0, 2, 4, 6, 8, 10);

        // Using peek with count() method,Method
        // which is a terminal operation
        list1.stream().peek(System.out::println).count();

        System.out.println("-------------------------------");

        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
        System.out.println("The Structure before flattening is : " +
                listOfListofInts);
        List<Integer> listofInts = listOfListofInts.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("The Structure after flattening is : " +
                listofInts);

        System.out.println("-------------------------------");


        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(namesFlatStream);//ab->ab.stream()


        System.out.println("-------------------------------");
        Stream<Integer> st = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        st.forEach(p -> System.out.print(p));

        System.out.println("-------------------------------");

        Stream<Integer> stream = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        stream.limit(2).forEach(p -> System.out.print(p));
        System.out.println("-------------------------------");
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println(mergedString);
        System.out.println("-------------------------------");

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> (int) x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getCount());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }


}
