package fr.epitech.roblox.epicture.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentTransaction;
import fr.epitech.roblox.epicture.Fragments.recyclerViews.GalleryFragment;
import fr.epitech.roblox.epicture.R;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Fragment f = (Fragment) new GalleryFragment();

        FragmentTransaction transaction = this.getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, f);
        transaction.commit();


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
