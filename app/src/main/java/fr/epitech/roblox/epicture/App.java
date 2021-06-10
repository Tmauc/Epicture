package fr.epitech.roblox.epicture;

import android.app.Application;
import android.content.Context;

import net.openid.appauth.AuthState;

import java.io.IOException;

public class App extends Application {

    private static Context context;

    public static AuthState authState;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();

        authState = Auth.loadState();
        System.out.println("ACCESS TOKEN: " + authState.getAccessToken());

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static Context getContext() {
        return context;
    }
}
