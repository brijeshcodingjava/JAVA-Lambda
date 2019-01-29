package exercises;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person person1, Person person2) {

		if( person1 == null && person2 != null ) {
			return person2.getLastname().compareTo("");
		}
		else if( person1 != null && person2 == null ) {
			return person1.getLastname().compareTo("");
		}
		else
		{
			return person1.getLastname().compareTo( person2.getLastname() );
		}
	}
	
	

}
