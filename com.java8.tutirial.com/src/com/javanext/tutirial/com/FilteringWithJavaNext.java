package com.javanext.tutirial.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Nagaraj
 *
 */
public class FilteringWithJavaNext {

	public static void main(String... args) {

		List<Apple> inventory = Arrays.asList(new Apple(5, "Green"), new Apple(8, "Green"), new Apple(8, "Red"));
		List<Apple> greenApples = filterApples(inventory, FilteringWithJavaNext::isGreen);
		System.out.println(greenApples);
		List<Apple> heavyApple = filterApples(inventory, FilteringWithJavaNext::isHeavyApple);
		System.out.println(heavyApple);

	}

	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple a : inventory) {
			if (p.test(a)) {
				result.add(a);
			}
		}
		return result;
	}
	public static boolean isGreen(Apple a) {
		return "Green".equals(a.getColour());		
	}
	public static boolean isHeavyApple(Apple a) {
		return a.getWeight()>5;
	}

}
