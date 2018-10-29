package vehicle;

public class Position {

	private long timestamp;
	private String sessionid;
	private String vehicleid;
	private double latitude;
	private double longitude;
	private int heading;

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(long timestamp, String vehicleid, String sessionid, double latitude, double longitude,
			int heading) {
		this.timestamp = timestamp;
		this.vehicleid = vehicleid;
		this.sessionid = sessionid;
		this.latitude = latitude;
		this.longitude = longitude;
		this.heading = heading;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getSessionid() {
		return sessionid;
	}

	public String getVehicleid() {
		return vehicleid;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public int getHeading() {
		return heading;
	}

	public String[] getSessionsByvehicleId() {
		String result[] = { "6bc6a660dfef4010ded079865f358e30", "ef0f515c3b19e177fb67a5b51b736d71" };
		return result;
	}

}
