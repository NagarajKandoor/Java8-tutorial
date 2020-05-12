package com.javanext.tutorial.streams.com;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;;

/**
 * @author Nagaraj
 *
 */
public class TraderTesting {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Trader raoul = new Trader("A", "Cambridge");
		Trader mario = new Trader("B", "Milan");
		Trader alan = new Trader("C", "Cambridge");
		Trader brian = new Trader("D", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		List<Transaction> tr2011 = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(toList());
		List<String> cities = transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(toList());

		List<Trader> traders = transactions.stream().map(Transaction::getTrader)
				.filter(t -> t.getCity().equalsIgnoreCase("Cambridge")).distinct()
				.sorted(Comparator.comparing(Trader::getName)).collect(toList());
		String traderStr = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("",
				(n1, n2) -> n1 + n2);
		boolean milanBased = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue)
				.forEach(System.out::println);
		Optional<Integer> highestValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		
		System.out.println(traderStr);
	}

}
