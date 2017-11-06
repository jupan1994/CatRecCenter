package com.pjokk.jupan.catscareer.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.activities.BaseActivity;
import com.pjokk.jupan.catscareer.activities.CatPagerActivity;
import com.pjokk.jupan.catscareer.entities.Cat;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.CatServices;
import com.pjokk.jupan.catscareer.views.MeetACatViews.MeetACatAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by jupan on 6/24/17.
 */

public class MeetCatsFragment extends BaseFragment implements MeetACatAdapter.OnCatClicked {

	private final String LOG_TAG = MeetCatsFragment.class.getSimpleName();
	private MeetACatAdapter aCatAdapter;
	private RecyclerView recyclerView;
	private ArrayList<Cat> cats;

	public static MeetCatsFragment newInstance() {
		return new MeetCatsFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_meet_cats, container, false);
		aCatAdapter = new MeetACatAdapter(this, (BaseActivity) getActivity());
		cats = aCatAdapter.getCats();
		recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_meet_a_cat_recyclerView);
		recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
		setupAdapter();
		bus.post(new CatServices.SearchCatRequest(CatApplication.FIRE_BASE_CAT_REFERENCE));
		return rootView;
	}

	private void setupAdapter() {
		if (isAdded()) {
			recyclerView.setAdapter(aCatAdapter);
		}
	}

	@Override
	public void OnCatClicked(Cat cat) {
		Intent intent = CatPagerActivity.newIntent(getActivity(), cat);
		startActivity(intent);
	}

	@Subscribe
	public void getCats(CatServices.SearchCatResponse response) {
		int oldSize = cats.size();
		if (oldSize == 0) {
			cats.clear();
			aCatAdapter.notifyItemRangeRemoved(0, oldSize);
			cats.addAll(response.cats);
			aCatAdapter.notifyItemRangeChanged(0, cats.size());
		}
	}
}
