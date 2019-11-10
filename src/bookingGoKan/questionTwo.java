package bookingGoKan;

import bookingGoKan.supplierDetailsModel;
import bookingGoKan.supplierOptionsModel;
import bookingGoKan.locationModel;
import bookingGoKan.customRideModel;

import bookingGoKan.fulfilmentSearchEngine;
import bookingGoKan.objectFormatter;

import java.net.*;
import java.util.*;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import spark.Spark;
import static spark.Spark.*;

public class questionTwo {
	
	private static String daveAPI = "https://techtest.rideways.com/dave/";
	private static String ericAPI = "https://techtest.rideways.com/eric/";
	private static String jeffAPI = "https://techtest.rideways.com/jeff/";
	
	private static fulfilmentSearchEngine daveEricJeff;
	private static objectFormatter newObject;
	
	public questionTwo() {
		
		Spark.get("/", "application/json", (request,response)->{

			daveEricJeff.inputSupplierAPI(daveAPI);
			daveEricJeff.inputSupplierAPI(ericAPI);
			daveEricJeff.inputSupplierAPI(jeffAPI);

            response.type("application/json");

            String pickUp = request.queryParams("pickup");
            String dropOff = request.queryParams("dropoff");
            String numberOfPassengers = request.queryParams("passengers");

          
            LocationModel pickup = extractLocation(pickUp);
            locationModel dropoff = extractLocation(dropOff);

           
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
            
            return gson.toJson(newObject.daveEricJeffResult());
	});

	public static void main(String[] args) {
		
		
		questionTwo two = new questionTwo();

	}

}
