package fr.epitech.roblox.epicture.Api;

import fr.epitech.roblox.epicture.Api.DataModels.Account;
import fr.epitech.roblox.epicture.Api.DataModels.AccountSettings;
import fr.epitech.roblox.epicture.Api.DataModels.Comment;
import fr.epitech.roblox.epicture.Api.DataModels.GalleryAlbum;
import fr.epitech.roblox.epicture.Api.DataModels.GalleryAlbumImage;
import fr.epitech.roblox.epicture.Api.DataModels.GalleryImage;
import fr.epitech.roblox.epicture.Api.DataModels.Image;
import fr.epitech.roblox.epicture.Api.DataModels.RequestResult;
import fr.epitech.roblox.epicture.Api.DataModels.Tag;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IImgurAPI {
    @GET("image/{imageHash}")
    Call<RequestResult<Image>> getImage(@Path("imageHash") String imageHash);

    /**
     *
     * ACCOUNT
     *
     */

    @GET("https://api.imgur.com/3/account/{username}")
    Call<RequestResult<Account>> getAccountBase(
            @Path("username") String username);

    @GET("https://api.imgur.com/3/account/me/settings")
    Call<RequestResult<AccountSettings>> getAccountSettings();

    @GET("https://api.imgur.com/3/account/{user}/items/{sort}/{page}?album_previews=1")
    Call<RequestResult<GalleryAlbumImage[]>> getPosts(
            @Path("user") String user,
            @Path("sort") String sort,
            @Path("page") int page
    );

    @GET("https://api.imgur.com/3/account/{user}/favorites/{page}/{sort}")
    Call<RequestResult<GalleryAlbumImage[]>> getFavorites(
            @Path("user") String user,
            @Path("sort") String sort,
            @Path("page") int page
    );

    @GET("https://api.imgur.com/3/account/{user}/comments/{sort}/{page}")
    Call<RequestResult<Comment[]>> getComments(
            @Path("user") String user,
            @Path("sort") String sort,
            @Path("page") int page
    );

    /**
     *
     * GALLERY
     *
     */

    @GET("https://api.imgur.com/3/gallery/{section}/{sort}/{window}/{page}")
    Call<RequestResult<GalleryAlbumImage[]>> getGallery(
            @Path("section") String section,
            @Path("sort") String sort,
            @Path("window") String window,
            @Path("page") int page,
            @Query("showViral") boolean showViral,
            @Query("mature") boolean showMature,
            @Query("album_previews") boolean albumPreviews);

    @GET("https://api.imgur.com/3/gallery/r/{subreddit}/{sort}/{window}/{page}")
    Call<RequestResult<GalleryImage[]>> getSubRedditGallery(
            @Path("subreddit") String subreddit,
            @Path("sort") String sort,
            @Path("window") String window,
            @Path("page") int page);

    @GET("https://api.imgur.com/3/gallery/r/{subreddit}/{subredditImageId}")
    Call<RequestResult<GalleryImage>> getSubRedditImage(
            @Path("subreddit") String section,
            @Path("subredditImageId") String subredditImageId);

    @GET("https://api.imgur.com/3/gallery/t/{tagName}/{sort}/{window}/{page}")
    Call<RequestResult<Tag>> getGalleryTag(
            @Path("tagName") String tagName,
            @Path("sort") String sort,
            @Path("window") String window,
            @Path("page") int page);

    @GET("https://api.imgur.com/3/tags")
    Call<RequestResult<Tag[]>> getGalleryTags();

    @GET("https://api.imgur.com/3/gallery/tag_info/{tagName}")
    Call<RequestResult<Tag>> getGalleryTagInfo(
            @Path("tagName") String tagName);

    @GET("https://api.imgur.com/3/gallery/{galleryHash}/tags")
    Call<RequestResult<Tag>> getGalleryItemTags(
            @Path("galleryHash") String galleryHash);

    @GET("https://api.imgur.com/3/gallery/search/{sort}/{window}/{page}")
    Call<RequestResult<Object[]>> gallerySearch(
            @Path("sort") String sort,
            @Path("window") String window,
            @Path("page") int page,
            @Query("q") String q,
            @Query("q_all") String q_all,
            @Query("q_any") String q_any,
            @Query("q_exactly") String q_exactly,
            @Query("q_not") String q_not,
            @Query("q_type") String q_type,
            @Query("q_size_px") String q_size_px);

    @GET("https://api.imgur.com/3/gallery/album/{galleryHash}")
    Call<RequestResult<GalleryAlbum>> getGalleryAlbum(
            @Path("galleryHash") String galleryHash);

    @GET("https://api.imgur.com/3/gallery/image/{galleryImageHash}")
    Call<RequestResult<GalleryImage>> getGalleryImage(
            @Path("galleryImageHash") String galleryImageHash);

    @POST("https://api.imgur.com/3/gallery/image/{galleryHash}/report")
    Call<RequestResult> reportGalleryImage(
            @Path("galleryHash") String galleryHash,
            @Field("reason") int reason);

    /**
     *
     * IMAGES
     *
     */
    @Multipart
    @POST("https://api.imgur.com/3/image")
    Call<RequestResult<Image>> postImage(@Part("image") RequestBody image);
}
