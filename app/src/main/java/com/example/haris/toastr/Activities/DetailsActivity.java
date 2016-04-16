package com.example.haris.toastr.Activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.haris.toastr.Gallery.Gallery;
import com.example.haris.toastr.Gallery.GalleryResult;
import com.example.haris.toastr.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Haris on 4/13/2016.
 */
public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       GalleryResult galleryResult = (GalleryResult) getIntent().getSerializableExtra("selected_image");

        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(galleryResult.getTitle());
        TextView descTextView = (TextView) findViewById(R.id.desc);
        descTextView.setText(galleryResult.getDescription());
        TextView downTextView = (TextView) findViewById(R.id.downs);
        downTextView.setText("Downvote:"+galleryResult.getDowns());
        TextView upTextView = (TextView) findViewById(R.id.ups);
        upTextView.setText("Upvote:" + galleryResult.getUps());
        TextView scoreTextView = (TextView) findViewById(R.id.score);
        scoreTextView.setText("Score:"+galleryResult.getScore());
        ImageView imageView = (ImageView) findViewById(R.id.gallery_result_image);
        Picasso.with(this.getApplicationContext()).load(galleryResult.getImageUrl()).into(imageView
        );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition()  ;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}