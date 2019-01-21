package com.example.tungnguyen.koichung.model;

import com.example.tungnguyen.koichung.model.detail.ListimageConfirm;

import java.util.List;

public class DoubleImage {
    private ListimageConfirm imageFirst;
    private ListimageConfirm imageSecond;

    public DoubleImage() {

    }

    public ListimageConfirm getImageFirst() {
        return imageFirst;
    }

    public void setImageFirst(ListimageConfirm imageFirst) {
        this.imageFirst = imageFirst;
    }

    public ListimageConfirm getImageSecond() {
        return imageSecond;
    }

    public void setImageSecond(ListimageConfirm imageSecond) {
        this.imageSecond = imageSecond;
    }
}
