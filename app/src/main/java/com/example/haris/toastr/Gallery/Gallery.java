package com.example.haris.toastr.Gallery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haris on 4/11/2016.
 */
public class Gallery  implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<GalleryResult> data = new ArrayList<>();
    private boolean success;
    private Integer status;
    public List<GalleryResult> getData() {
        return data;
    }

    public void setData(List<GalleryResult> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }
}
