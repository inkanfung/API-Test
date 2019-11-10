package bookingGoKan;

import java.util.*;
import java.io.*;
import java.net.*;

import com.google.gson.*;

public class fulfilmentSearchEngine{

	//returns information from api call to be added to the objectFormatter class's list
	private static objectFormatter objectResult;
	
	//request to call getOption to put in objectRusults class in a customized format
	private static supplierDetailsModel request;
	
	//returns information to the supplierDetail Model class in a de-serialized manner
	private static supplierDetailsModel SupplierDetailsModel;
	
	//accessories for reading the url and making the api connection
	private static customRideModel formatResult;
	private static HttpURLConnection connection;
	private static URL url;
	private static ArrayList<String> supplierApiLink = new ArrayList<String>();
	
	
	//initialize GSON builder to map JSON object called from API response
	private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
	
	
	public fulfilmentSearchEngine() {}
	
	
	public void inputSupplierAPI(String supplierLink) {
		supplierApiLink.add(supplierLink);
	}
	
	
	public static String urlBuilder(String supplierApiLink, locationModel pickup, locationModel dropoff ) {
		//method that builds our URL to be established in the http API connection
		StringBuilder buildUrl = new StringBuilder(supplierApiLink)
		.append("?pickup=").append(pickup.getLatitude()).append(",").append(pickup.getLongitude())
		.append("&")
		.append("dropoff=").append(dropoff.getLatitude()).append(",").append(dropoff.getLongitude());
				
		return buildUrl.toString();
	}
	
	
	public static objectFormatter userInput(locationModel pickup, locationModel dropoff, int numberOfPassenger) {
		
		
		objectResult = new objectFormatter();
		request = new supplierDetailsModel();
		customRideModel formatResult = null;
		
		for(int i = 0; i < supplierApiLink.size(); i++) {
			try {
				//requesting the api connection URL would have populated the supplierDetailsModel + supplierOptionsModel
				request = APIconnection(url = new URL(urlBuilder(supplierApiLink.get(i), pickup, dropoff)));
				for(supplierOptionsModel optionResult: request.getOptions()) {
					/* The for loop is most important as it transfers all the information 
					 *  from the data model classes to store in an ArrayList 
					 *  in objectFormatter class to be processed and print as relevant output
					 */
					objectResult.getOutputList().add(formatResult = new customRideModel(optionResult.getCarType(), request.getSupplierID(), optionResult.getPrice()));
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//filters out excess number of passenger + sorts result in price descending order
		objectResult.processed(numberOfPassenger);
		
		return null;
	}
	
	
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
		
			/*map JSON content from responseFromApi to the supplierDetailModel objects
			 * also known as de-serializing the response
			 * GSON library has a special builder that does it with ease
			 */
			
			SupplierDetailsModel = gson.fromJson(object.toString(), supplierDetailsModel.class);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return SupplierDetailsModel;
	}
	
}