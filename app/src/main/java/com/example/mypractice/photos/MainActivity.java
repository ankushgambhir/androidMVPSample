package com.example.mypractice.photos;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypractice.R;
import com.example.mypractice.models.Photo;
import com.example.mypractice.photos.adapters.PhotoListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PhotosContract.View, OnPhotoClickListener {
    private TextView mTv;
    private PhotosPresenter mPhotoPresenter;
    private RecyclerView rcv;
    private LinearLayoutManager llm;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mPhotoPresenter = new PhotosPresenter(this);
        showLoader();
        setLoadingIndicator(true);
        mPhotoPresenter.fetchPhotos();
    }

    private void initViews() {
    rcv = (RecyclerView)findViewById(R.id.rcv);
    mTv = findViewById(R.id.mTv);
    llm = new LinearLayoutManager(this);
    rcv.setLayoutManager(llm);
    }


    @Override
    public void setLoadingIndicator(boolean isActive) {
        if(!isActive && mProgressDialog!= null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showLoader() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Loading");
        mProgressDialog.show();
    }

    @Override
    public void showPhotos(List<Photo> photoList) {
        rcv.setVisibility(View.VISIBLE);
        PhotoListAdapter photoListAdapter = new PhotoListAdapter(photoList, this);
        rcv.setAdapter(photoListAdapter);
    }

    @Override
    public void showNoPhotosFound() {

    }

    @Override
    public void showError(String errorMessage) {
        mTv.setText(errorMessage);
        mTv.setVisibility(View.VISIBLE);
        Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPresenter(PhotosContract.Presenter presenter) {

    }

    @Override
    public void onPhotoClicked(Photo photo) {

    }
}
