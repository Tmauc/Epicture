package fr.epitech.roblox.epicture.Api.DataModels;

public class Message {
    public int id;              // 	The ID for the message
    public String from;         // 	Account username of person sending the message
    public int account_id;      // 	The account ID of the person receiving the message
    public int sender_id;       // 	The account ID of the person who sent the message
    public String body;         // 	Text of the message
    public int conversation_id; // 	ID for the overall conversation
    public int datetime;        // 	Time message was sent, epoch time

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", account_id=" + account_id +
                ", sender_id=" + sender_id +
                ", body='" + body + '\'' +
                ", conversation_id=" + conversation_id +
                ", datetime=" + datetime +
                '}';
    }
}
