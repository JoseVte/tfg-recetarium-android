package com.josrom.recetarium.navigation;

public class DrawerItem {
    private String text;
    private int icon;

    public DrawerItem(String text, int icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public static DrawerItem getDrawerItem(String item) {
        switch (item) {
            case "login":
                return new DrawerItem("Login / Registro", android.R.drawable.ic_lock_lock);
            default:
                return null;
        }
    }
}
