package com.pjokk.jupan.catscareer.live;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pjokk.jupan.catscareer.entities.EventCard;
import com.pjokk.jupan.catscareer.entities.fireBaseEntities.EventCardFireBase;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.EventCardService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by jupan on 6/29/17.
 */

public class LiveCardService extends BaseLiveService {
	public LiveCardService(CatApplication application) {
		super(application);
	}

	@Subscribe
	public void searchCommunityCards(EventCardService.SearchCommunityServiceCardsRequest request) {
		final EventCardService.SearchCommunityServiceCardsResponse response = new EventCardService.SearchCommunityServiceCardsResponse();
		response.communityServiceCards = new ArrayList<>();

		DatabaseReference reference = FirebaseDatabase.getInstance()
				.getReferenceFromUrl(request.fireBaseUrl);
		reference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				int index = 1;
				for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
					EventCardFireBase eventCardFireBase = dataSnapshot1.getValue(EventCardFireBase.class);
					EventCard eventCard = new EventCard(
							index,
							eventCardFireBase.getTitle(),
							eventCardFireBase.getDescription(),
							eventCardFireBase.getPicture(),
							eventCardFireBase.isVideo(),
							eventCardFireBase.getUrl(),
							eventCardFireBase.getWebUrl()
					);
					response.communityServiceCards.add(eventCard);
					index++;
				}
				bus.post(response);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});
	}
	@Subscribe
	public void searchCatHoodCards(EventCardService.SearchCatHoodCardsRequst request) {
		final EventCardService.SearchCatHoodServiceCardsResponse response = new EventCardService.SearchCatHoodServiceCardsResponse();
		response.catHoodCards = new ArrayList<>();

		DatabaseReference reference = FirebaseDatabase.getInstance()
				.getReferenceFromUrl(request.fireBaseUrl);
		reference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				int index = 3;
				for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
					EventCardFireBase eventCardFireBase = dataSnapshot1.getValue(EventCardFireBase.class);
					EventCard eventCard = new EventCard(
							index,
							eventCardFireBase.getTitle(),
							eventCardFireBase.getDescription(),
							eventCardFireBase.getPicture(),
							eventCardFireBase.isVideo(),
							eventCardFireBase.getUrl(),
							eventCardFireBase.getWebUrl()
					);
					response.catHoodCards.add(eventCard);
					index++;
				}
				bus.post(response);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});


	}
	@Subscribe
	public void searchSocialCards(EventCardService.SearchSocialCardsRequest request) {
		final EventCardService.SearchSocialCardsResponse response = new EventCardService.SearchSocialCardsResponse();
		response.socialCards = new ArrayList<>();

		DatabaseReference reference = FirebaseDatabase.getInstance()
				.getReferenceFromUrl(request.fireBaseUrl);
		reference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				int index = 5;
				for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
					EventCardFireBase eventCardFireBase = dataSnapshot1.getValue(EventCardFireBase.class);
					EventCard eventCard = new EventCard(
							index,
							eventCardFireBase.getTitle(),
							eventCardFireBase.getDescription(),
							eventCardFireBase.getPicture(),
							eventCardFireBase.isVideo(),
							eventCardFireBase.getUrl(),
							eventCardFireBase.getWebUrl()
					);
					response.socialCards.add(eventCard);
					index++;
				}
				bus.post(response);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});

	}
}
