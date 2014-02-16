package org.maurange.formation.licpro;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.maurange.formation.licpro.rest.ListAttente;

/**
 * Dialog qui affiche la liste d'attentes
 * Created by Fx on 16/02/14.
 */
public class DialogListeAttente extends Dialog {

    private Context mContext;
    private ListView lvAttente;

    /**
     * Création du dialog
     *
     * @param context
     */
    public DialogListeAttente(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title_attentes);
        setContentView(R.layout.list_attentes);
        lvAttente = (ListView) findViewById(R.id.listeView_attente);
    }

    /**
     * Affiche les donnée. Tant que cette méthode n'est pas appellée, une barre de chargement indique que l'on cherche les données
     *
     * @param attentes
     */
    public void setAdapter(ListAttente attentes) {
        findViewById(R.id.body).setVisibility(View.GONE);
        lvAttente.setVisibility(View.VISIBLE);
        AttenteAdapter attenteAdapter = new AttenteAdapter(mContext, attentes);
        lvAttente.setAdapter(attenteAdapter);
    }
}
