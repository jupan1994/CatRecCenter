package com.pjokk.jupan.catscareer.services;

import com.pjokk.jupan.catscareer.entities.EventCard;

import java.util.List;

/**
 * Created by jupan on 6/27/17.
 */

public class EventCardService {

	private EventCardService() {
	}

	public static class SearchCommunityServiceCardsRequest {
		public String fireBaseUrl;

		public SearchCommunityServiceCardsRequest(String fireBaseUrl) {
			this.fireBaseUrl = fireBaseUrl;
		}
	}

	public static class SearchCommunityServiceCardsResponse {
		public List<EventCard> communityServiceCards;
	}

	public static class SearchCatHoodCardsRequst {
		public String fireBaseUrl;

		public SearchCatHoodCardsRequst(String fireBaseUrl) {
			this.fireBaseUrl = fireBaseUrl;
		}
	}

	public static class SearchCatHoodServiceCardsResponse {
		public List<EventCard> catHoodCards;
	}

	public static class SearchSocialCardsRequest {
		public String fireBaseUrl;

		public SearchSocialCardsRequest(String fireBaseUrl) {
			this.fireBaseUrl = fireBaseUrl;
		}
	}

	public static class SearchSocialCardsResponse {
		public List<EventCard> socialCards;
	}


}
