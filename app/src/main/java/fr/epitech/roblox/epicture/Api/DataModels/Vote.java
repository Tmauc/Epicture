package fr.epitech.roblox.epicture.Api.DataModels;

public class Vote {
    public int ups;     // 	Number of upvotes
    public int downs;   // 	Number of downvotes

    @Override
    public String toString() {
        return "Vote{" +
                "ups=" + ups +
                ", downs=" + downs +
                '}';
    }
}
