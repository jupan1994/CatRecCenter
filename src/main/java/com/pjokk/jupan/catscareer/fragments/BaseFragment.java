package com.pjokk.jupan.catscareer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.squareup.otto.Bus;

/**
 * Created by jupan on 6/26/17.
 */

public class BaseFragment extends Fragment {
	protected CatApplication application;
	protected Bus bus;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		application = (CatApplication) getActivity().getApplication();
		bus = application.getBus();
		bus.register(this);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		bus.unregister(this);
	}
}
