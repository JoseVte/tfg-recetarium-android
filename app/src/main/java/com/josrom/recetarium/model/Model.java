package com.josrom.recetarium.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Model {
    private DateFormat format = new SimpleDateFormat("yyyy-MM-d HH:mm:ss");
    public Date parseDateTime(String date) {
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}

