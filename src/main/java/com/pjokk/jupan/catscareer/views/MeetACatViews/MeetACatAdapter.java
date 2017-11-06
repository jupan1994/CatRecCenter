package com.pjokk.jupan.catscareer.views.MeetACatViews;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.activities.BaseActivity;
import com.pjokk.jupan.catscareer.entities.Cat;
import com.pjokk.jupan.catscareer.fragments.MeetCatsFragment;

import java.util.ArrayList;

/**
 * Created by jupan on 6/26/17.
 */

public class MeetACatAdapter extends RecyclerView.Adapter<MeetACatViewHolder> implements View.OnClickListener {

	private LayoutInflater inflater;
	private BaseActivity activity;
	private OnCatClicked listener;
	private ArrayList<Cat> cats;

	public MeetACatAdapter(MeetCatsFragment listener, BaseActivity activity) {
		this.activity = activity;
		this.listener = listener;
		inflater = activity.getLayoutInflater();
		cats = new ArrayList<>();
	}

	public ArrayList<Cat> getCats() {
		return cats;
	}

	@Override
	public MeetACatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View listView = inflater.inflate(R.layout.list_meet_a_cat, parent, false);
		listView.setOnClickListener(this);
		return new MeetACatViewHolder(listView);
	}

	@Override
	public void onBindViewHolder(MeetACatViewHolder holder, int position) {
		holder.populate(activity, cats.get(position));
	}

	@Override
	public int getItemCount() {
		return cats.size();
	}

	@Override
	public void onClick(View view) {
		if (view.getTag() instanceof Cat) {
			Cat cat = (Cat) view.getTag();
			listener.OnCatClicked(cat);
		}
	}

	public interface OnCatClicked {
		void OnCatClicked(Cat cat);
	}

}
