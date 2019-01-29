package java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TestTraderStream {

	public static void main( String ...args )
	{
		Trader raoul = new Trader("Raoul", "Cambridge");
		
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Trader> traders = Arrays.asList( raoul, mario, alan, brian );
		
		List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700),
			new Transaction(alan, 2012, 950)
		);
		
		// Find all transactions in the year 2011 and sort them by value (small to high)
		
		List<Transaction> transactions1 = transactions.stream()
											.filter( transaction -> transaction.getYear() == 2011 )
											.sorted( Comparator.comparing( Transaction::getValue ) )
											//.sorted( (t1, t2) -> t1.getValue() > t2.getValue() ? 1 : t1.getValue() < t2.getValue() ? -1 : 0 )
											.collect( Collectors.toList() );
		
		System.out.println("\nFind all transactions in the year 2011 and sort them by value (small to high) \n");
		//transactions1.forEach( transaction -> System.out.println(transaction) );
		transactions1.forEach( System.out :: println );
		
		System.out.println("\nWhat are all the unique cities where the traders work? \n");
		
		List<String> cities = traders.stream()
								.map( trader -> trader.getCity() )
								.distinct()
								.collect(Collectors.toList() );
		
		cities.forEach( System.out::println );
		
		Set<String> cities2 = transactions.stream()
									.map( trans -> trans.getTrader().getCity() )
									.collect( Collectors.toSet() );
		cities2.forEach( System.out::println );
		
		System.out.println("\nFind all traders from Cambridge and sort them by name. \n");
		
		List<Trader> camTraders = transactions.stream()
									.filter( trans -> trans.getTrader().getCity().equalsIgnoreCase("Cambridge") )
									.map( trans -> trans.getTrader() )
									.sorted( Comparator.comparing( Trader::getName ) )
									.distinct()
									.collect( Collectors.toList() );
		camTraders.forEach( System.out::println );
		
		System.out.println("\nAre any traders based in Milan? \n");
		
		Optional<Trader> milanTrader = transactions.stream()
								.map( trans -> trans.getTrader() )
								.filter( trader -> trader.getCity().equals( "Milan" ) )
								.findAny();
		
		if(milanTrader.isPresent() ) System.out.println( milanTrader.get().getName() );
		
		boolean matched = transactions.stream().anyMatch( trans -> trans.getTrader().getName().equals("Milan") );
		
		System.out.println( matched );
		
		System.out.println( "\nPrint all transactions’ values from the traders living in Cambridge.\n" );
		
		List<Integer> transValues =
		transactions.stream().filter( trans -> trans.getTrader().getCity().equals("Cambridge") )
		 					 .map( trans -> trans.getValue() )
		 					 .collect( Collectors.toList() );
		
		transValues.forEach( System.out::println );
		
		System.out.println("\nWhat’s the highest value of all the transactions?\n");
		
		Optional<Transaction> maxValue = transactions.stream().max( Comparator.comparing( Transaction::getValue ) );
		Optional<Integer> maxValueInt = transactions.stream().map( Transaction::getValue ).reduce( Integer::max );
		
		if( maxValue.isPresent() ) System.out.println( maxValue.get().getValue() );
		
		System.out.println( "\nFind the transaction with the smallest value.\n" );
		
		Optional<Transaction> minValue = transactions.stream().min( Comparator.comparing( Transaction::getValue ) );
		
		if( minValue.isPresent() ) System.out.println( minValue.get().getValue() );
		
		System.out.println("\n\n");
	}
}
