package fr.epitech.roblox.epicture.Api.DataModels;

import java.util.Arrays;

public class CustomGallery {
    public String account_url; // 	Username of the account that created the custom gallery
    public String link; // 	The URL link to the custom gallery
    public Tag[] tags; // 	An array of all the tag names in the custom gallery
    public int item_count; // 	The total number of gallery items in the custom gallery
    public Object[] items; // of Gallery Images and Gallery Albums 	An array of all the gallery items in the custom gallery

    @Override
    public String toString() {
        return "CustomGallery{" +
                "account_url='" + account_url + '\'' +
                ", link='" + link + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", item_count=" + item_count +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
