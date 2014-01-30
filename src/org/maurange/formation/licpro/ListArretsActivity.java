package org.maurange.formation.licpro;

import java.util.ArrayList;

import org.maurange.formation.licpro.rest.Arret;
import org.maurange.formation.licpro.rest.ArretRestMethod;
import org.maurange.formation.licpro.rest.ListArret;


import android.app.ListActivity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;



public class ListArretsActivity extends ListActivity {
	private static String LOG_TAG="ListArretsActivity";
	
			
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArretAdapter arretAdapter = new ArretAdapter(this, new ArrayList<Arret>());
        setListAdapter(arretAdapter);

        //TODO
       
    }
    

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(LOG_TAG, "enregistrement des listeners");
		//TODO
	}
	
	//arret des updates
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(LOG_TAG, "desenregistrement des listeners");
		//TODO
	} 
    
}
