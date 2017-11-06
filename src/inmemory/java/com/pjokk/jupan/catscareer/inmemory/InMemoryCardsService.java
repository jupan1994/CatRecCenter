package com.pjokk.jupan.catscareer.inmemory;

import com.pjokk.jupan.catscareer.entities.EventCard;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.EventCardService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by jupan on 6/27/17.
 */

public class InMemoryCardsService extends BaseInMemory {

	public InMemoryCardsService(CatApplication catApplication) {
		super(catApplication);
	}

	@Subscribe
	public void searchCommunityCards(EventCardService.SearchCommunityServiceCardsRequest request) {
		EventCardService.SearchCommunityServiceCardsResponse response = new EventCardService.SearchCommunityServiceCardsResponse();
		response.communityServiceCards = new ArrayList<>();
		response.communityServiceCards.add(new EventCard(
				1,
				"Community Event 1",
				"Community Event 1's description",
				"http://www.gravatar.com/avatar/" + 1 + "?d=identicon",
				false,
				"null"
		));
		response.communityServiceCards.add(new EventCard(
				2,
				"Community Event 2",
				"Community Event 2's description",
				"http://www.gravatar.com/avatar/" + 2 + "?d=identicon",
				true,
				"XmJtSoMWfas"
		));
		bus.post(response);
	}
	@Subscribe
	public void searchCatHoodCards(EventCardService.SearchCatHoodCardsRequst request) {
		EventCardService.SearchCatHoodServiceCardsResponse response = new EventCardService.SearchCatHoodServiceCardsResponse();
		response.catHoodCards = new ArrayList<>();
		response.catHoodCards.add(new EventCard(
				3,
				"Cat Hood Event 1",
				"Community Event 1's description",
				"http://www.gravatar.com/avatar/" + 3 + "?d=identicon",
				false,
				"null"
		));
		response.catHoodCards.add(new EventCard(
				4,
				"Cat Hood Event 2",
				"Cat Hood Event 2's description",
				"http://www.gravatar.com/avatar/" + 4 + "?d=identicon",
				true,
				"D190DxFsd04"
		));
		bus.post(response);
	}
	@Subscribe
	public void searchSocialCards(EventCardService.SearchSocialCardsRequest request) {
		EventCardService.SearchSocialCardsResponse response = new EventCardService.SearchSocialCardsResponse();
		response.socialCards = new ArrayList<>();
		response.socialCards.add(new EventCard(
				5,
				"Social Event 1",
				"Social Event 1's description",
				"http://www.gravatar.com/avatar/" + 5 + "?d=identicon",
				false,
				"null"
		));
		response.socialCards.add(new EventCard(
				6,
				"Social Event 2",
				"Social Event 2's description",
				"http://www.gravatar.com/avatar/" + 6 + "?d=identicon",
				true,
				"vqym6bThXO0"
		));
		bus.post(response);
	}
}
