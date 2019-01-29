package exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercises1 {

public static void main(String ...args) {
		
		List<Person> people = Arrays.asList(
					new Person("Charles","Dickens",60),
					new Person("Levis","Carrol",42),
					new Person("Thomas","Carl",51),
					new Person("Charlotte","Brain",45),
					new Person("Matthew","Arnold",39)
				);
		
		System.out.println("Original List...");
		System.out.println();
		
		// Step 1 -- Sort List by Lastname
		
		Collections.sort( people, (p1, p2) -> p1.getLastname().compareTo( p2.getLastname() ) );
		
		// Step 2 -- Print all elements
		System.out.println( "\n Sorted List...");
		System.out.println();
		printFiltered( people, p -> p.getLastname().startsWith("") );
				
		// Step 3 -- Print all that starts with C
		System.out.println( "\n Filtered List...");
		System.out.println();
		printFiltered( people, p -> p.getLastname().startsWith("C") );
		
		// Printing list using forEach java8
		System.out.println("\n Printing list using forEach java8...");
		System.out.println();
		
		people.forEach( p -> System.out.println(p));
		
		// Printing list using forEach Reference method java8 
		System.out.println("\n Printing list using forEach java8...");
		System.out.println();
		
		people.forEach( System.out::println );
		
	}

	private static void printAll( List<Person> list ){
		
		for( Person person : list ) {
			System.out.println( person );
		}
	}
	
	private static void printFiltered( List<Person> list , Condition condition )
	{
		for( Person person : list ){
			
			if( condition.test(person) ) {
				System.out.println( person );
			}
		}
		
	}

}

 
