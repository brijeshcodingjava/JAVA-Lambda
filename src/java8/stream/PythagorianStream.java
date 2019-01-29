package java8.stream;

import java.util.stream.IntStream;

public class PythagorianStream {

	// a*a + b*b = c*c 
	public static void main( String ...args )
	{
		IntStream.rangeClosed( 1, 100 )   // This will returns intergers from 
					.boxed()			  // Convert IntStream into Integer
					.flatMap(
								a -> IntStream.rangeClosed( a, 100 ).filter( b -> ( Math.sqrt( a*a + b*b ) % 1 == 0 ) )
																	.mapToObj( b -> new int[] {a, b, (int) Math.sqrt( a*a + b*b )} )
								
							)
					.limit( 10 )
					.forEach( num -> System.out.println( num[0] + ", " + num[1] + ", " + num[2]) );
		
		
	}
}
