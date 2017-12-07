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

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> family = new ArrayList<>();

        family.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        family.add(new Word("two", "tooty", R.drawable.number_two, R.raw.number_two));
        family.add(new Word("three", "tooty", R.drawable.number_four, R.raw.number_three));
        family.add(new Word("four", "tooty", R.drawable.number_five, R.raw.number_four));
        family.add(new Word("five", "tooty", R.drawable.number_six, R.raw.number_five));
        family.add(new Word("six", "tooty", R.drawable.number_seven, R.raw.number_six));
        family.add(new Word("seven", "tooty", R.drawable.number_eight, R.raw.number_seven));
        family.add(new Word("eight", "tooty", R.drawable.number_nine, R.raw.number_eight));
        family.add(new Word("nine", "tooty", R.drawable.number_ten, R.raw.number_nine));
        family.add(new Word("ten", "na'aacha", R.drawable.number_three, R.raw.number_ten));


        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, family, R.color.category_family);

        // Each object has it's own list_item.xml with the id list
        ListView listView = (ListView) findViewById(R.id.list); // the view is called list

        listView.setAdapter(itemsAdapter);

        // The setOnItemClick listener allows any item of this view to generate an event, magical!
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int wordAudioId = family.get(i).getAudioId();
                Log.v("NumbersActivity", "current word: " + family.get(i));
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, wordAudioId);
                mMediaPlayer.start();
            }
        });
    }


}
