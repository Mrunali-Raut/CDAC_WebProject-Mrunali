package com.cdac.acts.dac.test;

import com.cdac.acts.dac.Shape;

public class Rectangle extends Shape {

	private double length;
	private double breadth;
	private double area;
	private double perimeter;

	public Rectangle() {
		super();
	}

	public Rectangle(double length, double breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}

	public double calculateArea() {
		return area = length * breadth;
	}

	public double calculatePerimeter() {
		return 2 * (length + breadth);
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", breadth=" + breadth + ", area=" + area + ", perimeter=" + perimeter
				+ "]";
	}

}
