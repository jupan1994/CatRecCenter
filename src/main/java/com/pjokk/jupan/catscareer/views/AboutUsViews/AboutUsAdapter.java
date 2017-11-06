package com.pjokk.jupan.catscareer.views.AboutUsViews;

import android.app.usage.UsageEvents;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pjokk.jupan.catscareer.R;
import com.pjokk.jupan.catscareer.activities.BaseActivity;
import com.pjokk.jupan.catscareer.entities.EventCard;

import java.util.ArrayList;

/**
 * Created by jupan on 6/27/17.
 */

public class AboutUsAdapter extends RecyclerView.Adapter {

	private final int VIEW_TYPE_MAIN_HAEDER = 1;
	private final int VIEW_TYPE_SERVICE_LIST = 2;
	private final int VIEW_TYPE_CATHOOD_LIST = 3;
	private final int VIEW_TYPE_SOCIAL_LIST = 4;
	private final int VIEW_TYPE_LIST_HEADER = 5;

	private LayoutInflater inflater;
	private BaseActivity activity;
	private ArrayList<EventCard> communityServiceCards;
	private ArrayList<EventCard> catHoodEventCards;
	private ArrayList<EventCard> socialEventCards;

	private AboutUsListener listener;

	public AboutUsAdapter(BaseActivity activity, AboutUsListener listener) {
		this.activity = activity;
		this.listener = listener;
		inflater = activity.getLayoutInflater();
		communityServiceCards = new ArrayList<>();
		catHoodEventCards = new ArrayList<>();
		socialEventCards = new ArrayList<>();
	}

	public ArrayList<EventCard> getCommunityServiceCards() {
		return communityServiceCards;
	}

	public ArrayList<EventCard> getCatHoodEventCards() {
		return catHoodEventCards;
	}

	public ArrayList<EventCard> getSocialEventCards() {
		return socialEventCards;
	}

	@Override
	public int getItemViewType(int position) {
		if (position == 0) {
			return VIEW_TYPE_MAIN_HAEDER;
		}
		position--;
		if (socialEventCards.size() > 0) {
			if (position == 0) {
				return VIEW_TYPE_LIST_HEADER;
			}
			position --;
			if (position < socialEventCards.size()) {
				return VIEW_TYPE_SOCIAL_LIST;
			}
			position -= socialEventCards.size();
		}
		if (catHoodEventCards.size() > 0) {
			if (position == 0) {
				return VIEW_TYPE_LIST_HEADER;
			}
			position--;
			if (position < catHoodEventCards.size()) {
				return VIEW_TYPE_CATHOOD_LIST;
			}
			position -= catHoodEventCards.size();
		}
		if (communityServiceCards.size() > 0) {
			if (position == 0) {
				return VIEW_TYPE_LIST_HEADER;
			}
			position--;
		}
		if (position < communityServiceCards.size()) {
			return VIEW_TYPE_SERVICE_LIST;
		}
		position -= communityServiceCards.size();

		throw new IllegalArgumentException("We are being asked for a viewType at position " +
											position +
											" although we are at the end of the adapter support viewHolders. Please check your adapter");

	}

	// >>Header<< //

	// >>List Header<< //
	// >>Community List<< //

	// >>List Header<< //
	// >>CatHood List<< //

	// >>List Header<< //
	// >>Social List<< //

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View eventCardView = inflater.inflate(R.layout.list_event_card, parent, false);
		final View listHeader = inflater.inflate(R.layout.simple_header, parent, false);

		if (viewType == VIEW_TYPE_MAIN_HAEDER) {
			return new AboutUsMainHeaderViewHolder(inflater, parent);
		} else if (viewType == VIEW_TYPE_SOCIAL_LIST) {
			final SocialViewHolder socialViewHolder = new SocialViewHolder(eventCardView);
			socialViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					EventCard eventCard = (EventCard) socialViewHolder.itemView.getTag();
					listener.OnEventCardClicked(eventCard);
				}
			});
			return socialViewHolder;
		} else if (viewType == VIEW_TYPE_CATHOOD_LIST) {
			final CatHoodViewHolder catHoodViewHolder = new CatHoodViewHolder(eventCardView);
			catHoodViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					EventCard eventCard = (EventCard) catHoodViewHolder.itemView.getTag();
					listener.OnEventCardClicked(eventCard);
				}
			});
			return catHoodViewHolder;
		} else if (viewType == VIEW_TYPE_SERVICE_LIST) {
			final CommunityServiceViewHolder communityServiceViewHolder = new CommunityServiceViewHolder(eventCardView);
			communityServiceViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					EventCard eventCard = (EventCard) communityServiceViewHolder.itemView.getTag();
					listener.OnEventCardClicked(eventCard);
				}
			});
			return communityServiceViewHolder;
		} else if (viewType == VIEW_TYPE_LIST_HEADER) {
			return new AboutUsListHeaderViewHolder(listHeader);
		}
		throw new IllegalArgumentException(viewType + " is not support in this adapter");


	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if (holder instanceof AboutUsMainHeaderViewHolder) {
			AboutUsMainHeaderViewHolder holder1 = (AboutUsMainHeaderViewHolder) holder;
		}
		if (holder instanceof SocialViewHolder) {
			position --;
			if (socialEventCards.size() > 0) {
				position --;
			}
			EventCard eventCard = socialEventCards.get(position);
			((SocialViewHolder) holder).populate(activity, eventCard);
		}
		if (holder instanceof CatHoodViewHolder) {
			position --;
			if (socialEventCards.size() > 0) {
				position --;
				position -= socialEventCards.size();
			}
			if (catHoodEventCards.size() > 0) {
				position --;
			}
			EventCard eventCard = catHoodEventCards.get(position);
			((CatHoodViewHolder) holder).populate(activity, eventCard);
		}
		if (holder instanceof CommunityServiceViewHolder) {
			position --;
			if (socialEventCards.size() > 0) {
				position --;
				position -= socialEventCards.size();
			}
			if (catHoodEventCards.size() > 0) {
				position --;
				position -= catHoodEventCards.size();
			}
			if (communityServiceCards.size() > 0) {
				position --;
			}
			EventCard eventCard = communityServiceCards.get(position);
			((CommunityServiceViewHolder) holder).populate(activity, eventCard);
		}
		if (holder instanceof AboutUsListHeaderViewHolder) {
			AboutUsListHeaderViewHolder aboutUsListHeaderViewHolder = (AboutUsListHeaderViewHolder) holder;
			int socialPosition = 1;
			int catHoodPosition = socialPosition + socialEventCards.size() + 1;
			int servicePosition = catHoodPosition + catHoodEventCards.size() + 1;

			if (position == servicePosition) {
				aboutUsListHeaderViewHolder.populate("Services");
			}
			if (position == catHoodPosition) {
				aboutUsListHeaderViewHolder.populate("Facilities");
			}
			if (position == socialPosition) {
				aboutUsListHeaderViewHolder.populate("Memberships");
			}

		}

	}

	@Override
	public int getItemCount() {
		int count = 1;
		if (communityServiceCards.size() > 0) {
			count += 1 + communityServiceCards.size();
		}
		if (catHoodEventCards.size() > 0) {
			count += 1 + catHoodEventCards.size();
		}
		if (socialEventCards.size() > 0) {
			count += 1 + socialEventCards.size();
		}
		return count;
	}

	public interface AboutUsListener {
		void OnEventCardClicked(EventCard eventCard);
	}
}
