package com.pjokk.jupan.catscareer.services;

import com.pjokk.jupan.catscareer.entities.RushEvent;

import java.util.List;

/**
 * Created by jupan on 6/28/17.
 */

public class RushEventService {
	private RushEventService() {
	}

	public static class SearchRushEventCommunityRequest {
		public String fireBaseUrl;

		public SearchRushEventCommunityRequest(String fireBaseUrl) {
			this.fireBaseUrl = fireBaseUrl;
		}
	}

	public static class SearchRushEventCommunityResponse {
		public List<RushEvent> communityRushEvents;
	}

	public static class SearchRushEventSocialRequest {
		public String fireBaseUrl;

		public SearchRushEventSocialRequest(String fireBaseUrl) {
			this.fireBaseUrl = fireBaseUrl;
		}
	}

	public static class SearchRushEventSocialResponse {
		public List<RushEvent> socialRushEvents;
	}

	public static class SearchRushEventNewsRequest {
		public String fireBaseUrl;

		public SearchRushEventNewsRequest(String fireBaseUrl) {
			this.fireBaseUrl = fireBaseUrl;
		}
	}

	public static class SearchRushEventNewsResponse {
		public List<RushEvent> newsRushEvents;
	}



}
