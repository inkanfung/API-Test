package bookingGoKan;

public class mainPartOneContinue {
	
	private static String daveAPI = "https://techtest.rideways.com/dave/";
	private static String ericAPI = "https://techtest.rideways.com/eric/";
	private static String jeffAPI = "https://techtest.rideways.com/jeff/";
	private static fulfilmentSearchEngine daveEricJeff;
	private static objectFormatter newObject;
	private static locationModel pickup;
	private static locationModel dropoff;
	private static int numberOfPassenger;

	public mainPartOneContinue() {}
	
	public static void main(String[] args) {
		daveEricJeff = new fulfilmentSearchEngine();
		daveEricJeff.inputSupplierAPI(daveAPI);
		daveEricJeff.inputSupplierAPI(jeffAPI);
		daveEricJeff.inputSupplierAPI(ericAPI);
		pickup = new locationModel(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
		dropoff = new locationModel(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
		numberOfPassenger = Integer.parseInt(args[4]);
		
		newObject = fulfilmentSearchEngine.userInput(pickup, dropoff, numberOfPassenger);
		newObject.daveEricJeffResult();

	}

}
