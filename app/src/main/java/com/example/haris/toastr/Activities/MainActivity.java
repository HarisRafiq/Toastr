package com.example.haris.toastr.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.*;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.haris.toastr.Adapters.GalleryAdapter;
import com.example.haris.toastr.Gallery.Gallery;
import com.example.haris.toastr.Gallery.GalleryApi;
import com.example.haris.toastr.Gallery.GalleryTypes;
import com.example.haris.toastr.R;
import com.example.haris.toastr.fragments.GalleryFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
     public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
           /* case R.id.action_settings:
                Intent intent = new Intent(this, PreferenceActivity.class);

                this.startActivity(intent);

        return true;
        */
        }
        return super.onOptionsItemSelected(item);
    }






}
