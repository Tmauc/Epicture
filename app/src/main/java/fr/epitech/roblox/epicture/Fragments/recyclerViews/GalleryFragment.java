package fr.epitech.roblox.epicture.Fragments.recyclerViews;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import fr.epitech.roblox.epicture.Adapters.PhotoAdapter;
import fr.epitech.roblox.epicture.Api.DataModels.GalleryAlbumImage;
import fr.epitech.roblox.epicture.Api.ImgurAPI;
import fr.epitech.roblox.epicture.R;
import fr.epitech.roblox.epicture.Utils.EndlessRecyclerViewScrollListener;

public class GalleryFragment extends Fragment {

    private int page = 0;
    private String section = "hot"; // hot | top | user
    private String sort = "viral"; // viral | top | time | rising
    private String window = "day"; // day | week | month | year | all
    private boolean showViral = true;
    private boolean mature = false;
    private boolean album_previews = true;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<GalleryAlbumImage> dataset = new ArrayList<>();

    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.recyclerView = view.findViewById(R.id.recycler_view);
        this.recyclerView.setHasFixedSize(true);

        this.layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        this.recyclerView.setLayoutManager(this.layoutManager);

        this.adapter = new PhotoAdapter(dataset);
        this.recyclerView.setAdapter(this.adapter);

        this.recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener((StaggeredGridLayoutManager) this.layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadGallery();
            }
        });

        loadGallery();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void loadGallery() {
        ImgurAPI.call(ImgurAPI.getApi().getGallery(
                this.section, this.sort, this.window, this.page, this.showViral, this.mature, this.album_previews),
                new ImgurAPI.ApiResponse<GalleryAlbumImage[]>() {
            @Override
            public void response(GalleryAlbumImage[] body) {
                for (GalleryAlbumImage i: body) {
                    dataset.add(i);
                    adapter.notifyItemInserted(dataset.size() - 1);
                }
                page++;
            }

            @Override
            public void fail(int responseCode) {
                System.out.println("ERRROR " + responseCode);
            }
        });
    }

}
