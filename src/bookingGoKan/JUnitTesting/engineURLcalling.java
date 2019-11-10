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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class engineURLcalling {

	
	private static String correctURL = "https://techtest.rideways.com/dave/?pickup=5.0,-2.0&dropoff=2.0,-2.0";
	private static objectFormatter obj = new objectFormatter();
	private static HttpURLConnection connection;
	private static supplierDetailsModel SupplierDetailsModel;
	private static customRideModel formatResult;
	private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
	
public static supplierDetailsModel APIconnection(URL url) throws IOException {
		
		StringBuilder object;
		BufferedReader reader;
		String line;
		
		try {
			//establish an open connection to the url 
			connection = (HttpURLConnection)url.openConnection();
			//the objective said to wait 2 seconds for API to respond		
			connection.setConnectTimeout(2000);
		
			//creating reader for the object
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			object = new StringBuilder();
		
			while((line = reader.readLine()) != null) {
				object.append(line);
			}
		
			reader.close();
		
			SupplierDetailsModel = gson.fromJson(object.toString(), supplierDetailsModel.class);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return SupplierDetailsModel;
	}
	
	@Test
	public void testURLcalling() {
		try {
		supplierDetailsModel request = new supplierDetailsModel();
		URL url = new URL(correctURL);
		request = APIconnection(url);	
		
		for(supplierOptionsModel optionResult: request.getOptions()) {
			
			obj.getOutputList().add(formatResult = new customRideModel(optionResult.getCarType(), request.getSupplierID(), optionResult.getPrice()));
		}
		
		assertTrue(obj.getOutputList().size() > 0);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
