package org.maurange.formation.licpro.rest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.maurange.formation.licpro.R;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import android.content.Context;
import android.util.Log;


public class ArretRestMethod {
    private static String LOG_TAG = "ArretRestMethod";
    Context mContext = null;

    public ArretRestMethod(Context context) {
        mContext = context.getApplicationContext();
    }


    public ListArret getArretsRest(double latitude, double longitude) {

        // The URL for making the GET request
        final String url = mContext.getString(R.string.arret_rest_url);

        Log.d(LOG_TAG, "Invoke url " + url + " with params : " + latitude + ", " + longitude);

        // Set the Accept header for "application/json"
        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(acceptableMediaTypes);
        requestHeaders.setAcceptLanguage("fr_FR");

        // Populate the headers in an HttpEntity object to use for the request
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

        // Perform the HTTP GET request
        ListArret arrets = new ListArret();
        try {
            ResponseEntity<ListArret> responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, requestEntity, ListArret.class, "json", latitude, longitude);

            Log.d(LOG_TAG, "nb arrets: " + responseEntity.getBody().size());
            arrets.addAll(responseEntity.getBody());
        } catch (RestClientException e) {
            Log.e(LOG_TAG, "RestException dans le chargement des donn�es serveur", e);
        }

        return arrets;
    }

}
