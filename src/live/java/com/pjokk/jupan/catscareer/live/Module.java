package com.pjokk.jupan.catscareer.live;

import com.pjokk.jupan.catscareer.infrastructure.CatApplication;

/**
 * Created by jupan on 6/29/17.
 */

public class Module {
	public static void Register(CatApplication application) {
		new LiveCatService(application);
		new LiveCardService(application);
		new LivePictureService(application);
		new LiveRushService(application);
	}
}
