package fr.epitech.roblox.epicture.Api.DataModels;

import java.util.Arrays;

public class AccountSettings {
    public String account_url;              // The account username
    public String email;                    // The users email address
    public boolean public_images;           // Automatically allow all images to be publicly accessible
    public String album_privacy;            // Set the album privacy to this privacy setting on creation
    public Object pro_expiration;           // False if not a pro user, their expiration date if they are.
    public boolean accepted_gallery_terms;  // True if the user has accepted the terms of uploading to the Imgur gallery.
    public String[] active_emails;          // Array of Strings     The email addresses that have been activated to allow uploading
    public boolean messaging_enabled;       // If the user is accepting incoming messages or not
    public String[] blocked_users;          // Array of objects     An array of users that have been blocked from messaging, the object is blocked_id and blocked_url.
    public boolean show_mature;             // True if the user has opted to have mature images displayed in gallery list endpoints.
    public boolean first_party;             // True unless the user created their account via a third party service such as Google Plus.

    @Override
    public String toString() {
        return "AccountSettings{" +
                "account_url='" + account_url + '\'' +
                ", email='" + email + '\'' +
                ", public_images=" + public_images +
                ", album_privacy='" + album_privacy + '\'' +
                ", pro_expiration=" + pro_expiration +
                ", accepted_gallery_terms=" + accepted_gallery_terms +
                ", active_emails=" + Arrays.toString(active_emails) +
                ", messaging_enabled=" + messaging_enabled +
                ", blocked_users=" + Arrays.toString(blocked_users) +
                ", show_mature=" + show_mature +
                ", first_party=" + first_party +
                '}';
    }
}
