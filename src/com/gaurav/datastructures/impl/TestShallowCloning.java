package com.gaurav.datastructures.impl;

public class TestShallowCloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		Department dept = new Department(1, "Human Resource");
		Employee original = new Employee(1, "Admin", dept);

		// Lets create a clone of original object
		Employee cloned = (Employee) original.clone();

		// Let verify using employee id, if cloning actually workded
		System.out.println("Cloned employee id: " + cloned.getEmpoyeeId());

		// Verify JDK's rules

		// Must be true and objects must have different memory addresses
		System.out.println("Does original and cloned have different addresses: " + (original != cloned));

		// As we are returning same class; so it should be true
		System.out.println("Are original and cloned instances of same clas: " + (original.getClass() == cloned.getClass()));

		// Default equals method checks for references so it should be false. If we want
		// to make it true,
		// then we need to override equals method in Employee class.
		System.out.println("Default equals check: " + (original.equals(cloned)));

		/********* ORIGINAL AND CLONED BOTH CHANGE ******************/
		Department hr = new Department(1, "Human Resource");
		Employee original2 = new Employee(1, "Admin", hr);
		Employee cloned2 = (Employee) original2.clone();

		// Let change the department name in cloned object and we will verify in
		// original object
		cloned2.getDepartment().setName("Finance");

		System.out.println("Name of original department : " + (original2.getDepartment().getName()));
		System.out.println("Name of cloned department : " + (cloned2.getDepartment().getName()));
	}
}
