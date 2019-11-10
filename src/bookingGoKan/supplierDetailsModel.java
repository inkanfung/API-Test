package bookingGoKan;

import java.util.*;
import com.google.gson.*;
import com.google.gson.annotations.*;

/*SerializedName and Expose are annotations part of the gson library.
	Essential for allow serialisation and deserialisation of variables*/

public class supplierDetailsModel {
	
	/* The response from the API returns a certain variable type and format type
	 * these can be viewed by pressing on the API link on the instruction page 
	 * this model class holds the information returned + send forward through request
	 */
	
	@SerializedName("supplier_id")
    @Expose(serialize = true, deserialize = true)
	private String supplier_id;
	
	//@SerializedName is used for Gson to map the JSON keys with our fields
	
	@SerializedName("pickup")
	@Expose(serialize = true, deserialize = true)
	private String pickup;
	
	//@Expose is used to allow or disallow serialization and deserialization
	
	@SerializedName("dropoff")
	@Expose(serialize = true, deserialize = true)
	private String dropoff;
	
	@SerializedName("options")
	@Expose(serialize = true, deserialize = true)
	private ArrayList<supplierOptionsModel> options = new ArrayList<supplierOptionsModel>();
	
	public supplierDetailsModel() {}

	public String getSupplierID(){
		return supplier_id;
	}
	
	public String getPickUp(){
		return pickup;
	}
	
	public String getDropOff(){
		return dropoff;
	}
	
	public ArrayList<supplierOptionsModel> getOptions(){
		return options;
	}
	
	public void setOptions(ArrayList<supplierOptionsModel> options){
		this.options = options;
	}
	
}
