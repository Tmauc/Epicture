package fr.epitech.roblox.epicture.Api.DataModels;

public class Notification {
    public int d;           // 	The ID for the notification
    public int account_id;  // 	The Account ID for the notification
    public boolean viewed;  // 	Has the user viewed the image yet?
    public Object content;  // 	This can be any other model, currently only using comments and conversation metadata.

    @Override
    public String toString() {
        return "Notification{" +
                "d=" + d +
                ", account_id=" + account_id +
                ", viewed=" + viewed +
                ", content=" + content +
                '}';
    }
}
