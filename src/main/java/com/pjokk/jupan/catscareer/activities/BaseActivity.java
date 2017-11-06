package com.pjokk.jupan.catscareer.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.squareup.otto.Bus;

/**
 * Created by jupan on 6/26/17.
 */

public class BaseActivity extends AppCompatActivity {
	protected CatApplication application;
	protected Bus bus;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		application = (CatApplication) getApplication();
		bus = application.getBus();
		bus.register(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		bus.unregister(this);
	}
}
