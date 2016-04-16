package com.example.haris.toastr.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haris.toastr.Adapters.GalleryAdapter;
import com.example.haris.toastr.Adapters.GalleryPagerAdapter;
import com.example.haris.toastr.Activities.DetailsActivity;
import com.example.haris.toastr.Events.RecyclerItemClickListener;
import com.example.haris.toastr.Gallery.Gallery;
import com.example.haris.toastr.Gallery.GalleryApi;
import com.example.haris.toastr.Gallery.GalleryResult;
import com.example.haris.toastr.Gallery.GalleryTypes;
 import com.example.haris.toastr.R;
import com.example.haris.toastr.Service.Imgur;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Haris on 4/12/2016.
 */
public class GalleryFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = GalleryFragment.class.getSimpleName();
    int toggle = 1;

    public static final String GALLERY_SECTION = "GALLERY_SECTION";
    private static final String SAVED_GALLERY_DATA = "SAVED_GALLERY_DATA";
    private static final String SAVED_GALLERY_TYPE = "SAVED_GALLERY_TYPE";
    private SwipeRefreshLayout galleryContainer;
    private GalleryAdapter galleryAdapter;
    private GalleryApi galleryApi;
    private Gallery galleryData = new Gallery();
    private GalleryTypes galleryTypes = new GalleryTypes();

    RecyclerView recyclerView;
    StaggeredGridLayoutManager mStaggeredLayoutManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            loadValuesFromArguments(getArguments());
        }
        if (savedInstanceState != null) {
            galleryData = (Gallery) savedInstanceState.getSerializable(SAVED_GALLERY_DATA);
            galleryTypes = (GalleryTypes) savedInstanceState.getSerializable(SAVED_GALLERY_TYPE);
         }


        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


loadPreference();
        loadViews(view);

    }
    private void loadValuesFromArguments(@NonNull Bundle arguments) {
        galleryTypes.setSection(arguments.getString(GALLERY_SECTION));
    }

void loadPreference(){

    SharedPreferences sharedPrefs = PreferenceManager
            .getDefaultSharedPreferences(getContext());
    String layoutType=sharedPrefs.getString("layoutType", "NULL");

    String galleryType=sharedPrefs.getString("sortType","NULL");

    Boolean isViral=sharedPrefs.getBoolean("viral_enabled,",true);
    galleryTypes.setShowViral(isViral);

    if(galleryType!=null)
        galleryTypes.setSort(galleryType);

    if(layoutType.equals( "true"))
    {
        toggle=1;


    }
    else toggle=2;

}
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(SAVED_GALLERY_DATA, galleryData);
        outState.putSerializable(SAVED_GALLERY_TYPE, galleryTypes);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
    private void loadGalleryContainerView(View container) {
        galleryContainer = (SwipeRefreshLayout) container.findViewById(R.id.gallery_container);
        galleryContainer.setOnRefreshListener(this);
        galleryContainer.setRefreshing(false);

    }

    private void loadViews(View container) {
        loadGalleryContainerView(container);

loadGalleryView(container);

        loadGallery();
    }
void loadGalleryView(final View container){


        recyclerView = (RecyclerView) container.findViewById(R.id.gallery);
    mStaggeredLayoutManager=null;
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(toggle,
                StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        GalleryResult gallery_result = (GalleryResult) galleryAdapter.getGalleryResults().get(position);
                        Intent intent = new Intent(getActivity(), DetailsActivity.class);
                        intent.putExtra("selected_image", gallery_result);

                        getActivity().startActivity(intent);
                    }
                })
        );

    }
    private void resetGalleryInfo() {
        galleryTypes.setPage(0);
    }

    private void resetGallery() {
        galleryData = new Gallery();
        galleryAdapter.clear();
    }

    public void loadGallery() {

        galleryContainer.setRefreshing(true);
galleryApi=Imgur.getGalleryApi();
        Call<Gallery> call = galleryApi.loadGallery(galleryTypes.getSection(), galleryTypes.getSort(), galleryTypes.getWindow(), galleryTypes.getPage(), galleryTypes.showViral());
        call.enqueue(new Callback<Gallery>() {


            @Override
            public void onResponse(Response<Gallery> response) {
                try {

                    galleryAdapter = new GalleryAdapter(response.body().getData());


                    recyclerView.setAdapter(galleryAdapter);
                    galleryTypes.setPage(galleryTypes.getPage() + 1);
                    galleryContainer.setRefreshing(false);

                } catch (Exception e) {
                    e.printStackTrace();
                    galleryContainer.setRefreshing(false);

                }
            }

            @Override
            public void onFailure(Throwable t) {

            }


        });
    }

    @Override
    public void onRefresh() {

        resetGalleryInfo();
        loadPreference();
        resetGallery();
        loadGallery();

    }




}
