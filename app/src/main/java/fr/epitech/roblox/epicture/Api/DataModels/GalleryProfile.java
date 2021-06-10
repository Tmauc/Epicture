package fr.epitech.roblox.epicture.Api.DataModels;

import java.util.Arrays;

public class GalleryProfile {
    public int total_gallery_comments;      // 	Total number of comments the user has made in the gallery
    public int total_gallery_favorites;     // 	Total number of items favorited by the user in the gallery
    public int total_gallery_submissions;   // 	Total number of images submitted by the user.
    public Trophy[] trophies;               // 	An array of trophies that the user has.

    @Override
    public String toString() {
        return "GalleryProfile{" +
                "total_gallery_comments=" + total_gallery_comments +
                ", total_gallery_favorites=" + total_gallery_favorites +
                ", total_gallery_submissions=" + total_gallery_submissions +
                ", trophies=" + Arrays.toString(trophies) +
                '}';
    }
}
