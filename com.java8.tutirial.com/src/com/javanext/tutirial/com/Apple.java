package com.javanext.tutirial.com;

/**
 * @author Nagaraj
 *
 */
public class Apple {
	private int weight = 0;
	private String colour = "";

	/**
	 * @param weight
	 * @param colour
	 */
	public Apple(int weight, String colour) {
		super();
		this.weight = weight;
		this.colour = colour;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return String.format("Apple [weight=%s, colour=%s]", weight, colour);
	}
}
