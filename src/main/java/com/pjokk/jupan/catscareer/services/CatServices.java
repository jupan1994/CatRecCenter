package com.pjokk.jupan.catscareer.services;

import com.pjokk.jupan.catscareer.entities.Cat;

import java.util.List;

/**
 * Created by jupan on 6/26/17.
 */

public class CatServices {

	public CatServices() {
	}

	public static class SearchCatRequest {
		public String fireBaseUrl;

		public SearchCatRequest(String fireBaseUrl) {
			this.fireBaseUrl = fireBaseUrl;
		}
	}

	public static class SearchCatResponse {
		public List<Cat> cats;
	}

}
