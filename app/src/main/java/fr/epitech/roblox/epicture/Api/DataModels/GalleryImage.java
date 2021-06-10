package fr.epitech.roblox.epicture.Api.DataModels;

public class GalleryImage {
    public String id;               // 	The ID for the image
    public String title;            // 	The title of the image.
    public String description;      // 	Description of the image.
    public int datetime;            // 	Time inserted into the gallery, epoch time
    public String type;             // 	Image MIME type.
    public boolean animated;        // 	is the image animated
    public int width;               // 	The width of the image in pixels
    public int height;              // 	The height of the image in pixels
    public int size;                // 	The size of the image in bytes
    public int views;               // 	The number of image views
    public int bandwidth;           // 	Bandwidth consumed by the image in bytes
    public String deletehash;       // 	OPTIONAL, the deletehash, if you're logged in as the image owner
    public String link;             // 	The direct link to the the image. (Note: if fetching an animated GIF that was over 20MB in original size, a .gif thumbnail will be returned)
    public String gifv;             // 	OPTIONAL, The .gifv link. Only available if the image is animated and type is 'image/gif'.
    public String mp4;              // 	OPTIONAL, The direct link to the .mp4. Only available if the image is animated and type is 'image/gif'.
    public int mp4_size;            // 	OPTIONAL, The Content-Length of the .mp4. Only available if the image is animated and type is 'image/gif'. Note that a zero value (0) is possible if the video has not yet been generated
    public boolean looping;         // 	OPTIONAL, Whether the image has a looping animation. Only available if the image is animated and type is 'image/gif'.
    public String vote;             // 	The current user's vote on the album. null if not signed in or if the user hasn't voted on it.
    public boolean favorite;        // 	Indicates if the current user favorited the image. Defaults to false if not signed in.
    public boolean nsfw;            // 	Indicates if the image has been marked as nsfw or not. Defaults to null if information is not available.
    public int comment_count;       // 	Number of comments on the gallery image.
    public String topic;            // 	Topic of the gallery image.
    public int topic_id;            // 	Topic ID of the gallery image.
    public String section;          // 	If the image has been categorized by our backend then this will contain the section the image belongs in. (funny, cats, adviceanimals, wtf, etc)
    public String account_url;      // 	The username of the account that uploaded it, or null.
    public int account_id;          // 	The account ID of the account that uploaded it, or null.
    public int ups;                 // 	Upvotes for the image
    public int downs;               // 	Number of downvotes for the image
    public int points;              // 	Upvotes minus downvotes
    public int score;               // 	Imgur popularity score
    public boolean is_album;        // 	If it's an album or not
    public boolean in_most_viral;   // 	Indicates if the image is in the most viral gallery or not.

    @Override
    public String toString() {
        return "GalleryImage{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", type='" + type + '\'' +
                ", animated=" + animated +
                ", width=" + width +
                ", height=" + height +
                ", size=" + size +
                ", views=" + views +
                ", bandwidth=" + bandwidth +
                ", deletehash='" + deletehash + '\'' +
                ", link='" + link + '\'' +
                ", gifv='" + gifv + '\'' +
                ", mp4='" + mp4 + '\'' +
                ", mp4_size=" + mp4_size +
                ", looping=" + looping +
                ", vote='" + vote + '\'' +
                ", favorite=" + favorite +
                ", nsfw=" + nsfw +
                ", comment_count=" + comment_count +
                ", topic='" + topic + '\'' +
                ", topic_id=" + topic_id +
                ", section='" + section + '\'' +
                ", account_url='" + account_url + '\'' +
                ", account_id=" + account_id +
                ", ups=" + ups +
                ", downs=" + downs +
                ", points=" + points +
                ", score=" + score +
                ", is_album=" + is_album +
                ", in_most_viral=" + in_most_viral +
                '}';
    }
}
