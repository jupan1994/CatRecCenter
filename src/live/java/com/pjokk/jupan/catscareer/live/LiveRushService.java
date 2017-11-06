package com.pjokk.jupan.catscareer.live;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pjokk.jupan.catscareer.entities.RushEvent;
import com.pjokk.jupan.catscareer.entities.fireBaseEntities.RushFireBase;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.RushEventService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by jupan on 6/29/17.
 */

public class LiveRushService extends BaseLiveService {
	public LiveRushService(CatApplication application) {
		super(application);
	}

	@Subscribe
	public void getCommunityRushEvent(RushEventService.SearchRushEventCommunityRequest request) {
		final RushEventService.SearchRushEventCommunityResponse response = new RushEventService.SearchRushEventCommunityResponse();
		response.communityRushEvents = new ArrayList<>();

		final DatabaseReference reference = FirebaseDatabase.getInstance()
				.getReferenceFromUrl(request.fireBaseUrl);
		reference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				int index = 0;
				for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
					RushFireBase rushFireBase = dataSnapshot1.getValue(RushFireBase.class);
					RushEvent rushEvent = new RushEvent(
							index,
							rushFireBase.getName(),
							rushFireBase.getDate(),
							rushFireBase.getTime(),
							rushFireBase.getLocation(),
							rushFireBase.getLatitude(),
							rushFireBase.getLongitude(),
							rushFireBase.isCampus(),
							rushFireBase.getDescription(),
							rushFireBase.isWeb(),
							rushFireBase.getUrl()
					);
					response.communityRushEvents.add(rushEvent);
				}
				bus.post(response);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});
	}

	@Subscribe
	public void getSocialRushEvent(RushEventService.SearchRushEventSocialRequest request) {
		final RushEventService.SearchRushEventSocialResponse response = new RushEventService.SearchRushEventSocialResponse();
		response.socialRushEvents = new ArrayList<>();

		final DatabaseReference reference = FirebaseDatabase.getInstance()
				.getReferenceFromUrl(request.fireBaseUrl);
		reference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				int index = 0;
				for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
					RushFireBase rushFireBase = dataSnapshot1.getValue(RushFireBase.class);
					RushEvent rushEvent = new RushEvent(
							index,
							rushFireBase.getName(),
							rushFireBase.getDate(),
							rushFireBase.getTime(),
							rushFireBase.getLocation(),
							rushFireBase.getLatitude(),
							rushFireBase.getLongitude(),
							rushFireBase.isCampus(),
							rushFireBase.getDescription(),
							rushFireBase.isWeb(),
							rushFireBase.getUrl()
					);
					response.socialRushEvents.add(rushEvent);
				}
				bus.post(response);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});
	}

	@Subscribe
	public void getNewsRushEvent(RushEventService.SearchRushEventNewsRequest request) {
		final RushEventService.SearchRushEventNewsResponse response = new RushEventService.SearchRushEventNewsResponse();
		response.newsRushEvents = new ArrayList<>();

		final DatabaseReference reference = FirebaseDatabase.getInstance()
				.getReferenceFromUrl(request.fireBaseUrl);
		reference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				int index = 0;
				for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
					RushFireBase rushFireBase = dataSnapshot1.getValue(RushFireBase.class);
					RushEvent rushEvent = new RushEvent(
							index,
							rushFireBase.getName(),
							rushFireBase.getDate(),
							rushFireBase.getTime(),
							rushFireBase.getLocation(),
							rushFireBase.getLatitude(),
							rushFireBase.getLongitude(),
							rushFireBase.isCampus(),
							rushFireBase.getDescription(),
							rushFireBase.isWeb(),
							rushFireBase.getUrl()
					);
					response.newsRushEvents.add(rushEvent);
				}
				bus.post(response);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});
	}
}
