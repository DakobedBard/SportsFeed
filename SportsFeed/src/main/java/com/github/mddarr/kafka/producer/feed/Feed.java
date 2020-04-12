package com.github.mddarr.kafka.producer.feed;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Feed {

    public static void main(String[] args) {

        try {
            URL url = new URL(" https://api.mysportsfeeds.com/v2.1/pull/nba/2016-2017-regular/games");

            String apiKey = "ed262fca-0784-4046-bb97-c008bb:MYSPORTSFEEDS";
            String encodedString = Base64.getEncoder().encodeToString(apiKey.getBytes());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encodedString);
            InputStream content = (InputStream) connection.getInputStream();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(content));
            String line;
            int count = 0;
            if ((line = in.readLine()) != null) {
                String jsonString = line;
                System.out.println(jsonString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
