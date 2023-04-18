/**
 * 
 */
package java8;

import java.time.LocalDate;
import java.util.function.Supplier;
public class SupplierExample {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Creating a Supplier
		Supplier<Integer> getCurrDayOfMonth = () -> LocalDate.now().getDayOfMonth();

		// invoking get method inside the Supplier
		System.out.println("Today's day of the month is: "+getCurrDayOfMonth.get());
		
		// Creating a Supplier
		Supplier<String> getCurrDay = () -> LocalDate.now().getDayOfWeek().name();

		// invoking get method inside the Supplier
		System.out.println("Today's day is: "+getCurrDay.get());



	}

}
