package com.example.mypractice.photos.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypractice.R;
import com.example.mypractice.models.Photo;

import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {

    private Context mConext;
    private List<Photo> mPhotos;

    public PhotoListAdapter(List<Photo> photos, Context context){
        this.mConext = context;
        this.mPhotos = photos;
    }

    @NonNull
    @Override
    public PhotoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo_list, viewGroup, false);
        PhotoListAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tags.setText("Tags: " + mPhotos.get(i).getTags());
        Glide.with(mConext).load(mPhotos.get(i).getPreviewURL()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tags;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tags = itemView.findViewById(R.id.photoTags);
            imageView = itemView.findViewById(R.id.photoId);
        }
    }
}
