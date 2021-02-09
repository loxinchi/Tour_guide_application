package com.example.android.tour_guide_annecy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class TourFragment extends Fragment {

    public TourFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);

        // Create a list of guides
        final ArrayList<Guide> guides = new ArrayList<Guide>();
        guides.add(new Guide(R.string.tour_item_1, R.string.tour_item_region_1, R.drawable.lack_annecy, R.string.tour_item_tel_1, R.string.tour_item_add_1, R.string.tour_item_web_1));
        guides.add(new Guide(R.string.tour_item_2, R.string.tour_item_region_2, R.drawable.la_vieille_ville, R.string.tour_item_tel_1, R.string.tour_item_add_1, R.string.tour_item_web_1));
        guides.add(new Guide(R.string.tour_item_3, R.string.tour_item_region_3, R.drawable.palaisdelile, R.string.tour_item_tel_1, R.string.tour_item_add_1, R.string.tour_item_web_1));
        guides.add(new Guide(R.string.tour_item_4, R.string.tour_item_region_4, R.drawable.chateaudannecy, R.string.tour_item_tel_1, R.string.tour_item_add_1, R.string.tour_item_web_1));
        guides.add(new Guide(R.string.tour_item_5, R.string.tour_item_region_5, R.drawable.lesgorges_dufier, R.string.tour_item_tel_1, R.string.tour_item_add_1, R.string.tour_item_web_1));

        GuideAdapter adapter = new GuideAdapter(getActivity(), guides);

        ListView listView = (ListView) rootView.findViewById(R.id.guide_list);

        listView.setAdapter(adapter);

        //Create a onClickLIstener when listview item clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get current item index
                Guide currentGuideData = guides.get(position);

                //Create an Intent
                Intent intent = new Intent(getContext(), GuideDetailsActivity.class);

                intent.putExtra("name", currentGuideData.getNameIdnameId());
                intent.putExtra("region", currentGuideData.getRegionId());
                intent.putExtra("coverPhoto", currentGuideData.getImageResourceId());
                intent.putExtra("tel", currentGuideData.getPhoneNumberId());
                intent.putExtra("address", currentGuideData.getAddressId());
                intent.putExtra("websiteUrl", currentGuideData.getWebURLId());

                startActivity(intent);
            }
        });

        return rootView;
    }
}
