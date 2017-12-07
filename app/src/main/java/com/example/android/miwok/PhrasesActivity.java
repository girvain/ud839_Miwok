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

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> phrases = new ArrayList<>();

        phrases.add(new Word("one", "lutti", R.raw.number_one));
        phrases.add(new Word("two", "tooty", R.raw.number_two));
        phrases.add(new Word("two", "tooty", R.raw.number_three));
        phrases.add(new Word("three", "tooty",R.raw.number_four));
        phrases.add(new Word("four", "tooty",R.raw.number_five));
        phrases.add(new Word("five", "tooty", R.raw.number_six));
        phrases.add(new Word("six", "tooty", R.raw.number_seven));
        phrases.add(new Word("seven", "tooty", R.raw.number_eight));
        phrases.add(new Word("eight", "tooty", R.raw.number_nine));
        phrases.add(new Word("nine", "tooty", R.raw.number_ten));
        phrases.add(new Word("ten", "na'aacha", R.raw.number_one));

        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, phrases, R.color.category_phrases);

        // Each object has it's own list_item.xml with the id list
        ListView listView = (ListView) findViewById(R.id.list); // the view is called list

        listView.setAdapter(itemsAdapter);

        // The setOnItemClick listener allows any item of this view to generate an event, magical!
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int wordAudioId = phrases.get(i).getAudioId();
                Log.v("NumbersActivity", "current word: " + phrases.get(i));
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, wordAudioId);
                mMediaPlayer.start();
            }
        });
    }
}
