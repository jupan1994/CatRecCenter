package com.pjokk.jupan.catscareer.views.RushViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.entities.RushEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jupan on 6/28/17.
 */

public class RushEventsHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.list_rush_event_name)
	TextView rushName;

	@BindView(R.id.list_rush_event_date)
	TextView rushDate;

	@BindView(R.id.list_rush_event_location)
	TextView rushLocation;

	@BindView(R.id.list_rush_event_time)
	TextView rushTime;

	public RushEventsHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void populate(RushEvent rushEvent) {
		itemView.setTag(rushEvent);
		rushName.setText(rushEvent.getEventName());
		rushDate.setText(rushEvent.getEventDate());
		rushLocation.setText(rushEvent.getEventLocation());
		rushTime.setText(rushEvent.getEventTime());
	}
}
