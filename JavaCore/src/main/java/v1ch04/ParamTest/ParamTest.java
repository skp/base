package v1ch04.ParamTest;

import java.util.ArrayList;
import java.util.List;

/**
 * This program demonstrates parameter passing in Java.
 *
 * @author Cay Horstmann
 * @version 1.00 2000-01-27
 */
public class ParamTest {
	
	public static void main(String[] args) {
		/*
		 * Test 1: Methods can't modify numeric parameters
		 */
		System.out.println("Testing tripleValue:");
		double percent = 10;
		System.out.println("Before: percent=" + percent);
		tripleValue(percent);
		System.out.println("After: percent=" + percent);
		
		/*
		 * Test 2: Methods can change the state of object parameters
		 */
		System.out.println("\nTesting tripleSalary:");
		Employee harry = new Employee("Harry", 50000);
		System.out.println("Before: salary=" + harry.getSalary());
		tripleSalary(harry);
		System.out.println("After: salary=" + harry.getSalary());
		
		/*
		 * Test 3: Methods can't attach new objects to object parameters
		 */
		System.out.println("\nTesting swap:");
		Employee a = new Employee("Alice", 70000);
		Employee b = new Employee("Bob", 60000);
		System.out.println("Before: a=" + a.getName());
		System.out.println("Before: b=" + b.getName());
		swap(a, b);
		System.out.println("After: a=" + a.getName());
		System.out.println("After: b=" + b.getName());
		
		List<String> li = new ArrayList<>();
		li.add("bb");
		addL(li);
		for (String s : li) {
			System.out.println(s);
		}
	}
	
	private static void tripleValue(double x) { // doesn't work
		
		x = 3 * x;
		System.out.println("End of method: x=" + x);
	}
	
	private static void tripleSalary(Employee x) { // works
		
		x.raiseSalary(200);
		System.out.println("End of method: salary=" + x.getSalary());
	}
	
	private static void swap(Employee x, Employee y) {
		Employee temp = x;
		x = y;
		y = temp;
		System.out.println("End of method: x=" + x.getName());
		System.out.println("End of method: y=" + y.getName());
	}
	
	private static void addL(List<String> list) {
//		list.add("aaa");
		list = null;
	}
	
}

class Employee { // simplified Employee class
	
	private String name;
	private double salary;
	
	public Employee(String n, double s) {
		name = n;
		salary = s;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
