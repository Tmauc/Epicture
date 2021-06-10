package fr.epitech.roblox.epicture.Api.DataModels;

public class RequestResult<T> {
    public T data;
    public boolean success;
    public int status;

    @Override
    public String toString() {
        return "RequestResult{" +
                "data=" + data +
                ", success=" + success +
                ", status=" + status +
                '}';
    }
}
