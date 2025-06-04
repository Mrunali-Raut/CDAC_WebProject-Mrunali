package com.cdac.acts.dac;

public abstract class Shape {

	private double area;
	private double perimeter;

	public Shape() {
		super();
	}

	public Shape(double area, double perimeter) {
		super();
		this.area = area;
		this.perimeter = perimeter;
	}

	public abstract double calculateArea();

	public abstract double calculatePerimeter();

	@Override
	public String toString() {
		return "Shape [area=" + area + ", perimeter=" + perimeter + "]";
	}

}
