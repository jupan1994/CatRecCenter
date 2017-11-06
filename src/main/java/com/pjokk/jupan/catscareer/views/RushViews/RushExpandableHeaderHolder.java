package com.pjokk.jupan.catscareer.views.RushViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pjokk.jupan.catscareer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jupan on 6/28/17.
 */

public class RushExpandableHeaderHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.list_expandable_header_buttonToggle)
	ImageView buttonToggle;

	@BindView(R.id.list_expandable_header_layout)
	View backgroundView;

	@BindView(R.id.list_expandable_header_headerName)
	TextView headerName;

	public Item refferalItem;

	public RushExpandableHeaderHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}
}
