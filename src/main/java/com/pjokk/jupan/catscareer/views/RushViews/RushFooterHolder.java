package com.pjokk.jupan.catscareer.views.RushViews;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.pjokk.jupan.catscareer.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jupan on 6/28/17.
 */

public class RushFooterHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.footer_rush_fragment_facebook)
	ImageView facebookImage;

	@BindView(R.id.footer_rush_fragment_twitter)
	ImageView twitterImage;

	@BindView(R.id.footer_rush_fragment_snapchat)
	ImageView snapchatImage;

	@BindView(R.id.footer_rush_fragment_instagram)
	ImageView instagramImage;

	public RushFooterHolder(final View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
		facebookImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent;
				try {
					view.getContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/101523522241"));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				} catch (PackageManager.NameNotFoundException e) {
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://https://www.facebook.com/UACampusRec/"));
				}
				view.getContext().startActivity(intent);
			}
		});
		twitterImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent;
				try {
					view.getContext().getPackageManager().getPackageInfo("com.twitter.android", 0);
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=" + "54648492"));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				} catch (PackageManager.NameNotFoundException e) {
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/UACampusRec?lang=en"));
				}
				view.getContext().startActivity(intent);
			}
		});
		instagramImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent;
				try {
					view.getContext().getPackageManager().getPackageInfo("com.instagram.android", 0);
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/uacampusrec/"));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				} catch (PackageManager.NameNotFoundException e) {
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/uacampusrec/"));
				}
				view.getContext().startActivity(intent);
			}
		});
		snapchatImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://snapchat.com/add/" + "UACampusRec"));
				view.getContext().startActivity(intent);
			}
		});
	}

	public void populate(Context context) {
		Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/faceBookLogo_zps5ehpqnng.png")
				.into(facebookImage);
		Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/snapChat_logo_zpsjzwi8hpr.png")
				.into(snapchatImage);
		Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/insta_logo_zpshg6xmz7g.jpg")
				.into(instagramImage);
		Picasso.with(context).load("https://dl.dropboxusercontent.com/s/jbtx0tbvi2t3v67/twitter%20logo.jpg?dl=0")
				.into(twitterImage);
	}
}
