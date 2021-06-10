package fr.epitech.roblox.epicture.Adapters;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import fr.epitech.roblox.epicture.Fragments.Account.Tabs.MyCommentsFragment;
import fr.epitech.roblox.epicture.Fragments.Account.Tabs.MyFavoritesFragment;
import fr.epitech.roblox.epicture.Fragments.Account.Tabs.MyPostsFragment;
import fr.epitech.roblox.epicture.R;

public class AccountTabsAdapter extends FragmentPagerAdapter {

    private String user;
    private Context mContext;

    public AccountTabsAdapter(Context context, FragmentManager fm, String user) {
        super(fm);
        mContext = context;
        this.user = user;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        b.putString("user", this.user);
        Fragment f;
        if (position == 0) {
            f = new MyPostsFragment();
        } else if (position == 1){
            f = new MyFavoritesFragment();
        } else if (position == 2){
            f = new MyCommentsFragment();
        } else {
            return null;
        }
        f.setArguments(b);
        return f;
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 3;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.account_tab_posts_title);
            case 1:
                return mContext.getString(R.string.account_tab_favorites_title);
            case 2:
                return mContext.getString(R.string.account_tab_comments_title);
            default:
                return null;
        }
    }

}
