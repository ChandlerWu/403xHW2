package com.bignerdranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

public class Crime {

    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_DATE = "date";
    private static final String JSON_SOLVED = "solved";
    private static final String JSON_PHOTO = "photo";
    private static final String JSON_PHOTO2 = "photo2";
    private static final String JSON_PHOTO3 = "photo3";
    private static final String JSON_PHOTO4 = "photo4";
    
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private Photo mPhoto;
    private Photo mPhoto2;
    private Photo mPhoto3;
    private Photo mPhoto4;
    private int photosTaken = 0;
    
    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public Crime(JSONObject json) throws JSONException {
        mId = UUID.fromString(json.getString(JSON_ID));
        mTitle = json.getString(JSON_TITLE);
        mSolved = json.getBoolean(JSON_SOLVED);
        mDate = new Date(json.getLong(JSON_DATE));
        if (json.has(JSON_PHOTO))
            mPhoto = new Photo(json.getJSONObject(JSON_PHOTO));
        if (json.has(JSON_PHOTO2))
            mPhoto2 = new Photo(json.getJSONObject(JSON_PHOTO2));
        if (json.has(JSON_PHOTO3))
            mPhoto3 = new Photo(json.getJSONObject(JSON_PHOTO3));
        if (json.has(JSON_PHOTO4))
            mPhoto4 = new Photo(json.getJSONObject(JSON_PHOTO4));
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_ID, mId.toString());
        json.put(JSON_TITLE, mTitle);
        json.put(JSON_SOLVED, mSolved);
        json.put(JSON_DATE, mDate.getTime());
        if (mPhoto != null)
            json.put(JSON_PHOTO, mPhoto.toJSON());
        if (mPhoto2 != null)
            json.put(JSON_PHOTO2, mPhoto2.toJSON());
        if (mPhoto3 != null)
            json.put(JSON_PHOTO3, mPhoto3.toJSON());
        if (mPhoto4 != null)
            json.put(JSON_PHOTO4, mPhoto4.toJSON());
        return json;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Photo getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Photo photo) {
        mPhoto = photo;
    }

	public Photo getPhoto2() {
		return mPhoto2;
	}

	public void setPhoto2(Photo photo) {
		mPhoto2 = photo;
	}

    public Photo getPhoto3() {
        return mPhoto3;
    }

    public void setPhoto3(Photo photo) {
        mPhoto3 = photo;
    }

    public Photo getPhoto4() {
        return mPhoto4;
    }

    public void setPhoto4(Photo photo) {
        mPhoto4 = photo;
    }

    public int getPhotosTaken() {
        return photosTaken;
    }

    public void onePhotosTaken() {
        photosTaken = photosTaken + 1;
    }

    public void resetPhotosTaken() {
        photosTaken = 0;
    }

}
