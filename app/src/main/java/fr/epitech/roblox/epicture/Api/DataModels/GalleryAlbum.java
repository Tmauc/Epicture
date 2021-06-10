package fr.epitech.roblox.epicture.Api.DataModels;

import java.util.Arrays;

public class GalleryAlbum {
    public String id;               // 	The ID for the image
    public String title;            // 	The title of the album in the gallery
    public String description;      // 	The description of the album in the gallery
    public int datetime;            // 	Time inserted into the gallery, epoch time
    public String cover;            // 	The ID of the album cover image
    public int cover_width;         // 	The width, in pixels, of the album cover image
    public int cover_height;        // 	The height, in pixels, of the album cover image
    public String account_url;      // 	The account username or null if it's anonymous.
    public int account_id;          // 	The account ID of the account that uploaded it, or null.
    public String privacy;          // 	The privacy level of the album, you can only view public if not logged in as album owner
    public String layout;           // 	The view layout of the album.
    public int views;               // 	The number of image views
    public String link;             // 	The URL link to the album
    public int ups;                 // 	Upvotes for the image
    public int downs;               // 	Number of downvotes for the image
    public int points;              // 	Upvotes minus downvotes
    public int score;               // 	Imgur popularity score
    public boolean is_album;        // 	if it's an album or not
    public String vote;             // 	The current user's vote on the album. null if not signed in or if the user hasn't voted on it.
    public boolean favorite;        // 	Indicates if the current user favorited the album. Defaults to false if not signed in.
    public boolean nsfw;            // 	Indicates if the album has been marked as nsfw or not. Defaults to null if information is not available.
    public int comment_count;       // 	Number of comments on the gallery album.
    public String topic;            // 	Topic of the gallery album.
    public int topic_id;            // 	Topic ID of the gallery album.
    public int images_count;        // 	The total number of images in the album
    public Image[] images;          // of Images 	An array of all the images in the album (only available when requesting the direct album)
    public boolean in_most_viral;   // 	Indicates if the album is in the most viral gallery or not.

    @Override
    public String toString() {
        return "GalleryAlbum{" +
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
                ", ups=" + ups +
                ", downs=" + downs +
                ", points=" + points +
                ", score=" + score +
                ", is_album=" + is_album +
                ", vote='" + vote + '\'' +
                ", favorite=" + favorite +
                ", nsfw=" + nsfw +
                ", comment_count=" + comment_count +
                ", topic='" + topic + '\'' +
                ", topic_id=" + topic_id +
                ", images_count=" + images_count +
                ", images=" + Arrays.toString(images) +
                ", in_most_viral=" + in_most_viral +
                '}';
    }
}
