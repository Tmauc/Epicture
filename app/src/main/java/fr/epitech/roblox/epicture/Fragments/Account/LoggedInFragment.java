package fr.epitech.roblox.epicture.Fragments.Account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import fr.epitech.roblox.epicture.Activities.MainActivity;
import fr.epitech.roblox.epicture.Adapters.AccountTabsAdapter;
import fr.epitech.roblox.epicture.Api.DataModels.Account;
import fr.epitech.roblox.epicture.Api.DataModels.AccountSettings;
import fr.epitech.roblox.epicture.Api.ImgurAPI;
import fr.epitech.roblox.epicture.Auth;
import fr.epitech.roblox.epicture.ImgurGlide;
import fr.epitech.roblox.epicture.R;

public class LoggedInFragment extends Fragment {

    private String user = "me";

    private ViewPager vp;
    private TabLayout tabLayout;

    public LoggedInFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.user = savedInstanceState.getString("user", "me");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_logged_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Context ctx = this.getContext();
        final View viewCtx = view;

        Button logOut = view.findViewById(R.id.logout_button);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auth.clearState();
                Intent newIntent = new Intent(ctx, MainActivity.class);
                newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(newIntent);
            }
        });

        this.vp = view.findViewById(R.id.pager);
        vp.setAdapter(new AccountTabsAdapter(ctx, getFragmentManager(), this.user));

        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(vp);

        System.out.println(savedInstanceState);

        if (savedInstanceState != null)
            tabLayout.getTabAt(savedInstanceState.getInt("page", 0)).select();

        ImgurAPI.call(ImgurAPI.getApi().getAccountSettings(), new ImgurAPI.ApiResponse<AccountSettings>() {
            @Override
            public void response(final AccountSettings accountSettings) {
                ImgurAPI.call(ImgurAPI.getApi().getAccountBase(accountSettings.account_url), new ImgurAPI.ApiResponse<Account>() {
                    @Override
                    public void response(Account account) {
                        ImgurGlide.with(ctx)
                                .load(account.cover)
                                .centerCrop()
                                .into((ImageView) viewCtx.findViewById(R.id.image_cover));
                        ImgurGlide.with(ctx)
                                .load(account.avatar)
                                .centerCrop()
                                .into((ImageView) viewCtx.findViewById(R.id.image_profile));

                        TextView username = view.findViewById(R.id.username);
                        username.setText(accountSettings.account_url);

                        TextView points = view.findViewById(R.id.points);
                        points.setText(account.reputation + "pts");

                        TextView status = view.findViewById(R.id.status);
                        status.setText(account.reputation_name);
                    }

                    @Override
                    public void fail(int responseCode) {
                    }
                });
            }

            @Override
            public void fail(int responseCode) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        System.out.println(tabLayout.getSelectedTabPosition());
        outState.putInt("page", tabLayout.getSelectedTabPosition());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
