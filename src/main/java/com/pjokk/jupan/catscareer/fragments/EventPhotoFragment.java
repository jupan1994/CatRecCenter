package com.pjokk.jupan.catscareer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.entities.EventPicture;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jupan on 6/27/17.
 */

public class EventPhotoFragment extends BaseFragment {
	@BindView(R.id.fragment_event_picture_image)
	ImageView eventImage;

	@BindView(R.id.fragment_event_picture_progressBar)
	ProgressBar eventProgressBar;

	public static final String EVENT_PHOTO_INFO = "EVENT_PHOTO_INFO";
	private String photoUrl;

	public static EventPhotoFragment newInstance(EventPicture eventPicture) {
		Bundle arguments = new Bundle();
		arguments.putString(EVENT_PHOTO_INFO, eventPicture.getPictureUrl());
		EventPhotoFragment eventPhotoFragment = new EventPhotoFragment();
		eventPhotoFragment.setArguments(arguments);
		return eventPhotoFragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		photoUrl = getArguments().getString(EVENT_PHOTO_INFO);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_event_picture, container, false);
		ButterKnife.bind(this, rootView);
		Picasso.with(getActivity()).load(photoUrl)
				.fit()
				.centerCrop()
				.into(eventImage, new Callback() {
					@Override
					public void onSuccess() {
						eventProgressBar.setVisibility(View.GONE);
					}

					@Override
					public void onError() {

					}
				});
		return rootView;
	}
}
