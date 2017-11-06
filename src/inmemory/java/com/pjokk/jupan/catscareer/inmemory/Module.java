package com.pjokk.jupan.catscareer.inmemory;

import com.pjokk.jupan.catscareer.infrastructure.CatApplication;

/**
 * Created by jupan on 6/27/17.
 */

public class Module {
	public static void Register(CatApplication application) {
		new InMemoryCatService(application);
		new InMemoryCardsService(application);
		new InMemoryPictureService(application);
		new InMemoryRushEventService(application);
	}
}
