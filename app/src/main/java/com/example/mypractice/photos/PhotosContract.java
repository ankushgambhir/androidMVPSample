package com.example.mypractice.photos;

import com.example.mypractice.BasePresenter;
import com.example.mypractice.BaseView;
import com.example.mypractice.models.Photo;

import java.util.List;

public interface PhotosContract {

    interface View extends BaseView<Presenter>{
        void setLoadingIndicator(boolean isActive);
        void showLoader();
        void showPhotos(List<Photo> photoList);
        void showNoPhotosFound();
        void showError(String errorMessage);

    }

    interface Presenter extends BasePresenter{
        void fetchPhotos();
        void openPhotos(Photo photo);
    }
}
