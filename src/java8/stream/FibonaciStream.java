package java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonaciStream {

	public static void main( String ...args )
	{
		List<int[]> nums =
		Stream.iterate( new int[]{0,1}, t -> new int[]{ t[1], t[0] + t[1] } )
				.limit( 20 )
				.collect( Collectors.toList() );
		
		nums.forEach(num -> System.out.println( "("+num[0]+","+num[1]+")" ));
		
		System.out.println( "\nFibonaci Series : " );
		Stream.iterate( new int[]{0,1}, f -> new int[]{ f[1], f[0]+f[1] } )
				.limit( 10 )
				.map( t -> t[0] )
				.forEach( num -> System.out.print( num + ", " ) );
	}
}
