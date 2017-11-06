package com.pjokk.jupan.catscareer.live;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pjokk.jupan.catscareer.entities.EventCard;
import com.pjokk.jupan.catscareer.entities.EventPicture;
import com.pjokk.jupan.catscareer.entities.fireBaseEntities.EventCardFireBase;
import com.pjokk.jupan.catscareer.entities.fireBaseEntities.EventPictureFireBase;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.EventPhotoService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by jupan on 6/29/17.
 */

public class LivePictureService extends BaseLiveService {
	public LivePictureService(CatApplication application) {
		super(application);
	}

	@Subscribe
	public void getCommunityPhotos(EventPhotoService.SearchCommunityPhotoRequest request) {
		final EventPhotoService.SearchCommunityPhotoResponse response = new EventPhotoService.SearchCommunityPhotoResponse();
		response.communityPhotos = new ArrayList<>();

		DatabaseReference reference = FirebaseDatabase.getInstance()
				.getReferenceFromUrl(request.fireBaseUrl);
		reference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
					EventPictureFireBase eventPictureFireBase = dataSnapshot1.getValue(EventPictureFireBase.class);
					EventPicture eventPicture = new EventPicture(eventPictureFireBase.getUrl());
					response.communityPhotos.add(eventPicture);
				}
				bus.post(response);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});

	}

	@Subscribe
	public void getCatHoodPhotos(EventPhotoService.SearchCatHoodPhotosRequest request) {
		final EventPhotoService.SearchCatHoodPhotosResponse response = new EventPhotoService.SearchCatHoodPhotosResponse();
		response.catHoodPhotos = new ArrayList<>();

		DatabaseReference reference = FirebaseDatabase.getInstance()
				.getReferenceFromUrl(request.fireBaseUrl);
		reference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
					EventPictureFireBase eventPictureFireBase = dataSnapshot1.getValue(EventPictureFireBase.class);
					EventPicture eventPicture = new EventPicture(eventPictureFireBase.getUrl());
					response.catHoodPhotos.add(eventPicture);
				}
				bus.post(response);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});
	}

	@Subscribe
	public void getSocailPhotos(EventPhotoService.SearchSocialPhotosRequest request) {
		final EventPhotoService.SearchSocialPhotosResponse response = new EventPhotoService.SearchSocialPhotosResponse();
		response.socialPhotos = new ArrayList<>();

		DatabaseReference reference = FirebaseDatabase.getInstance()
				.getReferenceFromUrl(request.fireBaseUrl);
		reference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
					EventPictureFireBase eventPictureFireBase = dataSnapshot1.getValue(EventPictureFireBase.class);
					EventPicture eventPicture = new EventPicture(eventPictureFireBase.getUrl());
					response.socialPhotos.add(eventPicture);
				}
				bus.post(response);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});

	}
}
