package org.maurange.formation.licpro;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.maurange.formation.licpro.rest.ArretRestMethod;
import org.maurange.formation.licpro.rest.ListArret;

/**
 * AsynTask used to get a list of "arret" from tan web services
 * Created by Fx on 02/02/14.
 */
public class GetListArretTask extends AsyncTask<Object, Void, ListArret> {

    private ListArretsActivity activity;
    private ProgressDialog progressDialog;

    public GetListArretTask(ListArretsActivity context) {
        activity = context;
    }

    @Override
    protected ListArret doInBackground(Object... objects) {
        ArretRestMethod rest = new ArretRestMethod(activity);
        ListArret lArret = rest.getArretsRest((Double) objects[0], (Double) objects[1]);
        return lArret;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Chargement des arrêts ...");
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(ListArret aListArret) {
        super.onPostExecute(aListArret);
        activity.setListAdapter(new ArretAdapter(activity, aListArret));
        progressDialog.dismiss();
    }
}
