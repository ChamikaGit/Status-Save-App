package com.cd.statussaver.model;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class WhatsappStatusModel implements Serializable {
    public String name;
    public String uriString;
    public String path;
    public String filename;
    public WhatsappStatusModel(String name, String uriString, String path, String filename ) {
        this.name = name;
        this.uriString = uriString;
        this.path = path;
        this.filename = filename;
    }
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Uri getUri() {
//        return uri;
//    }
//
//    public void setUri(Uri uri) {
//        this.uri = uri;
//    }


    public String getUriString() {
        return uriString;
    }

    public void setUriString(String uriString) {
        this.uriString = uriString;
    }
}
