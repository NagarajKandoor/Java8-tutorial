package com.javanext.tutorial.lambda.com;

import java.util.function.Function;

/**
 * @author Nagaraj
 *
 */
public class BuiltInFunctionalInterfaceFunction implements Function<Long, Long>{

	@Override
	public Long apply(Long t) {
		return t+3;
	}

}
