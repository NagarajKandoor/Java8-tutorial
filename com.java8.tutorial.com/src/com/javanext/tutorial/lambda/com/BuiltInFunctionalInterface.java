package com.javanext.tutorial.lambda.com;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Nagaraj
 *
 */
public class BuiltInFunctionalInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Function<Long, Long> adder = new BuiltInFunctionalInterfaceFunction();
		Long result = adder.apply((long) 4);
		System.out.println("result = " + result);

		// lambda Function
		Function<Long, Long> lambda = (value) -> value + 3;
		Long resultLambda = lambda.apply((long) 8);
		System.out.println("result = " + resultLambda);

		BuiltInFunctionalInterfacePredicate predicate = new BuiltInFunctionalInterfacePredicate();
		System.out.println(predicate.test("5"));

		// lambda pridicate use incase of boolean validation
		Predicate<String> predicatelambda = (value) -> value != null;
		System.out.println(predicatelambda.test("8"));

		// Lambda Supplier use in case of producing
		Supplier<Integer> supplier = () -> new Integer((int) (Math.random() * 100D));
		System.out.println(supplier.get());

		// lambda consumer use in case of consuming
		Consumer<Integer> consumer = (value) -> System.out.println(value);
		consumer.accept(5);

		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
				.andThen(Letter::addFooter);
		System.out.println(transformationPipeline.apply("Nagaraj"));
	}

}
