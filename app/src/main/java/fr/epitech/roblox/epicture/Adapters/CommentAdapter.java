package fr.epitech.roblox.epicture.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;
import fr.epitech.roblox.epicture.Api.DataModels.Comment;
import fr.epitech.roblox.epicture.Api.DataModels.GalleryAlbumImage;
import fr.epitech.roblox.epicture.Api.MediaUrl;
import fr.epitech.roblox.epicture.ImgurGlide;
import fr.epitech.roblox.epicture.R;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {
    private ArrayList<Comment> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout view;
        public MyViewHolder(ConstraintLayout v) {
            super(v);
            view = v;
        }
    }

    public CommentAdapter(ArrayList<Comment> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CommentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_recycler_comment, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Comment com = mDataset.get(position);

        TextView text = holder.view.findViewById(R.id.text);
        text.setText(com.comment);

        TextView upvotes = holder.view.findViewById(R.id.upvotes);
        upvotes.setText(Integer.toString(com.ups));

        TextView downvotes = holder.view.findViewById(R.id.downvotes);
        downvotes.setText(Integer.toString(com.downs));

        System.out.println("https://i.imgur.com/" + com.image_id + ".jpg");

        ImgurGlide
                .with(holder.view.getContext())
                .load("https://i.imgur.com/" + com.album_cover + ".jpg")
                .placeholder(R.drawable.ic_baseline_photo_24px)
                .into((ImageView) holder.view.findViewById(R.id.image));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
