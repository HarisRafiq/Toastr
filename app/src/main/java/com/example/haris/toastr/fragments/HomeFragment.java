package com.example.haris.toastr.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.haris.toastr.Adapters.GalleryPagerAdapter;
import com.example.haris.toastr.Activities.DetailsActivity;
import com.example.haris.toastr.Gallery.Gallery;
import com.example.haris.toastr.Gallery.GalleryTypes;
import com.example.haris.toastr.R;
import com.example.haris.toastr.Activities.SettingsActivity;
import com.nispok.views.SlidingTabLayout;

import java.util.Set;

/**
 * Created by Haris on 4/12/2016.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    ViewPager viewPager;
    SlidingTabLayout slidingTabLayout;
    Boolean shouldLoadGallery;
   private static SharedPreferences sharedPreferences;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        setHasOptionsMenu(true);
        shouldLoadGallery=false;

        return inflater.inflate(R.layout.home_fragments, container, false);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())           {


             case R.id.action_settings:
                 shouldLoadGallery=true;
                 Intent intent = new Intent(getActivity(), SettingsActivity.class);
                 getActivity().startActivity(intent);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new GalleryPagerAdapter(getActivity().getSupportFragmentManager()));

        slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);

        slidingTabLayout.setDistributeEvenly(true);

        slidingTabLayout.setViewPager(viewPager);
        slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));

     }
void changeLayout(){

    viewPager.setAdapter(null);

    viewPager.setAdapter(new GalleryPagerAdapter(getActivity().getSupportFragmentManager()));
    slidingTabLayout.setViewPager(viewPager);
shouldLoadGallery=false;
}

    @Override
    public void onResume() {
        super.onResume();
        if(shouldLoadGallery)
        changeLayout();

    }


}
