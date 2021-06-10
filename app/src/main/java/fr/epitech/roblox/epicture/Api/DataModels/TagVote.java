package fr.epitech.roblox.epicture.Api.DataModels;

public class TagVote {
    public int ups;         // 	Number of upvotes.
    public int downs;       // 	Number of downvotes.
    public String name;     // 	Name of the tag.
    public String author;   // 	Author of the tag.

    @Override
    public String toString() {
        return "TagVote{" +
                "ups=" + ups +
                ", downs=" + downs +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
