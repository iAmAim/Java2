package com.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayList<T> implements Iterable<T> {
	
	public static final int MAX_ITEMS = 10;
	List<T> myList =  new ArrayList<>();
	public void add(T t){
		myList.add(t);
	}
	
	public void remove(T t){
		myList.remove(t);
	}
	
	public void get(int index){
		myList.get(index);
	}

	@Override
	public Iterator<T> iterator() {
	    Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < myList.size() && myList.get(currentIndex)!= null;
            }

            @Override
            public T next() {
                return myList.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
	}
}
