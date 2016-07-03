package com.josrom.recetarium.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.josrom.recetarium.Constant;
import com.josrom.recetarium.R;
import com.josrom.recetarium.adapter.HomeRecyclerAdapter;
import com.josrom.recetarium.application.ConfigApp;
import com.josrom.recetarium.model.Recipe;
import com.josrom.recetarium.navigation.DrawerItem;
import com.josrom.recetarium.navigation.DrawerListAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private String TAG = "GET_RECIPES";
    private RecyclerView recyclerView;
    private List<Recipe> mListRecipes = null;
    private String url = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Toolbar collapsible
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        if (collapsingToolbar != null) {
            collapsingToolbar.setTitle(getString(R.string.app_name));
        }

        // Navigation drawer
        setDrawerMenu();

        // All recipes listed
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_home);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            setData(); //adding data to array list
        }

    }

    private void setData() {
        url = url == null ? Constant.URL_LIST_RECIPES : url;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (mListRecipes == null) {
                            mListRecipes = new ArrayList<>();
                        }
                        try {
                            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                                JSONObject recipe = response.getJSONArray("data").getJSONObject(i);
                                mListRecipes.add(new Recipe(recipe));
                            }

                            recyclerView.setAdapter(new HomeRecyclerAdapter(getApplicationContext(), mListRecipes));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("TAG", "Error: " + error.getMessage());
                    }
        });

        ConfigApp.getInstance(getApplicationContext()).addToRequestQueue(request, TAG);
    }

    // TODO Terminar el menu de navegacion
    private void setDrawerMenu() {
        String[] itemsArray = getResources().getStringArray(R.array.drawer);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ListView navigationDrawer = (ListView) findViewById(R.id.navigation_drawer);
        List<DrawerItem> items = new ArrayList<>();

        for (String item : itemsArray) {
            DrawerItem itemObject = DrawerItem.getDrawerItem(item);
            if (itemObject != null) {
                items.add(itemObject);
            }
        }

        if (navigationDrawer != null) {
            navigationDrawer.setAdapter(new DrawerListAdapter(this, items));
        }
    }
}
