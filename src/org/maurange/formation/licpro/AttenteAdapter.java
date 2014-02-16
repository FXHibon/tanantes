package org.maurange.formation.licpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.maurange.formation.licpro.rest.Arret;
import org.maurange.formation.licpro.rest.Attente;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Fx on 16/02/14.
 */
public class AttenteAdapter extends BaseAdapter {

    private static String LOG_TAG = "ArretAdapter";
    private Context mContext;
    private List<Attente> mListAttente;
    private LayoutInflater inflater;

    public AttenteAdapter(Context p_oContext, List<Attente> p_oListAttente) {
        super();
        mContext = p_oContext;
        mListAttente = p_oListAttente;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mListAttente.size();
    }

    @Override
    public Attente getItem(int i) {
        return mListAttente.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = inflater.inflate(R.layout.attente_item, null);
        }

        Attente a = getItem(i);

        TextView terminus = (TextView) view.findViewById(R.id.terminus);
        TextView ligne = (TextView) view.findViewById(R.id.ligne);
        TextView tempsAttente = (TextView) view.findViewById(R.id.temps_attente);

        terminus.setText(a.getTerminus());
        ligne.setText(a.getLigne().getNumLigne());
        tempsAttente.setText(a.getTemps());

        return view;
    }
}
