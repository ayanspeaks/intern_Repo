package com.test;

public class CollectionExceptionTest {
    public static void main(String[] args) {
        CollectionHandler collection = new CollectionHandler();
        
        // Adding elements
        collection.addElement("Apple");
        collection.addElement("Banana");
        collection.addElement("Cherry");

        // Display elements
        collection.displayElements();

        try {
            // Valid index
            System.out.println("Element at index 1: " + collection.getElement(1));
            
            // Invalid index (throws exception)
            System.out.println("Element at index 5: " + collection.getElement(5));
        } catch (CollectionException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }
    }
}
