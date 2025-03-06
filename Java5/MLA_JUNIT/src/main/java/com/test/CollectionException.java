package com.test;

import java.util.ArrayList;
import java.util.List;

// Custom exception class
public class CollectionException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CollectionException(String message) {
        super(message);
    }
}

// Collection class with exception handling
class CollectionHandler {
    private List<String> list;

    public CollectionHandler() {
        list = new ArrayList<>();
    }

    // Method to add an element
    public void addElement(String element) {
        list.add(element);
    }

    // Method to get an element with exception handling
    public String getElement(int index) throws CollectionException {
        if (index < 0 || index >= list.size()) {
            throw new CollectionException("Index out of bounds: " + index);
        }
        return list.get(index);
    }

    // Method to display elements
    public void displayElements() {
        System.out.println("Collection Elements: " + list);
    }
}