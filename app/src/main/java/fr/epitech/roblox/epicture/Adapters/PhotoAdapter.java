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
import fr.epitech.roblox.epicture.Api.DataModels.GalleryAlbumImage;
import fr.epitech.roblox.epicture.Api.MediaUrl;
import fr.epitech.roblox.epicture.ImgurGlide;
import fr.epitech.roblox.epicture.R;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder> {
    private ArrayList<GalleryAlbumImage> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout view;
        public MyViewHolder(ConstraintLayout v) {
            super(v);
            view = v;
        }
    }

    public PhotoAdapter(ArrayList<GalleryAlbumImage> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PhotoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_recycler_photo, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GalleryAlbumImage img = mDataset.get(position);

        System.out.println(img);

        TextView title = holder.view.findViewById(R.id.text);
        title.setText(img.title);

        TextView upvotes = holder.view.findViewById(R.id.upvotes);
        upvotes.setText(Integer.toString(img.ups));

        TextView downvotes = holder.view.findViewById(R.id.downvotes);
        downvotes.setText(Integer.toString(img.downs));

        TextView comments = holder.view.findViewById(R.id.comments);
        comments.setText(Integer.toString(img.comment_count));

        TextView views = holder.view.findViewById(R.id.views);
        views.setText(Integer.toString(img.views));


        MediaUrl thumbnail = img.getThumbnail();

        View v = holder.view.findViewById(R.id.image);

        ConstraintSet cs = new ConstraintSet();
        cs.clone(holder.view);
        cs.setDimensionRatio(R.id.image, "H," + thumbnail.getWidth() + ":" + thumbnail.getHeight());
        cs.applyTo(holder.view);

        ImgurGlide
                .with(holder.view.getContext())
                .load(thumbnail.getUrl())
                .placeholder(R.drawable.ic_baseline_photo_24px)
                .into((ImageView) holder.view.findViewById(R.id.image));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
