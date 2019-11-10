package bookingGoKan;

import java.util.*;
import java.util.Map.Entry;

public class objectFormatter {
	//takes all information from the data model class and stores it here
	private static ArrayList<customRideModel> outputList = new ArrayList<customRideModel>();
	
	//provided by task
	private static Map<String, Integer> maximumPassenger = new HashMap<String, Integer>();
	private static Double minSetPrice = Double.MAX_VALUE;
	
	public objectFormatter(){}
	
	//allows access to the list by other class e.g.fulfilmentSearchEngine
	public ArrayList<customRideModel> getOutputList(){
		return outputList;
	}	
	
	public void processed(int numberOfPassenger) {
		maximumPassenger.put("STANDARD", 4);
    	maximumPassenger.put("EXECUTIVE", 4);
    	maximumPassenger.put("LUXURY", 4);
    	maximumPassenger.put("PEOPLE_CARRIER", 6);
    	maximumPassenger.put("LUXURY_PEOPLE_CARRIER", 6);
    	maximumPassenger.put("MINIBUS", 16);
		
    	//removes the car type if the price of number of passenger exceeds the map provided
		outputList.removeIf(a -> numberOfPassenger > maximumPassenger.get(a.getCarType()));
		//sort the price order from most expensive to most cheap	
    	outputList.sort((b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice()));
	}
	
	public static void daveResult() {
		for(customRideModel modelR: outputList) {
			System.out.println(modelR.getCarType() + " - " + modelR.getPrice());
		}
	}
	
	
	public static customRideModel findCheapestOption(String carType) {
		
		customRideModel cheapestSupplier = null;
		
		for (customRideModel lowerCostviaCar: outputList)
        {
			//2 conditions if car type of the actual list matches the maximum passenger array
            if (lowerCostviaCar.getCarType().equals(carType)) {
            	/*maxSetPrice is double MAX value nothing will be bigger than this value
            	 * if current price is not bigger than maximum double value
            	 * then minimum set price is the new current price until end of list
            	 */
                if(lowerCostviaCar.getPrice() < minSetPrice) {
                	minSetPrice = lowerCostviaCar.getPrice();
                	cheapestSupplier = lowerCostviaCar;
                }
            }
        }
		return cheapestSupplier;
	}
	
	public static void daveEricJeffResult() {
		
		customRideModel cheapestSupplier = null;
		
		Iterator<Entry<String, Integer>> it = maximumPassenger.entrySet().iterator();
		while (it.hasNext()) {
			/* loops through the car type values of the maximum passenger
			 * and uses the find cheapest options method to filter out car type
			 * ultimately choose the cheapest price option
			 */
			
			Map.Entry<String, Integer> loopthroughMaxPassenger = (Map.Entry<String, Integer>) it.next();
				cheapestSupplier = findCheapestOption(loopthroughMaxPassenger.getKey());
				
				/* Sometimes there are empty suppliers for certain cars 
				 * without this if the program will crash
				 * so only prints if there is results
				 */
				if(cheapestSupplier != null) {
					
					
					System.out.println(cheapestSupplier.getCarType() + " - " + cheapestSupplier.getSupplier() + " - " + cheapestSupplier.getPrice());
				}
				
		}
        
	}
	
}
