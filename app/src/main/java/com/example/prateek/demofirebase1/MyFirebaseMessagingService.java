package com.example.prateek.demofirebase1;

/**
 * Created by prateek on 20/7/17.
 */

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsg";

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // [START_EXCLUDE]
        // There are two types of messages data messages and notification messages. Data messages are handled
        // here in onMessageReceived whether the app is in the foreground or background. Data messages are the type
        // traditionally used with GCM. Notification messages are only received here in onMessageReceived when the app
        // is in the foreground. When the app is in the background an automatically generated notification is displayed.
        // When the user taps on the notification they are returned to the app. Messages containing both notification
        // and data payloads are treated as notification messages. The Firebase console always sends notification
        // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
        // [END_EXCLUDE]


        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.e(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.e(TAG, "Message notification payload: " + remoteMessage.getNotification().getBody());
            String data = remoteMessage.getNotification().getBody();
            try {
                JSONObject jsonObject = new JSONObject(data).getJSONObject("data").getJSONObject("notification");

                Intent intent = new Intent("com.home.notification.action");
                intent.putExtra("DATA", jsonObject.toString());
                sendBroadcast(intent);

                boolean showNotification = true;
                try {
                    showNotification = jsonObject.optBoolean("update", false)?false:true;
                    if(jsonObject.optBoolean("update", false)){
//                        jsonObject = jsonObject.getJSONObject(Constant.DATA);
//                        Prefs.setStringValueToPreferences(getApplicationContext(), Constant.PROFILE_DATA_PREF, jsonObject.toString());
                    }
                }catch (Exception e){

                }
                if(showNotification){
//                    Prefs.setIntValueToPreferences(getApplicationContext(), Constant.NOTIFICATION_COUNT_PREF, Prefs.getIntValueFromPreferences(getApplicationContext(),Constant.NOTIFICATION_COUNT_PREF) + 1);
                    Log.e(TAG, "will show data payload: ");
//                    sendNotification(data, jsonObject.getString("message"));
                }
            } catch (Exception e) {

            }

        }

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.e(TAG, "Message data payload: " + remoteMessage.getData());
            String data = remoteMessage.getData().toString();
            try {
                JSONObject jsonObject = new JSONObject(data).getJSONObject("notification");
                Intent intent = new Intent("com.home.notification.action");
                intent.putExtra("DATA", jsonObject.toString());
                sendBroadcast(intent);

                boolean showNotification = true;
                try {
                    showNotification = jsonObject.optBoolean("update", false)?false:true;
                    if(jsonObject.optBoolean("update", false)){
//                        jsonObject = jsonObject.getJSONObject(Constant.DATA);
//                        Prefs.setStringValueToPreferences(getApplicationContext(), Constant.PROFILE_DATA_PREF, jsonObject.toString());
                    }
                }catch (Exception e){

                }
                if(showNotification){
//                    Prefs.setIntValueToPreferences(getApplicationContext(), Constant.NOTIFICATION_COUNT_PREF, Prefs.getIntValueFromPreferences(getApplicationContext(),Constant.NOTIFICATION_COUNT_PREF) + 1);
                    Log.e(TAG, "will show data payload: ");
//                    sendNotification(data, jsonObject.getString("message"));
                }
            } catch (Exception e) {

            }

        }
    }
    // [END receive_message]

    /**
     * Create and showController a simple notification containing the received FCM message.
     *
     *
     */
    /*private void sendNotification(String data, String title) {
        Intent intent = new Intent(this, NotificationActivity.class);

        intent.putExtra("TITLE", title);
        intent.putExtra("MESSAGE", data);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 10 *//* Request code *//*, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_noti_logo).setTicker(getString(R.string.app_name))
                .setContentTitle(getString(R.string.app_name))
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentText(title)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(Constant.NOTIFICATION_ID *//* ID of notification *//*, notificationBuilder.build());

*//*        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int smallIconViewId = getResources().getIdentifier("right_icon", "id", android.R.class.getPackage().getName());

            if (smallIconViewId != 0) {
                if (notif.contentIntent != null)
                    notif.contentView.setViewVisibility(smallIconViewId, View.INVISIBLE);

                if (notif.headsUpContentView != null)
                    notif.headsUpContentView.setViewVisibility(smallIconViewId, View.INVISIBLE);

                if (notif.bigContentView != null)
                    notif.bigContentView.setViewVisibility(smallIconViewId, View.INVISIBLE);
            }
        }*//*
    }*/
}

