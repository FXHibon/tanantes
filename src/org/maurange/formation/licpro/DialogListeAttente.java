package org.maurange.formation.licpro;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import org.maurange.formation.licpro.rest.ListAttente;

/**
 * Created by Fx on 16/02/14.
 */
public class DialogListeAttente extends Dialog {

    private ListAttente attentes;
    private Context mContext;


    public DialogListeAttente(Context context, ListAttente listAttente) {
        super(context);
        this.attentes = listAttente;
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.title_attentes);

        setContentView(R.layout.list_attentes);
        ListView lvAttente = (ListView) findViewById(R.id.listeView_attente);
        AttenteAdapter attenteAdapter = new AttenteAdapter(mContext, attentes);
        lvAttente.setAdapter(attenteAdapter);
    }
}
