package com.javanext.tutorial.streams.com;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Nagaraj
 *
 */
public class DishTesting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.VEG), new Dish("rice", true, 350, Dish.Type.VEG),
				new Dish("season fruit", true, 120, Dish.Type.VEG), new Dish("pizza", true, 550, Dish.Type.VEG),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

		List<String> dishfilter = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName).limit(3)
				.collect(toList());
		System.out.println(dishfilter);

		List<String> names = menu.stream().filter(dish -> {
			System.out.println("filtering:" + dish.getName());
			return dish.getCalories() > 300;
		}).map(dish -> {
			System.out.println("mapping:" + dish.getName());
			return dish.getName();
		}).limit(3).collect(toList());

		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		// Distinct
		numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
		// Skipping
		List<Dish> skip = menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());
		// Map
		List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());
		List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
		List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
		// Flat Map
		List<String> uniqueCharacters = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct()
				.collect(toList());
		// Any match
		boolean anyMatch = menu.stream().anyMatch(d -> d.getType() == Dish.Type.VEG);

		boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);

		boolean isHealthyNot = menu.stream().noneMatch(d -> d.getCalories() >= 1000);

		Optional<Dish> findAny = menu.stream().filter(d -> d.getType() == Dish.Type.VEG).findAny();
		// Reduce
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		//max
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		System.out.println(max.get());

	}

}
