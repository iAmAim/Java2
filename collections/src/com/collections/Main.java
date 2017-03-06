package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		
		List<String> stringList = new ArrayList<>();
		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		
		// Using iterator 
		Iterator<String> it = stringList.iterator();
		while(it.hasNext()){			
			System.out.println(""+ it.next());
		}
		
		// using enhanced for loop
		System.out.println("\n");
		for(String str : stringList){
			System.out.println(str);
		}
		
		// using normal loop to print in reverse
		System.out.println("\n");
		for(int i= stringList.size()-1; i>=0; i--){
			System.out.println(stringList.get(i));
		}
		
		//using Collections.reverse to print in reverse
		Collections.reverse(stringList);	
		System.out.println("\n");
		for(String str : stringList){
			System.out.println(str);
		}

	}
}
