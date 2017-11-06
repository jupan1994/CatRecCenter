package com.pjokk.jupan.catscareer.entities.fireBaseEntities;

/**
 * Created by jupan on 6/29/17.
 */

public class CatFireBase {
	private String name;
	private String bio;
	private String picture;
	private String major;
	private String graduateTime;
	private String position;
	private String company;

	private CatFireBase() {
	}

	public String getName() {
		return name;
	}

	public String getBio() {
		return bio;
	}

	public String getPicture() {
		return picture;
	}

	public String getMajor() {
		return major;
	}

	public String getGraduateTime() {
		return graduateTime;
	}

	public String getPosition() {
		return position;
	}

	public String getCompany() {
		return company;
	}
}
