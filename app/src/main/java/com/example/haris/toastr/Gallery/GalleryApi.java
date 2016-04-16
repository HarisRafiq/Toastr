package com.example.haris.toastr.Gallery;

import com.example.haris.toastr.BuildConfig;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Haris on 4/11/2016.
 */
public interface GalleryApi {
    @Headers({"Authorization:Client-ID "+ BuildConfig.IMGUR_CLIENT_ID,
            "User-Agent: Toastr"
    })

    @GET("gallery/{section}/{sort}/{window}/{page}")
    Call<Gallery> loadGallery(@Path("section") String section,
                             @Path("sort") String sort,
                             @Path("window") String window,
                             @Path("page") int page,
                             @Query("showViral") boolean showViral);
}
