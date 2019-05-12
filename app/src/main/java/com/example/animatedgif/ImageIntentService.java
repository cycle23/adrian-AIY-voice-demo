package com.example.animatedgif;

import android.app.IntentService;
import android.content.Intent;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ImageIntentService extends IntentService {
    final static String IMAGE_INFO = "image_info";
    public ImageIntentService() {
        super("Image IntentService");
    }


    
    @Override
    protected void onHandleIntent(Intent intent) {
        String image_category = intent.getStringExtra("intent_cat");

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.43.154:8080";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                sendImageInfoToClient(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    private void sendImageInfoToClient(String msg) {
        Intent intent = new Intent();
        intent.setAction(IMAGE_INFO);
        intent.putExtra("image", msg);
        sendBroadcast(intent);
    }
}
