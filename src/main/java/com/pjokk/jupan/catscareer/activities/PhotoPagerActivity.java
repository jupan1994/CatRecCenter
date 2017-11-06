package com.pjokk.jupan.catscareer.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.entities.EventCard;
import com.pjokk.jupan.catscareer.entities.EventPicture;
import com.pjokk.jupan.catscareer.fragments.EventPhotoFragment;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.EventPhotoService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jupan on 6/28/17.
 */

public class PhotoPagerActivity extends BaseActivity {
	private ArrayList<EventPicture> mEventPhotos;

	@BindView(R.id.activity_photo_pager_viewPager)
	ViewPager viewPager;

	public static final String EXTRA_CARD_INFO = "EXTRA_CARD_INFO";

	public static Intent newIntent(Context context, EventCard eventCard) {
		Intent intent = new Intent(context, PhotoPagerActivity.class);
		intent.putExtra(EXTRA_CARD_INFO, eventCard.getEventId());
		return intent;
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_pager);
		ButterKnife.bind(this);
		mEventPhotos = new ArrayList<>();
		int cardIndex = getIntent().getIntExtra(EXTRA_CARD_INFO, 0);
		switch (cardIndex) {
			case 1:
				bus.post(new EventPhotoService.SearchCommunityPhotoRequest(CatApplication.FIRE_BASE_EVENT_PICTURE_COMMUNITY));
				break;
			case 3:
				bus.post(new EventPhotoService.SearchCatHoodPhotosRequest(CatApplication.FIRE_BASE_EVENT_PICTURE_CATHOOD));
				break;
			case 5:
				bus.post(new EventPhotoService.SearchSocialPhotosRequest(CatApplication.FIRE_BASE_EVENT_PICTURE_SOCIAL));
				break;
		}
		viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				EventPicture eventPicture = mEventPhotos.get(position);
				return EventPhotoFragment.newInstance(eventPicture);
			}

			@Override
			public int getCount() {
				return mEventPhotos.size();
			}
		});
	}

	@Subscribe
	public void getCommunityPhotos(EventPhotoService.SearchCommunityPhotoResponse response) {
		mEventPhotos.clear();
		mEventPhotos.addAll(response.communityPhotos);
		viewPager.getAdapter().notifyDataSetChanged();
	}

	@Subscribe
	public void getCatHoodPhotos(EventPhotoService.SearchCatHoodPhotosResponse response) {
		mEventPhotos.clear();
		mEventPhotos.addAll(response.catHoodPhotos);
		viewPager.getAdapter().notifyDataSetChanged();
	}

	@Subscribe
	public void getSocialPhotos(EventPhotoService.SearchSocialPhotosResponse response) {
		mEventPhotos.clear();
		mEventPhotos.addAll(response.socialPhotos);
		viewPager.getAdapter().notifyDataSetChanged();
	}
}
