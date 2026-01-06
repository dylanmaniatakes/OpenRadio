package com.unified.ur1.inbox;

import i3.AbstractC0576e;
import i3.AbstractC0578g;
import i3.C;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/* loaded from: classes.dex */
public interface MessageApiService {
    @POST("teams.php")
    Call<ApiResponse> createTeam(@Body AbstractC0578g abstractC0578g);

    @GET("messages.php")
    Call<Object> getDeliveryStatus(@Query("action") String str, @Query("message_id") int i5);

    @GET("fcm.php")
    Call<Object> getFCMStatus(@Query("action") String str, @Query("callsign") String str2);

    @GET("messages.php")
    Call<MessageResponse> getMessages(@Query("callsign") String str, @Query("offset") int i5, @Query("limit") int i6);

    @GET("messages.php")
    Call<MessageResponse> getMessagesAfter(@Query("callsign") String str, @Query("after_timestamp") long j5, @Query("offset") int i5, @Query("limit") int i6);

    @GET("messages.php")
    Call<MessageResponse> getSentMessages(@Query("action") String str, @Query("from_callsign") String str2, @Query("offset") int i5, @Query("limit") int i6);

    @GET("teams.php")
    Call<Object> getTeamDetails(@Query("action") String str, @Query("team_id") String str2, @Query("callsign") String str3);

    @GET("messages.php")
    Call<MessageResponse> getTeamMessages(@Query("action") String str, @Query("team_id") String str2, @Query("callsign") String str3, @Query("offset") int i5, @Query("limit") int i6);

    @GET("typing.php")
    Call<String> getTeamTypingStatus(@Query("action") String str, @Query("team_id") String str2, @Query("callsign") String str3);

    @GET("typing.php")
    Call<Object> getTypingStatus(@Query("action") String str, @Query("from") String str2, @Query("to") String str3);

    @GET("messages.php")
    Call<Object> getUnreadCount(@Query("action") String str, @Query("callsign") String str2);

    @GET("teams.php")
    Call<Object> getUserTeams(@Query("callsign") String str);

    @POST("teams.php")
    Call<ApiResponse> joinTeam(@Query("action") String str, @Query("team_id") String str2, @Query("callsign") String str3, @Query("invite_code") String str4);

    @POST("teams.php")
    Call<ApiResponse> leaveTeam(@Query("action") String str, @Query("team_id") String str2, @Query("callsign") String str3);

    @PUT("messages.php")
    Call<ApiResponse> markAllAsRead(@Query("action") String str, @Query("callsign") String str2);

    @PUT("messages.php")
    Call<ApiResponse> markAsRead(@Query("action") String str, @Query("id") int i5);

    @PUT("messages.php")
    Call<ApiResponse> markAsReadWithCallsign(@Query("action") String str, @Query("id") int i5, @Query("callsign") String str2);

    @GET("ping.php")
    Call<ApiResponse> pingServer(@Query("callsign") String str);

    @POST("fcm.php")
    Call<ApiResponse> registerFCMToken(@Body FCMTokenRequest fCMTokenRequest);

    @GET("https://ur1.unifiedradios.com/api-user/users")
    Call<Object> searchUsers(@Query("search") String str, @Query("cloud_auth") String str2);

    @GET("https://ur1.unifiedradios.com/api-user/users")
    Call<ResponseBody> searchUsersRaw(@Query("search") String str, @Query("cloud_auth") String str2);

    @POST("messages.php")
    Call<ApiResponse> sendMessage(@Body SendMessageRequest sendMessageRequest);

    @POST("messages.php")
    Call<ApiResponse> sendMessageWithAttachments(@Body AbstractC0576e abstractC0576e);

    @POST("messages.php")
    Call<ApiResponse> sendTeamMessage(@Body C c2);

    @POST("typing.php")
    Call<String> sendTeamTyping(@Query("from") String str, @Query("team_id") String str2, @Query("typing") String str3);

    @GET("typing.php")
    Call<String> sendTyping(@Query("from") String str, @Query("to") String str2, @Query("typing") String str3);

    @POST("fcm.php")
    Call<ApiResponse> testFCMToken(@Query("action") String str, @Query("callsign") String str2);
}
