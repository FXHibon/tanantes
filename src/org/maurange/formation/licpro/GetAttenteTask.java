package org.maurange.formation.licpro;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.maurange.formation.licpro.rest.Attente;
import org.maurange.formation.licpro.rest.AttenteRestMethod;
import org.maurange.formation.licpro.rest.ListAttente;

/**
 * Created by François-Xavier on 13/02/14.
 */
public class GetAttenteTask extends AsyncTask<Object, Void, ListAttente> {

    private String mCodeLieu;
    private Context mContext;
    private AttenteRestMethod attenteRestMethod;
    private String LOG_TAG = "GetAttenteTask";

    public GetAttenteTask(Context context, String codeLieu) {
        super();
        this.mCodeLieu = codeLieu;
        this.mContext = context;
        attenteRestMethod = new AttenteRestMethod(mContext);
    }

    @Override
    protected ListAttente doInBackground(Object... objects) {
        ListAttente attentes = attenteRestMethod.getAttenteRest(mCodeLieu);
        return attentes;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(ListAttente attentes) {
        super.onPostExecute(attentes);
        ((ListArretsActivity) mContext).handleTempsAttente(attentes);
    }
}
