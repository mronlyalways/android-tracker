package com.rafaelkonlechner.tracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;

import com.google.inject.Inject;
import com.rafaelkonlechner.tracker.data.*;
import com.rafaelkonlechner.tracker.model.Category;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;


public class HomeActivity extends RoboActivity {

    public final static String SELECTED_CATEGORY = "com.rafaelkonlechner.tracker.SELECTED_CATEGORY";

    @Inject                     private TestDataService dataService;
    @InjectView(R.id.grid_view)  private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.grid_tile, R.id.tile_text, dataService.loadCategories());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, CategoryDetailActivity.class);
                Category c = (Category) parent.getItemAtPosition(position);
                intent.putExtra(SELECTED_CATEGORY, c);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
