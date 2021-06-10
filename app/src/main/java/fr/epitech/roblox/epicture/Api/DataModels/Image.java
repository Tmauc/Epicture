package fr.epitech.roblox.epicture.Api.DataModels;

public class Image {
    public String id;               // 	The ID for the image
    public String title;            // 	The title of the image.
    public String description;      // 	Description of the image.
    public int datetime;            // 	Time uploaded, epoch time
    public String type;             // 	Image MIME type.
    public boolean animated;        // 	is the image animated
    public int width;               // 	The width of the image in pixels
    public int height;              // 	The height of the image in pixels
    public int size;                // 	The size of the image in bytes
    public int views;               // 	The number of image views
    public long bandwidth;           // 	Bandwidth consumed by the image in bytes
    public String deletehash;       // 	OPTIONAL, the deletehash, if you're logged in as the image owner
    public String name;             // 	OPTIONAL, the original filename, if you're logged in as the image owner
    public String section;          // 	If the image has been categorized by our backend then this will contain the section the image belongs in. (funny, cats, adviceanimals, wtf, etc)
    public String link;             // 	The direct link to the the image. (Note: if fetching an animated GIF that was over 20MB in original size, a .gif thumbnail will be returned)
    public String gifv;             // 	OPTIONAL, The .gifv link. Only available if the image is animated and type is 'image/gif'.
    public String mp4;              // 	OPTIONAL, The direct link to the .mp4. Only available if the image is animated and type is 'image/gif'.
    public int mp4_size;            // 	OPTIONAL, The Content-Length of the .mp4. Only available if the image is animated and type is 'image/gif'. Note that a zero value (0) is possible if the video has not yet been generated
    public boolean looping;         // 	OPTIONAL, Whether the image has a looping animation. Only available if the image is animated and type is 'image/gif'.
    public boolean favorite;        // 	Indicates if the current user favorited the image. Defaults to false if not signed in.
    public boolean nsfw;            // 	Indicates if the image has been marked as nsfw or not. Defaults to null if information is not available.
    public String vote;             // 	The current user's vote on the album. null if not signed in, if the user hasn't voted on it, or if not submitted to the gallery.
    public boolean in_gallery;      // 	True if the image has been submitted to the gallery, false if otherwise.

    @Override
    public String toString() {
        return "Image{" +
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
                ", name='" + name + '\'' +
                ", section='" + section + '\'' +
                ", link='" + link + '\'' +
                ", gifv='" + gifv + '\'' +
                ", mp4='" + mp4 + '\'' +
                ", mp4_size=" + mp4_size +
                ", looping=" + looping +
                ", favorite=" + favorite +
                ", nsfw=" + nsfw +
                ", vote='" + vote + '\'' +
                ", in_gallery=" + in_gallery +
                '}';
    }
}
