package com.pjokk.jupan.catscareer.views.RushViews;

import com.pjokk.jupan.catscareer.entities.RushEvent;

import java.util.List;

/**
 * Created by jupan on 6/28/17.
 */

public class Item {
	public int type;
	public String header;
	public RushEvent rushEvent;
	public List<Item> invisibleChildren;

	public Item(int type, String header) {
		this.type = type;
		this.header = header;
	}

	public Item(int type, RushEvent rushEvent) {
		this.type = type;
		this.rushEvent = rushEvent;
	}

}
