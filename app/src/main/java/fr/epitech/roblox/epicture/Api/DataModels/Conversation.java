package fr.epitech.roblox.epicture.Api.DataModels;

import java.util.Arrays;

public class Conversation {
    public int id;                      // 	Conversation ID
    public String last_message_preview; // 	Preview of the last message
    public int datetime;                // 	Time of last sent message, epoch time
    public int with_account_id;         // 	Account ID of the other user in conversation
    public String with_account;         // 	Account username of the other user in conversation
    public int message_count;           // 	Total number of messages in the conversation
    public Message[] messages;          // of Messages 	OPTIONAL: (only available when requesting a specific conversation) Reverse sorted such that most recent message is at the end of the array.
    public boolean done;                // 	OPTIONAL: (only available when requesting a specific conversation) Flag to indicate whether you've reached the beginning of the thread.
    public int page;                    // 	OPTIONAL: (only available when requesting a specific conversation) Number of the next page

    @Override
    public String toString() {
        return "Conversation{" +
                "id=" + id +
                ", last_message_preview='" + last_message_preview + '\'' +
                ", datetime=" + datetime +
                ", with_account_id=" + with_account_id +
                ", with_account='" + with_account + '\'' +
                ", message_count=" + message_count +
                ", messages=" + Arrays.toString(messages) +
                ", done=" + done +
                ", page=" + page +
                '}';
    }
}
