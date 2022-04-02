package com.example.demo.Service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class APICall {

    public String check(String t1) throws IOException, InterruptedException {
        String texts = "text=" + t1 + "&sentnum=5";
        System.out.println("API " + t1);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://textanalysis-text-summarization.p.rapidapi.com/text-summarizer-text"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("x-rapidapi-host", "textanalysis-text-summarization.p.rapidapi.com")
                .header("x-rapidapi-key", "12163d7acbmsh1a12f634be46147p1393d4jsn9c09ac5a27f2")
                .method("POST", HttpRequest.BodyPublishers.ofString(texts))
                .build();
        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        JSONObject j = new JSONObject(response.body());

        JSONArray jr = j.getJSONArray("sentences");
        String string = jr.getString(0);
        System.out.println("jr   " + string);
        return string;
    }
}
