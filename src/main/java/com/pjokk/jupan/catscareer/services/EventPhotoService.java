package com.pjokk.jupan.catscareer.services;

import com.pjokk.jupan.catscareer.entities.EventPicture;

import java.util.List;

/**
 * Created by jupan on 6/27/17.
 */

public class EventPhotoService {
	private EventPhotoService() {
	}

	public static class SearchCommunityPhotoRequest {
		public String fireBaseUrl;

		public SearchCommunityPhotoRequest(String fireBaseUrl) {
			this.fireBaseUrl = fireBaseUrl;
		}
	}

	public static class SearchCommunityPhotoResponse {
		public List<EventPicture> communityPhotos;
	}

	public static class SearchCatHoodPhotosRequest {
		public String fireBaseUrl;

		public SearchCatHoodPhotosRequest(String fireBaseUrl) {
			this.fireBaseUrl = fireBaseUrl;
		}
	}

	public static class SearchCatHoodPhotosResponse {
		public List<EventPicture> catHoodPhotos;
	}

	public static class SearchSocialPhotosRequest {
		public String fireBaseUrl;

		public SearchSocialPhotosRequest(String fireBaseUrl) {
			this.fireBaseUrl = fireBaseUrl;
		}
	}

	public static class SearchSocialPhotosResponse {
		public List<EventPicture> socialPhotos;
	}
}
