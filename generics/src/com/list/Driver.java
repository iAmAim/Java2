package com.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>();
		list.add("asdf");

		System.out.println("\n\n Playing with Get and PUt principle");
		Driver driver = new Driver();
		// Add Contractors
		List<Contractor> contractorList = new ArrayList<>();
		Contractor contractor1 = driver.new Contractor("C.Nick");
		contractorList.add(contractor1);
		printList(contractorList);

		// Add Interns
		List<Intern> internList = new ArrayList<>();
		Intern intern = driver.new Intern("Intern.Sally");
		internList.add(intern);
		printList(internList);

		// Use Generics to copy any List<Subclass> to a list<Superclass>
		List<Contractor> contractorSource = new ArrayList<>();
		List<Person> personDestination = new ArrayList<>();

		contractorSource.add(driver.new Contractor("Edgar the Contractor"));

		copyList(contractorSource, personDestination);
		printList(personDestination);

	}

	public static <T> void copyList(List<? extends T> src, List<? super T> dest) {
		for (T t : src) {
			dest.add(t);
		}
	}

	public static <T> void printList(List<T> list) {
		System.out.println("\nList contains");
		for (T t : list) {
			System.out.println(t);
		}

	}

	class Person {
		String name;

		Person(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Some Person named " + name;
		}

	}

	class Employee extends Person {

		Employee(String name) {
			super(name);
		}
	}

	class Contractor extends Employee {

		Contractor(String name) {
			super(name);
		}
	}

	class Partimer extends Employee {

		Partimer(String name) {
			super(name);
		}
	}

	class Intern extends Employee {

		public Intern(String name) {
			super(name);
		}

		@Override
		public String toString() {

			return "Some Intern named " + super.name;
		}
	}

}
