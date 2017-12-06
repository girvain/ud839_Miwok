package com.example.android.miwok;

import android.widget.ImageView;

/**
 * Created by gavinross on 05/12/2017.
 */

public class Word {

    private String mDefaultTranslation;
    private String miwokTranslation;
    private ImageView imageView;

    public Word(String wordInEnglish, String wordInMiwok) {
        this.mDefaultTranslation = wordInEnglish;
        this.miwokTranslation = wordInMiwok;
        this.imageView =
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public void setmDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public void setMiwokTranslation(String miwokTranslation) {
        this.miwokTranslation = miwokTranslation;
    }
}
