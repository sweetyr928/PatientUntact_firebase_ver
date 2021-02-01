package Fragment;

import Notification.MyResponse;
import Notification.Sender;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAA_wzV2o8:APA91bG-2kSNeNC18kd4AoB04Vdl1rPNSYiTg0aCnly8h9vOobXPPRd5XU0HC2-Nuxv2NEBmCj-2WeDv7HnEXxDkMY35kBosExObC4uGWTifDZ-qepLpEYXJZ7iH8rxhQKqE2-CKVLq6"
    })

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
