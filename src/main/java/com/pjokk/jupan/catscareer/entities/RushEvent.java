package com.pjokk.jupan.catscareer.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jupan on 6/28/17.
 */

public class RushEvent implements Parcelable {

	private int eventId;
	private String eventName;
	private String eventDate;
	private String eventTime;
	private String eventLocation;
	private double eventLatitude;
	private double eventLongitude;
	private boolean isOnCampus;
	private String eventDescription;
	private boolean isWeb;
	private String webUrl;

	public RushEvent(int eventId, String eventName, String eventDate, String eventTime, String eventLocation, double eventLatitude,
					 double eventLongitude, boolean isOnCampus, String eventDescription, boolean isWeb, String webUrl) {
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventLocation = eventLocation;
		this.eventLatitude = eventLatitude;
		this.eventLongitude = eventLongitude;
		this.isOnCampus = isOnCampus;
		this.eventDescription = eventDescription;
		this.isWeb = isWeb;
		this.webUrl = webUrl;
	}

	protected RushEvent(Parcel in) {
		eventId = in.readInt();
		eventName = in.readString();
		eventDate = in.readString();
		eventTime = in.readString();
		eventLocation = in.readString();
		eventLatitude = in.readDouble();
		eventLongitude = in.readDouble();
		isOnCampus = in.readByte() != 0;
		eventDescription = in.readString();
		isWeb = in.readByte() != 0;
		webUrl = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(eventId);
		dest.writeString(eventName);
		dest.writeString(eventDate);
		dest.writeString(eventTime);
		dest.writeString(eventLocation);
		dest.writeDouble(eventLatitude);
		dest.writeDouble(eventLongitude);
		dest.writeByte((byte) (isOnCampus ? 1: 0));
		dest.writeString(eventDescription);
		dest.writeByte((byte) (isWeb ? 1: 0));
		dest.writeString(webUrl);
	}

	public int getEventId() {
		return eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public double getEventLatitude() {
		return eventLatitude;
	}

	public double getEventLongitude() {
		return eventLongitude;
	}

	public boolean isOnCampus() {
		return isOnCampus;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public boolean isWeb() {
		return isWeb;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public static final Creator<RushEvent> CREATOR = new Creator<RushEvent>() {
		@Override
		public RushEvent createFromParcel(Parcel in) {
			return new RushEvent(in);
		}

		@Override
		public RushEvent[] newArray(int size) {
			return new RushEvent[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}
}
