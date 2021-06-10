package fr.epitech.roblox.epicture.Api.DataModels;

public class Trophy {
    public int id;              // 	The ID of the trophy, this is unique to each trophy
    public String name;         // 	The name of the trophy
    public String name_clean;   // 	Can be thought of as the ID of a trophy type
    public String description;  // 	A description of the trophy and how it was earned.
    public String data;         // 	The ID of the image or the ID of the comment where the trophy was earned
    public String data_link;    // 	A link to where the trophy was earned
    public int datetime;        // 	Date the trophy was earned, epoch time
    public String image;        // 	URL of the image representing the trophy

    @Override
    public String toString() {
        return "Trophy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", name_clean='" + name_clean + '\'' +
                ", description='" + description + '\'' +
                ", data='" + data + '\'' +
                ", data_link='" + data_link + '\'' +
                ", datetime=" + datetime +
                ", image='" + image + '\'' +
                '}';
    }
}
