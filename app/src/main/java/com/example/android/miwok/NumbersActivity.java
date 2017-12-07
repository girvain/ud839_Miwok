/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.app.LauncherActivity;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> numbers = new ArrayList<>();

        numbers.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        numbers.add(new Word("two", "tooty", R.drawable.number_two, R.raw.number_two));
        numbers.add(new Word("three", "tooty", R.drawable.number_three, R.raw.number_three));
        numbers.add(new Word("three", "tooty", R.drawable.number_four, R.raw.number_four));
        numbers.add(new Word("four", "tooty", R.drawable.number_five, R.raw.number_five));
        numbers.add(new Word("five", "tooty", R.drawable.number_six, R.raw.number_six));
        numbers.add(new Word("six", "tooty", R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new Word("seven", "tooty", R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new Word("eight", "tooty", R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new Word("nine", "tooty", R.drawable.number_ten, R.raw.number_ten));
        numbers.add(new Word("ten", "na'aacha", R.drawable.number_three, R.raw.number_three));





        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, numbers, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list); // the view is called list

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);


        // The setOnItemClick listener allows any item of this view to generate an event, magical!
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int wordAudioId = numbers.get(i).getAudioId();
                Log.v("NumbersActivity", "current word: " + numbers.get(i));
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, wordAudioId);
                mMediaPlayer.start();
            }
        });


        /* The first way \/
        // get a ref to the layout in NumbersActivity.
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        // Creates a TextView (BRAND NEW!) then add data to it.
        TextView wordView = new TextView(this);
        rootView.addView(wordView);
        wordView.setText(words.get(0));
        */

    }
}
