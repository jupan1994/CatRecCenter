package com.pjokk.jupan.catscareer.views.AboutUsViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pjokk.jupan.catscareer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jupan on 6/27/17.
 */

public class AboutUsListHeaderViewHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.simple_header_textView)
	TextView headerText;

	public AboutUsListHeaderViewHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void populate(String header) {
		headerText.setText(header);
	}
}
