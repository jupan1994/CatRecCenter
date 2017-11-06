package com.pjokk.jupan.catscareer.inmemory;

import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.squareup.otto.Bus;

/**
 * Created by jupan on 6/26/17.
 */

public class BaseInMemory {
	protected final Bus bus;
	protected final CatApplication catApplication;

	public BaseInMemory(CatApplication catApplication) {
		this.catApplication = catApplication;
		this.bus = catApplication.getBus();
		bus.register(this);
	}
}
