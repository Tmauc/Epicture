package fr.epitech.roblox.epicture.Api.DataModels;

public class MemeMetadata {
    public String meme_name;    // 	The name of the meme used.
    public String top_text;     // 	The top text of the meme.
    public String bottom_text;  // 	The bottom text of the meme.
    public String bg_image;     // 	The image id of the background image of the meme.

    @Override
    public String toString() {
        return "MemeMetadata{" +
                "meme_name='" + meme_name + '\'' +
                ", top_text='" + top_text + '\'' +
                ", bottom_text='" + bottom_text + '\'' +
                ", bg_image='" + bg_image + '\'' +
                '}';
    }
}
