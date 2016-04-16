package com.example.haris.toastr.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.view.View;

import com.example.haris.toastr.Gallery.GalleryTypes;
import com.example.haris.toastr.fragments.GalleryFragment;

/**
 * Created by Haris on 4/12/2016.
 */
public class GalleryPagerAdapter extends FragmentPagerAdapter {


    public GalleryPagerAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(GalleryFragment.GALLERY_SECTION,
                GalleryTypes.Section.getSections().get(position));
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public int getCount() {
        return GalleryTypes.Section.getSections().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return GalleryTypes.Section.getSections().get(position);
    }
}
