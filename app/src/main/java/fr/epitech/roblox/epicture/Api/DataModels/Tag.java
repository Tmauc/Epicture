package fr.epitech.roblox.epicture.Api.DataModels;

import java.util.Arrays;

public class Tag {
    public String name; // 	Name of the tag.
    public int followers; // 	Number of followers for the tag.
    public int total_items; // 	Total number of gallery items for the tag.
    public boolean following; // 	OPTIONAL, boolean representing whether or not the user is following the tag in their custom gallery
    public Object[] items; // of Gallery Images and Gallery Albums 	Gallery items with current tag.

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", followers=" + followers +
                ", total_items=" + total_items +
                ", following=" + following +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
