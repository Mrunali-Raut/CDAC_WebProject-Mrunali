package com.cdac.acts.dac.test;

import java.util.Scanner;

import com.cdac.acts.dac.Circle;
import com.cdac.acts.dac.Shape;

public class ShapeTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter radius of the circle: ");
		double rad = sc.nextDouble();

		Shape cShape = new Circle(rad);
		System.out.println("Area of circle: " + cShape.calculateArea());
		System.out.println("Permeter of circle: " + cShape.calculatePerimeter());

		System.out.println("Enter the length and the breadth of the rectangle : ");
		double length = sc.nextDouble();
		double breadth = sc.nextDouble();

		Shape rShape = new Rectangle(length, breadth);
		System.out.println("Area of rectangle: " + rShape.calculateArea());
		System.out.println("Perimeter of rectangle: " + rShape.calculatePerimeter());
		sc.close();
		
	}
}
