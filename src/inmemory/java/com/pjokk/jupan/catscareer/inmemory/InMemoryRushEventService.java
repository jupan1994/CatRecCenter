package com.pjokk.jupan.catscareer.inmemory;

import com.pjokk.jupan.catscareer.entities.RushEvent;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.RushEventService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by jupan on 6/28/17.
 */

public class InMemoryRushEventService extends BaseInMemory {

	public InMemoryRushEventService(CatApplication catApplication) {
		super(catApplication);
	}

	@Subscribe
	public void getCommunityRushEvent(RushEventService.SearchRushEventCommunityRequest request) {
		RushEventService.SearchRushEventCommunityResponse response = new RushEventService.SearchRushEventCommunityResponse();
		response.communityRushEvents = new ArrayList<>();
		response.communityRushEvents.add(new RushEvent(
				1,
				"Rush Community Event 1",
				"06/28/2017",
				"8:00pm",
				"ECE Department",
				2.2,
				2.2,
				true,
				"This is where the description of the event goes."
		));
		bus.post(response);
	}

	@Subscribe
	public void getSocialRushEvent(RushEventService.SearchRushEventSocialRequest request) {
		RushEventService.SearchRushEventSocialResponse response = new RushEventService.SearchRushEventSocialResponse();
		response.socialRushEvents = new ArrayList<>();
		response.socialRushEvents.add(new RushEvent(
				1,
				"Rush Social Event 1",
				"06/28/2017",
				"8:00pm",
				"4500 N Oracle Rd, Tucson, AZ 85705",
				32.288179,
				-110.978125,
				false,
				"This is where the description of the event goes."
		));
		bus.post(response);
	}
}
