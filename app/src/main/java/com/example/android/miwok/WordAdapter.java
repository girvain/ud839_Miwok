package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by gavinross on 05/12/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    // make the constructor the same as before
    public WordAdapter(@NonNull Context context, int resource, ArrayList<Word> words, int mColorResourceId) {
        super(context, 0, words);
        this.mColorResourceId = mColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);


        // find the textView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        nameTextView.setText(currentWord.getmDefaultTranslation());

        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokWord.setText(currentWord.getMiwokTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());

            // make sure it's visable because of image reuse/
            imageView.setVisibility(View.VISIBLE);
        }
        else
            imageView.setVisibility(View.GONE);

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // get a ref to the play button
        //ImageView imageViewPlay = (ImageView) listItemView.findViewById(R.id.play_button);
        //imageViewPlay.setImageResource(R.drawable.ic_play_arrow_white_24dp);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.

        return listItemView;

    }

}
