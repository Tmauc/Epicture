package fr.epitech.roblox.epicture.Services;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.OpenableColumns;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.Nullable;
import fr.epitech.roblox.epicture.Api.DataModels.Image;
import fr.epitech.roblox.epicture.Api.IImgurAPI;
import fr.epitech.roblox.epicture.Api.ImgurAPI;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class UploadService extends IntentService {

    public UploadService() {
        this("Roblox");
    }

    public UploadService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            Uri uri = intent.getData();

            InputStream inputStream = null;
            try {
                inputStream = getContentResolver().openInputStream(uri);
                byte[] buf = new byte[inputStream.available()];
                while (inputStream.read(buf) != -1);
                RequestBody requestBody = RequestBody
                        .create(MediaType.parse("application/octet-stream"), buf);
                ImgurAPI.call(ImgurAPI.getApi().postImage(requestBody), new ImgurAPI.ApiResponse<Image>() {
                    @Override
                    public void response(Image body) {
                        System.out.println("IMAGE UPLOADED");
                        System.out.println(body);
                    }

                    @Override
                    public void fail(int responseCode) {

                    }
                });
            } catch (FileNotFoundException e) {
                System.out.println("FILE NOT FOUND");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //ImgurAPI.getApi().postImage(RequestBody.create(MediaType.parse("image/*")), )
        }
    }

}
