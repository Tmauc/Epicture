package fr.epitech.roblox.epicture.Activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import fr.epitech.roblox.epicture.Fragments.AccountFragment;
import fr.epitech.roblox.epicture.Fragments.HomeFragment;
import fr.epitech.roblox.epicture.R;
import fr.epitech.roblox.epicture.Services.UploadService;

public class MainActivity extends AppCompatActivity {

    private int READ_REQUEST_CODE = 42069;

    private FrameLayout frameLayout;

    private Fragment homeFragment = new HomeFragment();
    private Fragment accountFragment = new AccountFragment();


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = homeFragment;
                    break;
                case R.id.navigation_account:
                    selectedFragment = accountFragment;
                    break;
            }
            return switchFragment(selectedFragment);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (data != null) {
                uri = data.getData();
                Intent i = new Intent(MainActivity.this, UploadService.class);
                i.setData(uri);
                startService(i);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.frameLayout = findViewById(R.id.navigation_frame_layout);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        switchFragment(homeFragment);

        this.findViewById(R.id.uploadButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, READ_REQUEST_CODE);
            }
        });
    }

    private boolean switchFragment(Fragment frag) {
        if (frag == null)
            return false;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.navigation_frame_layout, frag);
        transaction.commit();
        return true;
    }

}
