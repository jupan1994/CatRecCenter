package com.pjokk.jupan.catscareer.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.entities.Cat;
import com.pjokk.jupan.catscareer.fragments.CatDetailFragment;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.CatServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jupan on 6/27/17.
 */

public class CatPagerActivity extends BaseActivity {
	public static final String CAT_EXTRA_INFO = "CAT_EXTRA_INFO";
	private ArrayList<Cat> cats;

	@BindView(R.id.activity_cat_pager_viewPager)
	ViewPager catViewPager;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cat_pager);
		ButterKnife.bind(this);
		cats = new ArrayList<>();
		bus.post(new CatServices.SearchCatRequest(CatApplication.FIRE_BASE_CAT_REFERENCE));
		catViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				Cat cat = cats.get(position);
				return CatDetailFragment.newInstance(cat);
			}

			@Override
			public int getCount() {
				return cats.size();
			}
		});


	}

	@Subscribe
	public void getCats(CatServices.SearchCatResponse response) {
		cats.clear();
		cats.addAll(response.cats);
		catViewPager.getAdapter().notifyDataSetChanged();

		Cat cat = getIntent().getParcelableExtra(CAT_EXTRA_INFO);
		int catId = cat.getCatId();
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getCatId() == catId) {
				catViewPager.setCurrentItem(i);
				break;
			}
		}
	}

	public static Intent newIntent(Context context, Cat cat) {
		Intent intent = new Intent(context, CatPagerActivity.class);
		intent.putExtra(CAT_EXTRA_INFO, cat);
		return intent;
	}
}
