package com.pjokk.jupan.catscareer.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jupan on 6/26/17.
 */

public class Cat implements Parcelable{

	private int catId;
	private String catName;
	private String catPosition;
	private String catCompany;
	private String catPicture;
	private String catMajor;
	private String catGraduateTime;
	private String catBio;

	public Cat(int catId, String catName, String catCompany, String catPosition, String catPicture, String catMajor, String catGraduateTime, String catBio) {
		this.catId = catId;
		this.catName = catName;
		this.catPosition = catPosition;
		this.catCompany = catCompany;
		this.catPicture = catPicture;
		this.catMajor = catMajor;
		this.catGraduateTime = catGraduateTime;
		this.catBio = catBio;
	}

	protected Cat(Parcel in) {
		catId = in.readInt();
		catName = in.readString();
		catCompany = in.readString();
		catPosition = in.readString();
		catPicture = in.readString();
		catMajor = in.readString();
		catGraduateTime = in.readString();
		catBio = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(catId);
		dest.writeString(catName);
		dest.writeString(catCompany);
		dest.writeString(catPosition);
		dest.writeString(catPicture);
		dest.writeString(catMajor);
		dest.writeString(catGraduateTime);
		dest.writeString(catBio);
	}

	public int getCatId() {
		return catId;
	}

	public String getCatName() {
		return catName;
	}

	public String getCatPosition() {
		return catPosition;
	}

	public String getCatCompany() {
		return catCompany;
	}

	public String getCatPicture() {
		return catPicture;
	}

	public String getCatMajor() {
		return catMajor;
	}

	public String getCatGrauateTime() {
		return catGraduateTime;
	}

	public String getCatBio() {
		return catBio;
	}

	public static final Creator<Cat> CREATOR = new Creator<Cat>() {
		@Override
		public Cat createFromParcel(Parcel in) {
			return new Cat(in);
		}

		@Override
		public Cat[] newArray(int size) {
			return new Cat[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}
}
