package com.pjokk.jupan.catscareer.views.MeetACatViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.entities.Cat;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jupan on 6/26/17.
 */

public class MeetACatViewHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.list_meet_a_cat_imageView)
	ImageView catPic;

	@BindView(R.id.list_meet_a_cat_progressBar)
	ProgressBar catProgressBar;

	public MeetACatViewHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void populate(Context context, Cat cat) {
		itemView.setTag(cat);
		Picasso.with(context).load(cat.getCatPicture()).fit().centerCrop().into(catPic, new Callback() {
			@Override
			public void onSuccess() {
				catProgressBar.setVisibility(View.GONE);
			}

			@Override
			public void onError() {

			}
		});
	}
}
