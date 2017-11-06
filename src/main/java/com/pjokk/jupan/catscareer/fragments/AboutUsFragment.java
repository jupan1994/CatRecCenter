package com.pjokk.jupan.catscareer.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.activities.BaseActivity;
import com.pjokk.jupan.catscareer.activities.PhotoPagerActivity;
import com.pjokk.jupan.catscareer.activities.YoutubeActivity;
import com.pjokk.jupan.catscareer.entities.EventCard;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.EventCardService;
import com.pjokk.jupan.catscareer.views.AboutUsViews.AboutUsAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by jupan on 6/24/17.
 */

public class AboutUsFragment extends BaseFragment implements AboutUsAdapter.AboutUsListener {

	private ArrayList<EventCard> serviceCards;
	private ArrayList<EventCard> catHoodCards;
	private ArrayList<EventCard> socialCards;

	private RecyclerView recyclerView;
	private AboutUsAdapter aboutUsAdapter;

	public static AboutUsFragment newInstance() {
		return new AboutUsFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_about_us, container, false);
		aboutUsAdapter = new AboutUsAdapter((BaseActivity) getActivity(), this);
		serviceCards = aboutUsAdapter.getCommunityServiceCards();
		catHoodCards = aboutUsAdapter.getCatHoodEventCards();
		socialCards = aboutUsAdapter.getSocialEventCards();

		recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_about_us_recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		setupAdapter();

		bus.post(new EventCardService.SearchCommunityServiceCardsRequest(CatApplication.FIRE_BASE_EVENT_CARD_COMMUNITY));
		bus.post(new EventCardService.SearchCatHoodCardsRequst(CatApplication.FIRE_BASE_EVENT_CARD_CATHOOD));
		bus.post(new EventCardService.SearchSocialCardsRequest(CatApplication.FIRE_BASE_EVENT_CARD_SOCIAL));
		return rootView;
	}

	private void setupAdapter() {
		if (isAdded()) {
			recyclerView.setAdapter(aboutUsAdapter);
		}
	}

	@Override
	public void OnEventCardClicked(EventCard eventCard) {
		if (!eventCard.isVideo()) {
			/*Intent intent = PhotoPagerActivity.newIntent(getActivity(), eventCard);
			startActivity(intent);*/
			String url = eventCard.getWebUrl();

			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
		} else {
			Intent intent = YoutubeActivity.newIntent(getActivity(), eventCard);
			startActivity(intent);
		}
	}

	@Subscribe
	public void getCommunityEvent(EventCardService.SearchCommunityServiceCardsResponse response) {
		int oldSize = serviceCards.size();
		if (oldSize == 0) {
			serviceCards.clear();
			aboutUsAdapter.notifyItemRangeRemoved(0, oldSize);
			serviceCards.addAll(response.communityServiceCards);
			aboutUsAdapter.notifyItemRangeChanged(0, serviceCards.size());
		}
	}
	@Subscribe
	public void getCatHoodEvent(EventCardService.SearchCatHoodServiceCardsResponse response) {
		int oldSize = catHoodCards.size();
		if (oldSize == 0) {
			catHoodCards.clear();
			aboutUsAdapter.notifyItemRangeRemoved(0, oldSize);
			catHoodCards.addAll(response.catHoodCards);
			aboutUsAdapter.notifyItemRangeChanged(0, catHoodCards.size());
		}
	}
	@Subscribe
	public void getSocialEvents(EventCardService.SearchSocialCardsResponse response) {
		int oldSize = socialCards.size();
		if (oldSize == 0) {
			socialCards.clear();
			aboutUsAdapter.notifyItemRangeRemoved(0, oldSize);
			socialCards.addAll(response.socialCards);
			aboutUsAdapter.notifyItemRangeChanged(0, socialCards.size());
		}
	}
}
