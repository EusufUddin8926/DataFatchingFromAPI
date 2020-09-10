package com.example.datafatchingfromapi.model;

public class ItemClass {

    private int id;
    private int albumID;
    private String FirstimgURL;
    private String SecoundimgURL;
    private String mtittle;

    public ItemClass() {
    }

    public ItemClass(int id, int albumID, String firstimgURL, String secoundimgURL, String mtittle) {
        this.id = id;
        this.albumID = albumID;
        FirstimgURL = firstimgURL;
        SecoundimgURL = secoundimgURL;
        this.mtittle = mtittle;
    }

    public int getId() {
        return id;
    }

    public int getAlbumID() {
        return albumID;
    }

    public String getFirstimgURL() {
        return FirstimgURL;
    }

    public String getSecoundimgURL() {
        return SecoundimgURL;
    }

    public String getMtittle() {
        return mtittle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public void setFirstimgURL(String firstimgURL) {
        FirstimgURL = firstimgURL;
    }

    public void setSecoundimgURL(String secoundimgURL) {
        SecoundimgURL = secoundimgURL;
    }

    public void setMtittle(String mtittle) {
        this.mtittle = mtittle;
    }
}
