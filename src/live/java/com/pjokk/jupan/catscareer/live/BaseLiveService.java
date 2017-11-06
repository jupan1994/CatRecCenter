package com.pjokk.jupan.catscareer.live;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.squareup.otto.Bus;

/**
 * Created by jupan on 6/29/17.
 */

public class BaseLiveService {
	protected Bus bus;
	protected CatApplication application;
	protected final DatabaseReference databaseReference;

	public BaseLiveService(CatApplication application) {
		this.application = application;
		bus = application.getBus();
		bus.register(this);
		databaseReference = FirebaseDatabase.getInstance().getReference();
	}
}
