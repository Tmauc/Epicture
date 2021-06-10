package fr.epitech.roblox.epicture.Api;

public class MediaUrl {

    private String url;
    private int width;
    private int height;

    public MediaUrl(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
