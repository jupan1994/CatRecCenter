package com.pjokk.jupan.catscareer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.entities.Cat;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jupan on 6/27/17.
 */

public class CatDetailFragment extends BaseFragment {
	@BindView(R.id.fragment_cat_detail_catPicture)
	ImageView catPicture;

	@BindView(R.id.fragment_cat_detail_progressBar)
	ProgressBar catProgressBar;

	@BindView(R.id.fragment_cat_detail_catName)
	TextView catName;

	@BindView(R.id.fragment_cat_detail_catCompany)
	TextView catCompany;

	@BindView(R.id.fragment_cat_detail_catPosition)
	TextView catPosition;

	@BindView(R.id.fragment_cat_detail_catMajor)
	TextView catMajor;

	@BindView(R.id.fragment_cat_detail_graduateTime)
	TextView catGraduateTime;

	@BindView(R.id.fragment_cat_detail_catBio)
	TextView catBio;

	private Cat cat;
	public static final String CAT_EXTRA_INFO = "CAT_EXTRA_INFO";

	public static CatDetailFragment newInstance(Cat cat) {
		Bundle argument = new Bundle();
		argument.putParcelable(CAT_EXTRA_INFO, cat);
		CatDetailFragment catDetailFragment = new CatDetailFragment();
		catDetailFragment.setArguments(argument);
		return catDetailFragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		cat = getArguments().getParcelable(CAT_EXTRA_INFO);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_cat_details, container, false);
		ButterKnife.bind(this, rootView);
		catName.setText(cat.getCatName());
		catPosition.setText(getString(R.string.position_intro, cat.getCatPosition()));
		catCompany.setText(getString(R.string.company_intro, cat.getCatCompany()));
		catMajor.setText(getString(R.string.major_intro, cat.getCatMajor()));
		catGraduateTime.setText(getString(R.string.graduate_time_intro, cat.getCatGrauateTime()));
		catBio.setText(getString(R.string.bio_intro, cat.getCatBio()));
		Picasso.with(getActivity()).load(cat.getCatPicture()).fit().centerCrop().into(catPicture, new Callback() {
			@Override
			public void onSuccess() {
				catProgressBar.setVisibility(View.GONE);
			}

			@Override
			public void onError() {

			}
		});
		return rootView;
	}
}
