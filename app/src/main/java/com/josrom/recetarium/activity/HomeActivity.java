package com.josrom.recetarium.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.josrom.recetarium.R;
import com.josrom.recetarium.adapter.HomeRecyclerAdapter;
import com.josrom.recetarium.navigation.DrawerItem;
import com.josrom.recetarium.navigation.DrawerListAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> stringArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Toolbar collapsible
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle(getString(R.string.app_name));

        setDrawerMenu();

        // All recipes listed
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_home);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setData(); //adding data to array list
        recyclerView.setAdapter(new HomeRecyclerAdapter(this, stringArrayList));

    }

    private void setData() {
        stringArrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            stringArrayList.add("Item " + (i + 1));
        }
    }

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
