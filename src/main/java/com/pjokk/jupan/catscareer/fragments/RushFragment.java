package com.pjokk.jupan.catscareer.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.activities.ActivityMaps;
import com.pjokk.jupan.catscareer.activities.BaseActivity;
import com.pjokk.jupan.catscareer.activities.CampusMapActivity;
import com.pjokk.jupan.catscareer.entities.RushEvent;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.RushEventService;
import com.pjokk.jupan.catscareer.views.RushViews.Item;
import com.pjokk.jupan.catscareer.views.RushViews.RushEventAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jupan on 6/24/17.
 */

public class RushFragment extends BaseFragment implements RushEventAdapter.RushEventListener {

	private RushEventAdapter adapter;
	private ArrayList<RushEvent> socialEvent;
	private ArrayList<RushEvent> communityEvent;
	private ArrayList<RushEvent> newsEvent;

	private Item social;
	private Item community;
	private Item news;

	private RecyclerView recyclerView;

	public static RushFragment newInstance() {
		return new RushFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_rush, container, false);
		adapter = new RushEventAdapter((BaseActivity) getActivity(), this);
		recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_rush_recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		socialEvent = new ArrayList<>();
		communityEvent = new ArrayList<>();
		newsEvent = new ArrayList<>();

		List<Item> data = adapter.getData();

		social = new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER, "LIVING WILD! MAGAZINE");
		social.invisibleChildren = new ArrayList<>();

		community = new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER, "WHAT'S HAPPENING AT THE REC");
		community.invisibleChildren = new ArrayList<>();

		news = new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER, "SPECIAL EVENTS");
		news.invisibleChildren = new ArrayList<>();

		bus.post(new RushEventService.SearchRushEventCommunityRequest(CatApplication.FIRE_BASE_RUSH_COMMUNIT));
		bus.post(new RushEventService.SearchRushEventSocialRequest(CatApplication.FIRE_BASE_RUSH_SOCAILS));
		bus.post(new RushEventService.SearchRushEventNewsRequest(CatApplication.FIRE_BASE_RUSH_NEWS));

		setupAdapter();

		data.add(community);
		data.add(social);
		data.add(news);

		return rootView;
	}

	private void setupAdapter() {
		if (isAdded()) {
			recyclerView.setAdapter(adapter);
		}
	}

	@Override
	public void OnRushEventClicked(RushEvent rushEvent) {
		if (!rushEvent.isWeb()) {
//			Intent intent = ActivityMaps.newIntent(getActivity(), rushEvent);
//			startActivity(intent);
			String url = rushEvent.getWebUrl();

			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
		} else {
//			Intent intent = CampusMapActivity.newIntent(getActivity(), rushEvent);
//			startActivity(intent);
			String url = rushEvent.getWebUrl();

			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
		}
	}

	@Subscribe
	public void getServiceEvent(RushEventService.SearchRushEventCommunityResponse response) {
		communityEvent.clear();
		communityEvent.addAll(response.communityRushEvents);
		for (RushEvent rushEvent : communityEvent) {
			community.invisibleChildren.add(new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD, rushEvent));
		}
	}

	@Subscribe
	public void getSocialEvent(RushEventService.SearchRushEventSocialResponse response) {
		socialEvent.clear();
		socialEvent.addAll(response.socialRushEvents);
		for (RushEvent rushEvent : socialEvent) {
			social.invisibleChildren.add(new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD, rushEvent));
		}
	}

	@Subscribe
	public void getNewsEvent(RushEventService.SearchRushEventNewsResponse response) {
		newsEvent.clear();
		newsEvent.addAll(response.newsRushEvents);
		for (RushEvent rushEvent : newsEvent) {
			news.invisibleChildren.add(new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD, rushEvent));
		}
	}
}