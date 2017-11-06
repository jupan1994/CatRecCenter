package com.pjokk.jupan.catscareer.live;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pjokk.jupan.catscareer.entities.Cat;
import com.pjokk.jupan.catscareer.entities.fireBaseEntities.CatFireBase;
import com.pjokk.jupan.catscareer.infrastructure.CatApplication;
import com.pjokk.jupan.catscareer.services.CatServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by jupan on 6/29/17.
 */

public class LiveCatService extends BaseLiveService {
	public LiveCatService(CatApplication application) {
		super(application);
	}

	@Subscribe
	public void getCats(CatServices.SearchCatRequest request) {
		final CatServices.SearchCatResponse response = new CatServices.SearchCatResponse();
		response.cats = new ArrayList<>();
		DatabaseReference reference = FirebaseDatabase.getInstance()
				.getReferenceFromUrl(request.fireBaseUrl);
		reference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				int index = 0;
				for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
					CatFireBase catFireBase = dataSnapshot1.getValue(CatFireBase.class);
					Cat cat = new Cat(
							index,
							catFireBase.getName(),
							catFireBase.getCompany(),
							catFireBase.getPosition(),
							catFireBase.getPicture(),
							catFireBase.getMajor(),
							catFireBase.getGraduateTime(),
							catFireBase.getBio()
					);
					response.cats.add(cat);
					index++;
				}
				bus.post(response);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});
	}
}
