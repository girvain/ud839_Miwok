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
    private int audioId;


    public Word(String wordInEnglish, String wordInMiwok, int audioId) {
        this.mDefaultTranslation = wordInEnglish;
        this.miwokTranslation = wordInMiwok;
        this.audioId = audioId;
    }

    public Word(String mDefaultTranslation, String miwokTranslation, int imageResourceId, int audioId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId = imageResourceId;
        this.audioId = audioId;
    }

    public int getAudioId() {
        return audioId;
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

    /* to string */

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", miwokTranslation='" + miwokTranslation + '\'' +
                ", imageResourceId=" + imageResourceId +
                ", audioId=" + audioId +
                '}';
    }
}
