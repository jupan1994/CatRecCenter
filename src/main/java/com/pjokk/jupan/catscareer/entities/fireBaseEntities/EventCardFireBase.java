package com.pjokk.jupan.catscareer.entities.fireBaseEntities;

/**
 * Created by jupan on 6/29/17.
 */

public class EventCardFireBase {
	private String title;
	private String description;
	private String picture;
	private boolean video;
	private String url;
	private String webUrl;

	public EventCardFireBase() {
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getPicture() {
		return picture;
	}

	public boolean isVideo() {
		return video;
	}

	public String getUrl() {
		return url;
	}

	public String getWebUrl() {
		return webUrl;
	}
}
