package com.talkingparents.utils;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

public class ApiRequests {

    // Define OkHttpClient as a member variable to reuse across requests
    private static OkHttpClient client = new OkHttpClient();

  /*   public static void main(String[] args) throws Exception {
        // Example usage of the reusable method
        String username = "hotwatermusic0+12@gmail.com";
        String password = "1ndyJon35!";  // Replace with actual password
        String baseUrl = "https://tpapi.qa1.talkingparentsdev.com/";  // Replace with the actual API base URL

        // Call the method to get the authToken
        String authToken = getAuthToken(username, password, baseUrl);

        if (authToken != null) {
            // Use the authToken in other requests, like sending a message
            String messageResponse = sendMessage(baseUrl, authToken);
            System.out.println("Message Response: " + messageResponse);
        } else {
            System.out.println("Failed to obtain authToken.");
        }
    }*/

    // Reusable method to send POST request and extract the authToken
    public static String getAuthToken(String username, String password, String baseUrl) throws Exception {
        // Define the URL endpoint
        String url = baseUrl + "web/api/Token/Login";

        // Define the JSON payload
        String json = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password);

        // Create the MediaType for JSON content
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        // Create the RequestBody
        RequestBody body = RequestBody.create(json, JSON);

        // Build the request with headers
        Request request = new Request.Builder()
                .url(url)
                .post(body)  // Use POST method with the body
                .addHeader("Content-Type", "application/json")
                .addHeader("api-version", "1")
                .addHeader("app-version", "5.0.2.202304271")
                .addHeader("AID", "Web")
                .build();

        // Send the request and handle the response
        try (Response response = client.newCall(request).execute()) {
            // Check if the response is successful
            if (response.isSuccessful()) {
                // Print the raw response body to debug
                String responseBody = response.body().string();
                System.out.println("Raw Response Body: " + responseBody);
                System.out.println("Response Code: " + response.code());

                // Parse the response body as a JSON object
                JSONObject jsonResponse = new JSONObject(responseBody);

                // Extract the authToken from the response
                return jsonResponse.getString("authToken");
                
            } else {
                System.out.println("Request failed. Response code: " + response.code());
                return null;
            }
        }

        

    }

    // Send a message using the authToken obtained from login
    public static String sendMessage(String baseUrl, String authToken, String threadID, String message) throws Exception {
        // Define the URL endpoint
        String url = baseUrl + "/mobile/api/Messaging/CreateReply";

         // Create the form data for sending a message (key-value pairs)
        FormBody formBody = new FormBody.Builder()
                .add("ThreadID", threadID)
                .add("Message", message)
                .build();

        // Build the request with headers
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)  // Use POST method with the body
                .addHeader("Content-Type", "application/json")
                .addHeader("api-version", "2")
                .addHeader("app-version", "")
                .addHeader("Authorization", "Bearer " + authToken)  // Use the authToken in Authorization header
                .build();

        // Send the request and handle the response
        try (Response response = client.newCall(request).execute()) {
            // Check if the response is successful
            if (response.isSuccessful()) {
                // Print the raw response body to debug
                String responseBody = response.body().string();
                System.out.println("Raw Response Body: " + responseBody);
                System.out.println("Response Code: " + response.code());

                // Parse the response body as a JSON object
                JSONObject jsonResponse = new JSONObject(responseBody);

                // You can return any specific data from the response as needed
                return jsonResponse.toString();
            } else {
                System.out.println("Request failed. Response code: " + response.code());
                return null;
            }
        }
    }
}
