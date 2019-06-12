package com.example.mypractice.photos;

import com.example.mypractice.AppCoreConstants;
import com.example.mypractice.models.Photo;
import com.example.mypractice.models.PhotoList;
import com.example.mypractice.network.ApiConfig;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.google.common.base.Preconditions.checkNotNull;

public class PhotosPresenter implements PhotosContract.Presenter {

    private PhotosContract.View mView;

    public PhotosPresenter(PhotosContract.View view) {
        mView = checkNotNull(view, "Please provide a view to presenter");
        mView.setPresenter(this);
    }

    @Override
    public void fetchPhotos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppCoreConstants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiConfig apiConfig = retrofit.create(ApiConfig.class);
        Call<PhotoList> getPhotos = apiConfig.getPhotos();
        getPhotos.enqueue(new Callback<PhotoList>() {
            @Override
            public void onResponse(Call<PhotoList> call, Response<PhotoList> response) {
                mView.setLoadingIndicator(false);
                if(response.isSuccessful() && response.body()!= null){
                    mView.showPhotos(response.body().hits);
                } else {
                    mView.showError("Opps! We messed up");
                }
            }

            @Override
            public void onFailure(Call<PhotoList> call, Throwable t) {
                mView.showError("Opps! Something didn't worked");
            }
        });
    }

    @Override
    public void openPhotos(Photo photo) {

    }

    @Override
    public void onStart() {

    }
}
