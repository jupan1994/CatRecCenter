package com.pjokk.jupan.catscareer.inmemory;

import com.pjokk.jupan.catscareer.entities.EventPicture;
import com.pjokk.jupan.catscareer.fragments.BaseFragment;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.EventPhotoService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by jupan on 6/28/17.
 */

public class InMemoryPictureService extends BaseInMemory {

	public InMemoryPictureService(CatApplication catApplication) {
		super(catApplication);
	}

	@Subscribe
	public void getCommunityPhotos(EventPhotoService.SearchCommunityPhotoRequest request) {
		EventPhotoService.SearchCommunityPhotoResponse response = new EventPhotoService.SearchCommunityPhotoResponse();
		response.communityPhotos = new ArrayList<>();
		response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 50 + "?d=identicon"));
		response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 51 + "?d=identicon"));
		response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 52 + "?d=identicon"));
		bus.post(response);
	}

	@Subscribe
	public void getCatHoodPhotos(EventPhotoService.SearchCatHoodPhotosRequest request) {
		EventPhotoService.SearchCatHoodPhotosResponse response = new EventPhotoService.SearchCatHoodPhotosResponse();
		response.catHoodPhotos = new ArrayList<>();
		response.catHoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 53 + "?d=identicon"));
		response.catHoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 54 + "?d=identicon"));
		response.catHoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 55 + "?d=identicon"));
		bus.post(response);
	}

	@Subscribe
	public void getSocailPhotos(EventPhotoService.SearchSocialPhotosRequest request) {
		EventPhotoService.SearchSocialPhotosResponse response = new EventPhotoService.SearchSocialPhotosResponse();
		response.socialPhotos = new ArrayList<>();
		response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 56 + "?d=identicon"));
		response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 57 + "?d=identicon"));
		response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 58 + "?d=identicon"));
		bus.post(response);
	}
}
