package org.maurange.formation.licpro;

import org.maurange.formation.licpro.rest.*;


import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;


public class ListArretsActivity extends ListActivity implements MenuItem.OnMenuItemClickListener {

    private static String LOG_TAG = "ListArretsActivity";
    private GetListArretTask getListArretTask;
    private GetAttenteTask getAttenteTask;
    private LocationManager locationManager;
    private Location location;
    private int mActivatedItemPosition = AbsListView.INVALID_POSITION;
    private DialogListeAttente dialog;


    /**
     * Création de l'activité et rafraichissement des données
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        update();
    }

    /**
     * Rafraichi la liste des arrêts en fonction de la position
     */
    private void update() {
        getListArretTask = new GetListArretTask(this);

        // On va cherche le gestionaire de localisation
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location == null) {
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }

        if (location != null) {
            getListArretTask.execute(location.getLatitude(), location.getLongitude());
        } else {
            // Testing data
            getListArretTask.execute(47.2271839, -1.569467);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "enregistrement des listeners");
        // TODO
    }

    //arret des updates
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "desenregistrement des listeners");
        //TODO
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        return false;
    }

    /**
     * Gestion du click sur un arrêt
     * @param l la ListView
     * @param v La vue cliqué
     * @param position La position de la vue cliqué
     * @param id L'identifiant de la vue cliquée
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mActivatedItemPosition = position;
        Arret currentArret = (Arret) l.getAdapter().getItem(position);

        // On affiche le Dialog qui permettra de visualiser les temps d'attente
        dialog = new DialogListeAttente(this);
        dialog.show();

        // On va chercher les données
        getAttenteTask = new GetAttenteTask(this, currentArret.getCodeLieu());
        getAttenteTask.execute();
    }

    /**
     * Création du dialog pour afficher les temps d'attente
     * @param attentes
     */
    public void handleTempsAttente(ListAttente attentes) {
        // Lorsque les attentes on été trouvées, on les affiche dans le dialog créé dans la méthode précédente
        dialog.setAdapter(attentes);
    }

    /**
     * Renvois l'arrêt courant (le dernier sur lequel on a cliqué)
     * @return Arret courant
     */
    protected Arret getActivatedItem() {
        if (mActivatedItemPosition != AbsListView.INVALID_POSITION) {
            return (Arret) getListAdapter().getItem(mActivatedItemPosition);
        } else {
            return null;
        }
    }
}
