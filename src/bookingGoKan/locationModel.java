package bookingGoKan;

public class locationModel {

	private double latitude;
	private double longitude;
	
	public locationModel(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
}
