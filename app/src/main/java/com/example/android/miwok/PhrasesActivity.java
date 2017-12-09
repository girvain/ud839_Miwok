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

        phrases.add(new Word("one", "lutti", R.raw.phrase_are_you_coming));
        phrases.add(new Word("two", "tooty", R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("two", "tooty", R.raw.phrase_im_feeling_good));
        phrases.add(new Word("three", "tooty",R.raw.phrase_where_are_you_going));
        phrases.add(new Word("four", "tooty",R.raw.phrase_lets_go));
        phrases.add(new Word("five", "tooty", R.raw.phrase_what_is_your_name));
        phrases.add(new Word("six", "tooty", R.raw.phrase_my_name_is));
        phrases.add(new Word("seven", "tooty", R.raw.phrase_yes_im_coming));
        phrases.add(new Word("eight", "tooty", R.raw.phrase_come_here));
        phrases.add(new Word("nine", "tooty", R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("ten", "na'aacha", R.raw.phrase_im_feeling_good));

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

                // this method is to set the listener to listen for events from media player
                // that tell it the audio file is done. Takes an on complete listener object, I've
                // done this anonomously, oosh.
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
    }

    public void onStop(Bundle SavedInstanceState) {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

}
