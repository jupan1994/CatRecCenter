package com.pjokk.jupan.catscareer.infrastructure;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;
import com.pjokk.jupan.catscareer.live.Module;
import com.squareup.otto.Bus;

/**
 * Created by jupan on 6/26/17.
 */

public class CatApplication extends Application {
	private Bus bus;

	public static final String YOUTUBE_KEY = "AIzaSyBws9KTMcSe8rxq_ceRnt1Sn9Dc8FESEN4";

	public static final String FIRE_BASE_CAT_REFERENCE = "https://catcareer-172117.firebaseio.com/data/cats";

	public static final String FIRE_BASE_EVENT_CARD_COMMUNITY = "https://catcareer-172117.firebaseio.com/data/eventCards/community";
	public static final String FIRE_BASE_EVENT_CARD_CATHOOD = "https://catcareer-172117.firebaseio.com/data/eventCards/catHood";
	public static final String FIRE_BASE_EVENT_CARD_SOCIAL = "https://catcareer-172117.firebaseio.com/data/eventCards/socials";

	public static final String FIRE_BASE_EVENT_PICTURE_COMMUNITY = "https://catcareer-172117.firebaseio.com/data/eventPics/community";
	public static final String FIRE_BASE_EVENT_PICTURE_CATHOOD = "https://catcareer-172117.firebaseio.com/data/eventPics/catHood";
	public static final String FIRE_BASE_EVENT_PICTURE_SOCIAL = "https://catcareer-172117.firebaseio.com/data/eventPics/socials";

	public static final String FIRE_BASE_RUSH_COMMUNIT = "https://catcareer-172117.firebaseio.com/data/rushEvents/service";
	public static final String FIRE_BASE_RUSH_SOCAILS = "https://catcareer-172117.firebaseio.com/data/rushEvents/socials";
	public static final String FIRE_BASE_RUSH_NEWS = "https://catcareer-172117.firebaseio.com/data/rushEvents/Magzines";

	public CatApplication(){
		bus = new Bus();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Module.Register(this);

	}

	public Bus getBus() {
		return bus;
	}
}
