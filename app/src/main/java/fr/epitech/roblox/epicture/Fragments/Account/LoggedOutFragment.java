package fr.epitech.roblox.epicture.Fragments.Account;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.epitech.roblox.epicture.Auth;
import fr.epitech.roblox.epicture.R;

public class LoggedOutFragment extends Fragment {

    private View signInButton;

    public LoggedOutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_logged_out, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.signInButton = getView().findViewById(R.id.signInButton);
        this.signInButton.setOnClickListener(onSignInClickListener);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private View.OnClickListener onSignInClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Auth.authorize(getContext());
        }
    };
}
