package com.pjokk.jupan.catscareer.views.AboutUsViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.entities.EventCard;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jupan on 6/27/17.
 */

public class CatHoodViewHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.list_event_card_eventDescription)
	TextView eventDescription;

	@BindView(R.id.list_event_card_progressBar)
	ProgressBar progressBar;

	@BindView(R.id.list_event_card_imageView)
	ImageView eventImage;

	@BindView(R.id.list_event_card_eventType)
	ImageView eventType;

	@BindView(R.id.list_event_card_eventName)
	TextView eventName;

	public CatHoodViewHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void populate(Context context, EventCard eventCard) {
		itemView.setTag(eventCard);

		if (!eventCard.isVideo()) {
			eventType.setImageResource(R.mipmap.camera);
		} else {
			eventType.setImageResource(R.mipmap.video);
		}

		eventDescription.setText(eventCard.getEventDescription());
		eventName.setText(eventCard.getEventName());
		Picasso.with(context).load(eventCard.getEventImage())
				.fit()
				.centerCrop().fit()
				.into(eventImage, new Callback() {
					@Override
					public void onSuccess() {
						progressBar.setVisibility(View.GONE);
					}

					@Override
					public void onError() {

					}
				});
	}
}
