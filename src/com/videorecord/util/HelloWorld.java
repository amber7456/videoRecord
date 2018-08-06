package com.videorecord.util;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		boolean alive = true;

		while (alive) {
			eat();
			sleep();
			code();
		}

		Coffee coffee = new Coffee();
		if (coffee.Empty) {
			coffee.Refill();
		} else {
			coffee.Drink();
		}
	}

	public static void eat() {

	}

	public static void sleep() {

	}

	public static void code() {

	}

}
