package bookingGoKan.JUnitTesting;

import bookingGoKan.supplierDetailsModel;
import bookingGoKan.supplierOptionsModel;
import bookingGoKan.locationModel;
import bookingGoKan.customRideModel;

import bookingGoKan.fulfilmentSearchEngine;
import bookingGoKan.objectFormatter;

import java.io.*;
import java.net.*;
import java.util.*;

import org.junit.*;
import junit.framework.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class objectProcessingCheck1 {

	
	private static fulfilmentSearchEngine test = new fulfilmentSearchEngine();
	private static objectFormatter obj = new objectFormatter();
	
	customRideModel sampleOne;
	customRideModel sampleTwo;
	customRideModel sampleThree;
	
	@Test
	public void priceDescendCheck() {
		try {
			int someNumber = 3;
			
			sampleOne = new customRideModel("SomeCar1", "SomeSupplier1", 50.0);
			sampleTwo = new customRideModel("SomeCar2", "SomeSupplier2", 10.0);
			sampleThree = new customRideModel("SomeCar3", "SomeSupplier3", 50000.0);
			
			obj.getOutputList().add(sampleOne);
			obj.getOutputList().add(sampleTwo);
			obj.getOutputList().add(sampleThree);
			
			obj.processed(someNumber);
			
			assertTrue(obj.getOutputList().get(0).getPrice() == 5000.0);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
}
