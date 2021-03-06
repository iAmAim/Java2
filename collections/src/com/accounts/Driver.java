package com.accounts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Driver {

	static Account account1 = new Account(1, "Hesus", 999999.99);
	static Account account2 = new Account(2, "Kelly", 143.44);
	static Account account3 = new Account(3, "Aim", 214.99);

	public static void main(String[] args) {
		usingList();
		usingNestedClass();
		usingHashSet();
		usingSortedSetTreeSet();
		usingHashMap();

	}

	private static void usingList() {
		System.out.println("Using List");
		List<Account> accounts = new ArrayList<>();
		accounts.add(account3);
		accounts.add(account2);
		accounts.add(account1);

		System.out.println("Before Sorting");
		for (Account account : accounts) {
			System.out.println(account);
		}

		// Sort using: Account implements Comparable (compareTo)
		Collections.sort(accounts);

		System.out.println("\nAfter Sorting");
		for (Account account : accounts) {
			System.out.println(account);
		}
		
	}

	public static void usingNestedClass() {
		System.out.println("\nUsing Nested Class");
		List<Account> accounts = new ArrayList<>();
		accounts.add(account3);
		accounts.add(account2);
		accounts.add(account1);
		Collections.sort(accounts, new Account.AccountComparator());
		for (Account account : accounts) {
			System.out.println(account);
		}

	}

	public static void usingHashSet() {
		System.out.println("\n\nUsing HashSet");
		Set<Account> accountSet = new HashSet<>();
		accountSet.add(account1);
		accountSet.add(account2);
		accountSet.add(account3);

		Iterator<Account> it = accountSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void usingSortedSetTreeSet() {
		System.out.println("\n\nUsing TreeSet(SortedSet)");
		Set<Account> accountSet = new TreeSet<>();
		accountSet.add(account3);
		accountSet.add(account2);
		accountSet.add(account1);

		Iterator<Account> it = accountSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void usingHashMap() {
		System.out.println("\n\nUsing HashMap");
		Map<Integer, Account> accountMap = new HashMap<>();
		accountMap.put(account3.getId(), account3);
		accountMap.put(account1.getId(), account1);
		accountMap.put(account2.getId(), account2);
	

		for (Map.Entry<Integer, Account> entry : accountMap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

}
