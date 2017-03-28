package com.kalyanamela.android.data.model;

import com.google.gson.annotations.Expose;

import java.util.List;


public class ProfileResponse {

    @Expose
    private String status;
    @Expose
    private List<Profile> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Profile> getResult() {
        return result;
    }

    public void setResult(List<Profile> result) {
        this.result = result;
    }
}
