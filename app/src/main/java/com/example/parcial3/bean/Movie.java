package com.example.parcial3.bean;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("title")
    public String mTitle;
    @SerializedName("year")
    public String mYear;
    @SerializedName("runtime")
    public String mRuntime;
    //@SerializedName("genres")
    //public String mGenres;
    @SerializedName("director")
    public String mDirector;
    @SerializedName("actors")
    public String mActors;
    @SerializedName("plot")
    public String mPlot;
    @SerializedName("posterUrl")
    public String mImageUrl;

    public Movie(){

    }

    public Movie(String mTitle, String mYear, String mRuntime,String mActors, String mPlot, String mImageUrl, String mDirector) {
        this.mTitle = mTitle;
        this.mImageUrl = mImageUrl;
        this.mDirector = mDirector;
        this.mYear = mYear;
        this.mActors = mActors;
        this.mPlot = mPlot;
        this.mRuntime = mRuntime;
        //this.mGenres = mGenres;
    }

}
