package com.josrom.recetarium.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.josrom.recetarium.Constant;
import com.josrom.recetarium.R;
import com.josrom.recetarium.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    private List<Recipe> recipes;
    private Context context;

    public HomeRecyclerAdapter(Context context, List<Recipe> recipes) {
        this.recipes = recipes;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView textViewName = holder.textTitleRecipe;
        TextView textOtherRecipe = holder.textOtherRecipe;
        ImageView imageView = holder.imageRecipe;

        textViewName.setText(recipes.get(listPosition).getTitle());
        textOtherRecipe.setText(recipes.get(listPosition).getImageMain().getUrl());
        Picasso.with(context).load(Constant.URL + recipes.get(listPosition).getImageMain().getUrl()).into(imageView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards_home_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return (null != recipes ? recipes.size() : 0);
    }

    /**
     * View holder to display each RecylerView item
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTitleRecipe;
        TextView textOtherRecipe;
        ImageView imageRecipe;

        ViewHolder(View itemView) {
            super(itemView);
            this.textTitleRecipe = (TextView) itemView.findViewById(R.id.title_recipe_home);
            this.textOtherRecipe = (TextView) itemView.findViewById(R.id.other_recipe_home);
            this.imageRecipe = (ImageView) itemView.findViewById(R.id.main_image_home);
        }
    }
}