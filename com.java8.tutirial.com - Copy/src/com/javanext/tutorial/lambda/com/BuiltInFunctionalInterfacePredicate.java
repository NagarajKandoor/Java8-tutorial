package com.javanext.tutorial.lambda.com;

import java.util.function.Predicate;

/**
 * @author Nagaraj
 *
 */
public class BuiltInFunctionalInterfacePredicate implements Predicate<String>{

	@Override
	public boolean test(String t) {
		return t!=null;
	}

}
