package com.example.android.miwok;

import android.widget.ImageView;

/**
 * Created by gavinross on 05/12/2017.
 */

public class Word {

    private String mDefaultTranslation;
    private String miwokTranslation;
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(String wordInEnglish, String wordInMiwok) {
        this.mDefaultTranslation = wordInEnglish;
        this.miwokTranslation = wordInMiwok;
    }

    public Word(String mDefaultTranslation, String miwokTranslation, int imageResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
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


    // AMAZING !!!
    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }
}
