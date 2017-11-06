package com.pjokk.jupan.catscareer.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.entities.RushEvent;
import com.pjokk.jupan.catscareer.views.MainActivityViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

	@BindView(R.id.activity_main_viewPager)
	ViewPager mainViewPager;

	@BindView(R.id.activity_main_tabLayout)
	TabLayout tabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		MainActivityViewPagerAdapter adapter = new MainActivityViewPagerAdapter(getSupportFragmentManager());
		mainViewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(mainViewPager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.map:
				Intent intent = new Intent(getApplicationContext(), CampusMapActivity.class);
				startActivity(intent);
			case R.id.monitor:
				String url = "https://rec.arizona.edu/facilities/open-rec";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
		}
		return true;
	}
}
