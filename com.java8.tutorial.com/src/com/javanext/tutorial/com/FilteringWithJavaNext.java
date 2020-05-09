package com.javanext.tutorial.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
		//lambda experssion
		inventory.sort((a1, a2) -> Integer.valueOf(a1.getWeight()).compareTo(Integer.valueOf(a2.getWeight())));
		Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getWeight());
		//method reference 
		inventory.sort(Comparator.comparing(Apple::getWeight));
	}

	public static <T> List<T> filterApples(List<T> inventory, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T a : inventory) {
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
		return a.getWeight() > 5;
	}

}
