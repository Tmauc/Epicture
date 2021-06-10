package fr.epitech.roblox.epicture;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.ResponseTypeValues;

import org.json.JSONException;

import fr.epitech.roblox.epicture.Activities.AuthActivity;

import static android.content.Context.MODE_PRIVATE;

public class Auth {

    public static final String CLIENT_ID = "fd16ac1e193f236";
    public static final String CLIENT_SECRET = "7a0ba5bb8934d4096559d004fcc18123dd9d69ae";
    private static Uri REDIRECT_URI = Uri.parse("fr.epicture.roblox://oauth2redirect");

    public static AuthorizationServiceConfiguration serviceConfig;

    static {
        serviceConfig =
                new AuthorizationServiceConfiguration(
                        Uri.parse("https://api.imgur.com/oauth2/authorize"), // authorization endpoint
                        Uri.parse("https://api.imgur.com/oauth2/token")); // token endpoint
    }

    public static void authorize(Context ctx) {
        AuthorizationRequest.Builder authRequestBuilder =
                new AuthorizationRequest.Builder(
                        Auth.serviceConfig, // the authorization service configuration
                        CLIENT_ID, // the client ID, typically pre-registered and static
                        ResponseTypeValues.CODE, // the response_type value: we want a code
                        REDIRECT_URI); // the redirect URI to which the auth response is sent
        AuthorizationRequest authRequest = authRequestBuilder.build();

        AuthorizationService authService = new AuthorizationService(ctx);

        authService.performAuthorizationRequest(
                authRequest,
                PendingIntent.getActivity(ctx, 0, new Intent(ctx, AuthActivity.class), 0),
                PendingIntent.getActivity(ctx, 0, new Intent(ctx, AuthActivity.class), 0));
    }


    public static void saveState() {
        SharedPreferences authPrefs = App.getContext().getSharedPreferences("auth", MODE_PRIVATE);
        authPrefs.edit()
                .putString("stateJson", App.authState.jsonSerializeString())
                .apply();
    }

    public static AuthState loadState() {
        SharedPreferences authPrefs = App.getContext().getSharedPreferences("auth", MODE_PRIVATE);
        String stateStr = authPrefs.getString("stateJson", null);
        if (stateStr != null) {
            try {
                return AuthState.jsonDeserialize(stateStr);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return new AuthState();
    }

    public static void clearState() {
        SharedPreferences authPrefs = App.getContext().getSharedPreferences("auth", MODE_PRIVATE);
        authPrefs.edit().remove("stateJson").apply();
        App.authState = Auth.loadState();
    }
}
