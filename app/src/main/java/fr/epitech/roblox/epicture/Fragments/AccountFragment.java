package fr.epitech.roblox.epicture.Fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.epitech.roblox.epicture.App;
import fr.epitech.roblox.epicture.Fragments.Account.LoggedInFragment;
import fr.epitech.roblox.epicture.Fragments.Account.LoggedOutFragment;
import fr.epitech.roblox.epicture.R;

public class AccountFragment extends Fragment {

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (App.authState.isAuthorized()) {
            switchFragment(new LoggedInFragment());
        } else {
            System.out.println("NOT CONNECTED");
            switchFragment(new LoggedOutFragment());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private boolean switchFragment(Fragment frag) {
        if (frag == null)
            return false;
        FragmentTransaction transaction = this.getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.account_frame_layout, frag);
        transaction.commit();
        return true;
    }
}
