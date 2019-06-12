package com.example.mypractice.photos;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class PhotosPresenterTest {

    @Mock
    PhotosContract.View mView;

    private  PhotosPresenter mPresenter;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mPresenter = new PhotosPresenter(mView);
    }

    @Test
    public void testSetPresenter(){
        mPresenter = new PhotosPresenter(mView);

        verify(mView).setPresenter(mPresenter);
    }
}