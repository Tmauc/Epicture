package fr.epitech.roblox.epicture.Api.DataModels;

import java.util.Arrays;

public class Comment {
    public int id;              // 	The ID for the comment
    public String image_id;     // 	The ID of the image that the comment is for
    public String comment;      // 	The comment itself.
    public String author;       // 	Username of the author of the comment
    public int author_id;       // 	The account ID for the author
    public boolean on_album;    // 	If this comment was done to an album
    public String album_cover;  // 	The ID of the album cover image, this is what should be displayed for album comments
    public int ups;             // 	Number of upvotes for the comment
    public int downs;           // 	The number of downvotes for the comment
    public float points;        // 	the number of upvotes - downvotes
    public int datetime;        // 	Timestamp of creation, epoch time
    public int parent_id;       // 	If this is a reply, this will be the value of the comment_id for the caption this a reply for.
    public boolean deleted;     // 	Marked true if this caption has been deleted
    public String vote;         // 	The current user's vote on the comment. null if not signed in or if the user hasn't voted on it.
    public Comment[] children;  // of comments 	All of the replies for this comment. If there are no replies to the comment then this is an empty set.

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", image_id='" + image_id + '\'' +
                ", comment='" + comment + '\'' +
                ", author='" + author + '\'' +
                ", author_id=" + author_id +
                ", on_album=" + on_album +
                ", album_cover='" + album_cover + '\'' +
                ", ups=" + ups +
                ", downs=" + downs +
                ", points=" + points +
                ", datetime=" + datetime +
                ", parent_id=" + parent_id +
                ", deleted=" + deleted +
                ", vote='" + vote + '\'' +
                ", children=" + Arrays.toString(children) +
                '}';
    }
}
