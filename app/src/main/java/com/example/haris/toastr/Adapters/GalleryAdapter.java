package com.example.haris.toastr.Adapters;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.haris.toastr.Gallery.GalleryResult;
import com.example.haris.toastr.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Haris on 4/11/2016.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
View itemView;

    List<GalleryResult>galleryList;
    public GalleryAdapter(List<GalleryResult> galleries){

        this.galleryList=galleries;

    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_fragment,parent,false);
        GalleryViewHolder gvh=new GalleryViewHolder(itemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final GalleryViewHolder holder, int position) {
holder.textView.setText(galleryList.get(position).getTitle());

        Picasso.with(itemView.getContext()).load(galleryList.get(position).getImageUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public void add(List<GalleryResult> items) {
        galleryList.addAll(items);
        notifyDataSetChanged();    }
public List getGalleryResults(){
    return galleryList;



}
    /**
     * Clears all items in lists
     */
    public void clear() {
        galleryList.clear();
        notifyDataSetChanged();
    }
    public static class GalleryViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView textView;
        ImageView imageView;
        GalleryViewHolder(View itemView){
            super(itemView);
            cv=(CardView)itemView.findViewById(R.id.cv);
            textView=(TextView)itemView.findViewById(R.id.gallery_result_title);
imageView=(ImageView)itemView.findViewById(R.id.gallery_result_image);
        }

    }



}
