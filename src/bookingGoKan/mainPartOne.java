package bookingGoKan;

public class mainPartOne {

	private static String daveAPI = "https://techtest.rideways.com/dave/";
	private static fulfilmentSearchEngine dave;
	private static objectFormatter newObject;
	private static locationModel pickup;
	private static locationModel dropoff;
	private static int numberOfPassenger;
	
	public mainPartOne() {}
	
	public static void main(String[] args) {
		
		dave = new fulfilmentSearchEngine();
		dave.inputSupplierAPI(daveAPI);
		pickup = new locationModel(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
		dropoff = new locationModel(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
		numberOfPassenger = Integer.parseInt(args[4]);
		
		newObject = fulfilmentSearchEngine.userInput(pickup, dropoff, numberOfPassenger);
		newObject.daveResult();
		
	}

}
