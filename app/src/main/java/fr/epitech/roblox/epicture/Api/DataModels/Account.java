package fr.epitech.roblox.epicture.Api.DataModels;

public class Account {
    public int id;
    public String url;
    public String bio;
    public String avatar;
    public String avatar_name;
    public String cover;
    public String cover_name;
    public float reputation;
    public String reputation_name;
    public int created;
    public Object pro_expiration;
    public boolean is_blocked;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", bio='" + bio + '\'' +
                ", avatar='" + avatar + '\'' +
                ", avatar_name='" + avatar_name + '\'' +
                ", cover='" + cover + '\'' +
                ", cover_name='" + cover_name + '\'' +
                ", reputation=" + reputation +
                ", reputation_name='" + reputation_name + '\'' +
                ", created=" + created +
                ", pro_expiration=" + pro_expiration +
                ", is_blocked=" + is_blocked +
                '}';
    }
}
