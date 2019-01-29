package exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercises1Java7 {

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
		
		Collections.sort( people, new PersonComparator() );
		
		// Step 2 -- Print all elements
		System.out.println( "Sorted List...");
		System.out.println();
		printAll( people );
				
		// Step 3 -- Print all that starts with C
		System.out.println( "Filtered List...");
		System.out.println();
		printFiltered( people, new Condition(){

			@Override
			public boolean test(Person p) {
				return p.getLastname().startsWith("C");
			}
			
		});
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

interface Condition {
	public boolean test(Person p);
}
