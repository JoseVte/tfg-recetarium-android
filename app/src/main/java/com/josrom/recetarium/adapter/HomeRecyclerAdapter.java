package com.josrom.recetarium.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.josrom.recetarium.R;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    private List<String> friends;
    private Activity activity;

    public HomeRecyclerAdapter(Activity activity, List<String> friends) {
        this.friends = friends;
        this.activity = activity;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView textViewName = holder.textTitleRecipe;
        TextView textViewVersion = holder.textOtherRecipe;
        ImageView imageView = holder.imageRecipe;

        textViewName.setText(friends.get(listPosition));
        textViewVersion.setText(friends.get(listPosition));
        imageView.setImageResource(R.drawable.web_hi_res_512);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards_home_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return (null != friends ? friends.size() : 0);
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