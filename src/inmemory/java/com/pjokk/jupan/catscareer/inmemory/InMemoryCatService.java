package com.pjokk.jupan.catscareer.inmemory;

import com.pjokk.jupan.catscareer.entities.Cat;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.CatServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by jupan on 6/26/17.
 */

public class InMemoryCatService extends BaseInMemory {
	public InMemoryCatService(CatApplication catApplication) {
		super(catApplication);
	}

	@Subscribe
	public void getCats(CatServices.SearchCatRequest request) {
		CatServices.SearchCatResponse response = new CatServices.SearchCatResponse();
		response.cats = new ArrayList<>();
		for (int i = 0; i < 32; i++) {
			response.cats.add(new Cat(
					i,
					"Cat " + i,
					"Independent Organization",
					"Independent Developer",
					"http://www.gravatar.com/avatar/" + i + "?d=identicon",
					"Electrical and Computer Engineering",
					"05/21/2017",
					"Regarding code as his lover."
			));
		}
		bus.post(response);
	}
}
