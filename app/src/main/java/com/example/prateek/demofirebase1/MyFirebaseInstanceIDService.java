package com.example.prateek.demofirebase1;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        // Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
//        sendRegistrationToServer(refreshedToken);
    }
    // [END refresh_token]

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
 /*   private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
        //id - registration id / device id
        try{
            Prefs.setFCMValueToPreferences(getApplicationContext(),Constant.FCM_REGISTRATION_ID_PREF,token);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",token);
            new POSTSeverAsync(getApplicationContext(), Constant.BASE_URL + Constant.FCM_REGISTRATION_API, jsonObject.toString(), Constant.SERVER_REQUEST_CODE_FIRST, new POSTSeverAsync.OnFinishPOSTAsync() {
                @Override
                public void onPOSTFinish(String result, int requestCode, boolean isSuccess) {
                    Log.e("log",result);

                }
            }).execute();
        }catch (Exception e){

        }
    }*/
}
