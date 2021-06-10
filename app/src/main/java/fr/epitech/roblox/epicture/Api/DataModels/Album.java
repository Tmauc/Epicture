package fr.epitech.roblox.epicture.Api.DataModels;

import java.util.Arrays;

public class Album {
    public String id;           // 	The ID for the album
    public String title;        // 	The title of the album in the gallery
    public String description;  // 	The description of the album in the gallery
    public int datetime;        // 	Time inserted into the gallery, epoch time
    public String cover;        // 	The ID of the album cover image
    public int cover_width;     // 	The width, in pixels, of the album cover image
    public int cover_height;    // 	The height, in pixels, of the album cover image
    public String account_url;  // 	The account username or null if it's anonymous.
    public int account_id;      // 	The account ID or null if it's anonymous.
    public String privacy;      // 	The privacy level of the album, you can only view public if not logged in as album owner
    public String layout;       // 	The view layout of the album.
    public int views;           // 	The number of album views
    public String link;         // 	The URL link to the album
    public boolean favorite;    // 	Indicates if the current user favorited the image. Defaults to false if not signed in.
    public boolean nsfw;        // 	Indicates if the image has been marked as nsfw or not. Defaults to null if information is not available.
    public String section;      // 	If the image has been categorized by our backend then this will contain the section the image belongs in. (funny, cats, adviceanimals, wtf, etc)
    public int order;           // 	Order number of the album on the user's album page (defaults to 0 if their albums haven't been reordered)
    public String deletehash;   // 	OPTIONAL, the deletehash, if you're logged in as the album owner
    public int images_count;    // 	The total number of images in the album
    public Image[] images;      // of Images 	An array of all the images in the album (only available when requesting the direct album)
    public boolean in_gallery;  // 	True if the image has been submitted to the gallery, false if otherwise

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", cover='" + cover + '\'' +
                ", cover_width=" + cover_width +
                ", cover_height=" + cover_height +
                ", account_url='" + account_url + '\'' +
                ", account_id=" + account_id +
                ", privacy='" + privacy + '\'' +
                ", layout='" + layout + '\'' +
                ", views=" + views +
                ", link='" + link + '\'' +
                ", favorite=" + favorite +
                ", nsfw=" + nsfw +
                ", section='" + section + '\'' +
                ", order=" + order +
                ", deletehash='" + deletehash + '\'' +
                ", images_count=" + images_count +
                ", images=" + Arrays.toString(images) +
                ", in_gallery=" + in_gallery +
                '}';
    }
}
