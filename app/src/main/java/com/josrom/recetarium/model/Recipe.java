package com.josrom.recetarium.model;

import com.josrom.recetarium.model.enums.RecipeDifficulty;
import com.josrom.recetarium.model.enums.RecipeVisibility;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class Recipe extends Model {
    private int id;
    private String title;
    private String slug;
    private String steps;
    private File imageMain;
    private RecipeVisibility visibility;
    private RecipeDifficulty difficulty;
    //private Cateogry category;
    //private User user;
    private Date createdAt;
    private Date updatedAt;

    public Recipe(int id, String title, String slug, /*File imageMain*/ RecipeVisibility visibility, RecipeDifficulty difficulty, String createdAt, String updatedAt) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.visibility = visibility;
        this.difficulty = difficulty;

        this.createdAt = parseDateTime(createdAt);
        this.updatedAt = parseDateTime(updatedAt);
    }

    public Recipe(JSONObject recipe) throws JSONException {
        this.id = recipe.getInt("id");
        this.title = recipe.getString("title");
        this.slug = recipe.getString("slug");
        this.visibility = RecipeVisibility.valueOf(recipe.getString("visibility"));
        this.difficulty = RecipeDifficulty.valueOf(recipe.getString("difficulty"));
        this.createdAt = parseDateTime(recipe.getString("created_at"));
        this.updatedAt = parseDateTime(recipe.getString("updated_at"));

        this.imageMain = new File(recipe.getJSONObject("image_main"));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getImageMain() {
        return imageMain;
    }

    public void setImageMain(File imageMain) {
        this.imageMain = imageMain;
    }
}
