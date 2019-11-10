package bookingGoKan;

public class customRideModel {

	/*This model class collects the variable and displays in a custom format
	 * according to the objectives part 1a needs format car type + price
	 * and part 1b needs format car type, supplier and price
	 * easy to choose format by using this model data class
	 */
	
	private String carType;
	private String supplier;
	private double price;
	
	public customRideModel(String carType, String supplier, Double price) {
		this.carType = carType;
		this.supplier = supplier;
		this.price = price;
	}
	
	public String getCarType() {
		return carType;
	}
	
	public String getSupplier() {
		return supplier;
	}
	
	public double getPrice() {
		return price;
	}
}