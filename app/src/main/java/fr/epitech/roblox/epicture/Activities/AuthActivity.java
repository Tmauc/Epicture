package fr.epitech.roblox.epicture.Activities;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.ClientSecretPost;
import net.openid.appauth.TokenResponse;

import fr.epitech.roblox.epicture.App;
import fr.epitech.roblox.epicture.Auth;
import fr.epitech.roblox.epicture.R;

public class AuthActivity extends AppCompatActivity {

    AuthorizationService authService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Context ctx = this;

        AuthorizationResponse resp = AuthorizationResponse.fromIntent(getIntent());
        AuthorizationException ex = AuthorizationException.fromIntent(getIntent());
        if (resp != null) {

            authService = new AuthorizationService(this);

            App.authState.update(resp, ex);

            authService.performTokenRequest(
                    resp.createTokenExchangeRequest(),
                    new ClientSecretPost(Auth.CLIENT_SECRET),
                    new AuthorizationService.TokenResponseCallback() {
                        @Override public void onTokenRequestCompleted(
                                TokenResponse resp, AuthorizationException ex) {
                            if (resp != null) {
                                System.out.println("GOT TOKEN");
                                App.authState.update(resp, ex);
                                Auth.saveState();

                                Intent newIntent = new Intent(ctx, MainActivity.class);
                                newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(newIntent);
                            } else {
                                System.out.println("Failed to get token");
                            }
                        }
                    });

        } else {
            System.out.println("Auth failed");
        }

        setContentView(R.layout.activity_auth);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (authService != null)
            authService.dispose();
    }
}
