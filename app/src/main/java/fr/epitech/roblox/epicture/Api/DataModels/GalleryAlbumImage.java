package fr.epitech.roblox.epicture.Api.DataModels;

import java.util.Arrays;

import fr.epitech.roblox.epicture.Api.MediaUrl;

public class GalleryAlbumImage {
    /**
     * COMMON
     */
    public String id;               // 	The ID for the image
    public String title;            // 	The title of the album in the gallery
    public String description;      // 	The description of the album in the gallery
    public Integer datetime;            // 	Time inserted into the gallery, epoch time
    public int views;               // 	The number of image views
    public String link;             // 	The direct link to the the image. (Note: if fetching an animated GIF that was over 20MB in original size, a .gif thumbnail will be returned)
    public String vote;             // 	The current user's vote on the album. null if not signed in or if the user hasn't voted on it.
    public Boolean favorite;        // 	Indicates if the current user favorited the image. Defaults to false if not signed in.
    public Boolean nsfw;            // 	Indicates if the image has been marked as nsfw or not. Defaults to null if information is not available.
    public int comment_count;       // 	Number of comments on the gallery image.
    public String topic;            // 	Topic of the gallery image.
    public Integer topic_id;            // 	Topic ID of the gallery image.
    public String account_url;      // 	The username of the account that uploaded it, or null.
    public Integer account_id;          // 	The account ID of the account that uploaded it, or null.
    public int ups;                 // 	Upvotes for the image
    public int downs;               // 	Number of downvotes for the image
    public int points;              // 	Upvotes minus downvotes
    public int score;               // 	Imgur popularity score
    public Boolean is_album;        // 	If it's an album or not
    public Object in_most_viral;   // 	Indicates if the image is in the most viral gallery or not.

    /**
     * ALBUM
     */

    public String cover;            // 	The ID of the album cover image
    public Integer cover_width;         // 	The width, in pixels, of the album cover image
    public Integer cover_height;        // 	The height, in pixels, of the album cover image
    public String privacy;          // 	The privacy level of the album, you can only view public if not logged in as album owner
    public String layout;           // 	The view layout of the album.
    public Integer images_count;        // 	The total number of images in the album
    public Image[] images;          // of Images 	An array of all the images in the album (only available when requesting the direct album)

    /**
     * IMAGE
     */
    public String type;             // 	Image MIME type.
    public Boolean animated;        // 	is the image animated
    public Integer width;               // 	The width of the image in pixels
    public Integer height;              // 	The height of the image in pixels
    public Integer size;                // 	The size of the image in bytes
    public Long bandwidth;           // 	Bandwidth consumed by the image in bytes
    public String deletehash;       // 	OPTIONAL, the deletehash, if you're logged in as the image owner
    public String gifv;             // 	OPTIONAL, The .gifv link. Only available if the image is animated and type is 'image/gif'.
    public String mp4;              // 	OPTIONAL, The direct link to the .mp4. Only available if the image is animated and type is 'image/gif'.
    public Integer mp4_size;            // 	OPTIONAL, The Content-Length of the .mp4. Only available if the image is animated and type is 'image/gif'. Note that a zero value (0) is possible if the video has not yet been generated
    public Boolean looping;         // 	OPTIONAL, Whether the image has a looping animation. Only available if the image is animated and type is 'image/gif'.
    public String section;          // 	If the image has been categorized by our backend then this will contain the section the image belongs in. (funny, cats, adviceanimals, wtf, etc)


    public MediaUrl getThumbnail() {
        if (this.images != null && this.images.length > 0)
            return new MediaUrl(this.images[0].link, this.images[0].width, this.images[0].height);
        else
            return new MediaUrl(this.link, this.width, this.height);
    }

    public String getTitle() {
        return this.title == null ? "" : this.title;
    }

    @Override
    public String toString() {
        return "GalleryAlbumImage{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", views=" + views +
                ", link='" + link + '\'' +
                ", vote='" + vote + '\'' +
                ", favorite=" + favorite +
                ", nsfw=" + nsfw +
                ", comment_count=" + comment_count +
                ", topic='" + topic + '\'' +
                ", topic_id=" + topic_id +
                ", account_url='" + account_url + '\'' +
                ", account_id=" + account_id +
                ", ups=" + ups +
                ", downs=" + downs +
                ", points=" + points +
                ", score=" + score +
                ", is_album=" + is_album +
                ", in_most_viral=" + in_most_viral +
                ", cover='" + cover + '\'' +
                ", cover_width=" + cover_width +
                ", cover_height=" + cover_height +
                ", privacy='" + privacy + '\'' +
                ", layout='" + layout + '\'' +
                ", images_count=" + images_count +
                ", images=" + Arrays.toString(images) +
                ", type='" + type + '\'' +
                ", animated=" + animated +
                ", width=" + width +
                ", height=" + height +
                ", size=" + size +
                ", bandwidth=" + bandwidth +
                ", deletehash='" + deletehash + '\'' +
                ", gifv='" + gifv + '\'' +
                ", mp4='" + mp4 + '\'' +
                ", mp4_size=" + mp4_size +
                ", looping=" + looping +
                ", section='" + section + '\'' +
                '}';
    }
}
