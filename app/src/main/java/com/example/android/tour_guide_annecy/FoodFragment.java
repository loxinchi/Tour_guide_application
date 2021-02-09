package com.example.android.tour_guide_annecy;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);

        // Create a list of guides
        final ArrayList<Guide> guides = new ArrayList<Guide>();
        guides.add(new Guide(R.string.food_item_1, R.string.food_item_region_1, R.drawable.le_freti));
        guides.add(new Guide(R.string.food_item_2, R.string.food_item_region_2, R.drawable.iestaminet));
        guides.add(new Guide(R.string.food_item_3, R.string.food_item_region_3, R.drawable.littleitaly));
        guides.add(new Guide(R.string.food_item_4, R.string.food_item_region_4, R.drawable.glacierdesalpes));
        guides.add(new Guide(R.string.food_item_5, R.string.food_item_region_5, R.drawable.auberge_de_savoie));

        GuideAdapter adapter = new GuideAdapter(getActivity(), guides);

        ListView listView = (ListView) rootView.findViewById(R.id.guide_list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
