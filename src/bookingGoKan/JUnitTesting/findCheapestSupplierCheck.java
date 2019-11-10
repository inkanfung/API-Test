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

public class findCheapestSupplierCheck {

	private static fulfilmentSearchEngine test = new fulfilmentSearchEngine();
	private static objectFormatter obj = new objectFormatter();
	
	customRideModel sampleOne;
	customRideModel sampleTwo;
	customRideModel sampleThree;
	customRideModel samplefour;
	
	@Test
	public void findCheapestCheck() {
		try {
			
			String exampleCarModel = "STANDARD";
			
			sampleOne = new customRideModel(exampleCarModel, "SomeSupplier1", 66.0);
			sampleTwo = new customRideModel(exampleCarModel, "SomeSupplier1", 2.0);
			sampleThree = new customRideModel(exampleCarModel, "SomeSupplier1", 3.0);
			samplefour = new customRideModel(exampleCarModel, "SomeSupplier1", 4.0);
			
			obj.getOutputList().add(sampleOne);
			obj.getOutputList().add(sampleTwo);
			obj.getOutputList().add(sampleThree);
			obj.getOutputList().add(samplefour);
			
			customRideModel test = obj.findCheapestOption(exampleCarModel);
			
			assertTrue(test.getPrice() == 2.0);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	

}
