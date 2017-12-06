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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colors = new ArrayList<>();

        colors.add(new Word("one", "lutti", R.drawable.number_one));
        colors.add(new Word("two", "tooty", R.drawable.number_two));
        colors.add(new Word("three", "tooty", R.drawable.number_four));
        colors.add(new Word("four", "tooty", R.drawable.number_five));
        colors.add(new Word("five", "tooty", R.drawable.number_six));
        colors.add(new Word("six", "tooty", R.drawable.number_seven));
        colors.add(new Word("seven", "tooty", R.drawable.number_eight));
        colors.add(new Word("eight", "tooty", R.drawable.number_nine));
        colors.add(new Word("nine", "tooty", R.drawable.number_ten));
        colors.add(new Word("ten", "na'aacha", R.drawable.number_three));


        WordAdapter itemsAdapter =
                new WordAdapter(this, R.layout.list_item, colors, R.color.category_colors);

        // Each object has it's own list_item.xml with the id list
        ListView listView = (ListView) findViewById(R.id.list); // the view is called list

        listView.setAdapter(itemsAdapter);
    }
}
