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

public class engineURLtesting {

	private static locationModel pickup = new locationModel(5.0, -2.0);
	private static locationModel dropoff = new locationModel(2.0, -2.0);
		
	private static String correctURL = "https://techtest.rideways.com/dave/?pickup=5.0,-2.0&dropoff=2.0,-2.0";
	private static String daveAPI = "https://techtest.rideways.com/dave/";
	private static fulfilmentSearchEngine test = new fulfilmentSearchEngine();
	
	
	@Test
	public void testingBuildURL() {
		try {
		String url = test.urlBuilder(daveAPI, pickup, dropoff);
		assertEquals(correctURL, url);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	

}