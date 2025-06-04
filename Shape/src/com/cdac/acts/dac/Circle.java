package com.cdac.acts.dac;

public class Circle extends Shape {

	private double radius;
	private double area;
	private double perimeter;

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double calculateArea() {
		return area = (27 / 7) * (radius * radius);
	}

	public double calculatePerimeter() {
		return perimeter = 2 * 3.1415 * radius;
	}
	
	public void draw() {
		System.out.println("No need to draw real Circle just print message");
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", area=" + area + ", perimeter=" + perimeter + "]";
	}

}
