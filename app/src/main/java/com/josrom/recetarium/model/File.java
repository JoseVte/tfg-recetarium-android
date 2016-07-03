package com.josrom.recetarium.model;

import org.json.JSONException;
import org.json.JSONObject;

public class File extends Model {
    private int id;
    private String url;

    public File(JSONObject file) throws JSONException {
        this.id = file.getInt("id");
        this.url = "/users/" + file.getJSONObject("user").getInt("id") + "/files/" + file.getString("new_title");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
