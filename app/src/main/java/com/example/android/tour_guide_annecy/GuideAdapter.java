package com.example.android.tour_guide_annecy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GuideAdapter extends ArrayAdapter<Guide> {

    private static final String LOG_TAG = GuideAdapter.class.getSimpleName();

    /**
     * Create a new {@link GuideAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param guides  is the list of {@link Guide} to be displayed.
     */
    public GuideAdapter(Context context, ArrayList<Guide> guides) {
        super(context, 0, guides);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Guide currentGuide = getItem(position);

        ImageView listImageView = (ImageView) listItemView.findViewById(R.id.list_image);
        listImageView.setImageResource(currentGuide.getImageResourceId());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.list_item_text_view_a);
        nameTextView.setText(currentGuide.getNameIdnameId());

        TextView regionTextView = (TextView) listItemView.findViewById(R.id.list_item_text_view_b);
        regionTextView.setText(currentGuide.getRegionId());

        return listItemView;
    }
}
