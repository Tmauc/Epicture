package fr.epitech.roblox.epicture.Api.DataModels;

public class Topic {
    public int id; // 	ID of the topic.
    public String name; // 	Topic name
    public String description; // 	Description of the topic
    public String css; // 	CSS class used on website to style the ephemeral topic
    public boolean ephemeral; // 	Whether it is an ephemeral (e.g. current events) topic
    public Object topPost; // Gallery Image OR Gallery Album 	The top image in this topic
    public Image heroImage; // 	The current 'hero' image chosen by the Imgur community staff
    public boolean isHero; // 	Whether the topic's heroImage should be used as the overall hero image

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", css='" + css + '\'' +
                ", ephemeral=" + ephemeral +
                ", topPost=" + topPost +
                ", heroImage=" + heroImage +
                ", isHero=" + isHero +
                '}';
    }
}
