package com.pjokk.jupan.catscareer.entities.fireBaseEntities;

/**
 * Created by jupan on 6/30/17.
 */

public class RushFireBase {
	private String name;
	private String date;
	private String time;
	private String location;
	private double latitude;
	private double longitude;
	private boolean campus;
	private String description;
	private boolean isWeb;
	private String url;

	private RushFireBase() {

	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getLocation() {
		return location;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public boolean isCampus() {
		return campus;
	}

	public String getDescription() {
		return description;
	}

	public boolean isWeb() {
		return isWeb;
	}

	public String getUrl() {
		return url;
	}
}
