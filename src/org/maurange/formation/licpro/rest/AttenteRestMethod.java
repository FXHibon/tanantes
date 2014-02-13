package org.maurange.formation.licpro.rest;

import java.util.ArrayList;
import java.util.List;

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

/**
 * Created by François-Xavier on 13/02/14.
 */
public class AttenteRestMethod {
    private static String LOG_TAG = "AttenteRestMethod";
    Context mContext = null;

    public AttenteRestMethod(Context context) {
        mContext = context.getApplicationContext();
    }


    public ListAttente getAttenteRest(String codeLieu) {

        // The URL for making the GET request
        final String url = mContext.getString(R.string.temps_attente_arret_rest_url);

        Log.d(LOG_TAG, "Invoke url " + url + " with params : " + codeLieu);

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
        ListAttente attentes = new ListAttente();
        try {
            ResponseEntity<ListAttente> responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, requestEntity, ListAttente.class, codeLieu);

            Log.i(LOG_TAG, url);

            Log.d(LOG_TAG, "nb arrets: " + responseEntity.getBody().size());
            attentes.addAll(responseEntity.getBody());
        } catch (RestClientException e) {
            Log.e(LOG_TAG, "RestException dans le chargement des données serveur", e);
        }

        return attentes;
    }

}
