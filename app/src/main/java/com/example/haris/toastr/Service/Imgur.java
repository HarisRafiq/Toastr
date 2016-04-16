package com.example.haris.toastr.Service;

import com.example.haris.toastr.Gallery.GalleryApi;
import com.example.haris.toastr.Gallery.GalleryTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Haris on 4/11/2016.
 */
public class Imgur {
 private  static GalleryTypes galleryTypes;
private static GalleryApi galleryApi;
    private static   Retrofit retrofit;

    public static GalleryApi getGalleryApi() {

        if (galleryApi == null) {
            galleryApi = getRetrofit().create(GalleryApi.class);
        }

        return galleryApi;
    }
private static Retrofit getRetrofit(){
if(retrofit==null) {
    retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.imgur.com/3/")

            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

return retrofit;
}
    public static void getGallery(GalleryTypes galleryTypes) {
        getGallery(galleryTypes.getSection(), galleryTypes.getSort(), galleryTypes.getWindow(),
                galleryTypes.getPage(), galleryTypes.showViral());
    }

    private static void getGallery(String section, String sort, String window, int page, boolean b) {
   getGalleryApi().loadGallery(section,sort,window,page,b);
    }


}
