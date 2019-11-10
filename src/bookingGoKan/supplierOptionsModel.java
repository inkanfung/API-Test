package bookingGoKan;

import java.util.*;
import com.google.gson.*;
import com.google.gson.annotations.*;

/*SerializedName and Expose are annotations part of the gson library.
	Essential for allow serialisation and deserialisation of variables*/

public class supplierOptionsModel {
	
	/* Extends supplerDetailsModel type<supplierOptionsModel> options ArrayList
	 * Options has 2 additional informations car type and price
	 */
	
	@SerializedName("car_type")
	@Expose(serialize = true, deserialize = true)
	private String carType;
	 
	@SerializedName("price")
	@Expose(serialize = true, deserialize = true)
	private double price;
	
	public supplierOptionsModel(String carType, double price) {
		this.carType = carType;
		this.price = price;
	}
	
	public String getCarType() {
		return carType;
	}
	
	public double getPrice() {
		return price;
	}
	
}
