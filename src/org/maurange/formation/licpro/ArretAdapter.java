package org.maurange.formation.licpro;

import java.util.List;

import org.maurange.formation.licpro.rest.Arret;
import org.maurange.formation.licpro.rest.NumLigne;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ArretAdapter extends BaseAdapter {

    private static String LOG_TAG = "ArretAdapter";
    private Context mContext;
    private List<Arret> mListArret;
    private LayoutInflater inflater;

    public ArretAdapter(Context p_oContext, List<Arret> p_oListArret) {
        super();
        mContext = p_oContext;
        mListArret = p_oListArret;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mListArret.size();
    }

    @Override
    public Arret getItem(int position) {
        return mListArret.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int p_iPosition, View p_oConvertView, ViewGroup p_oParentView) {

//		Log.d(LOG_TAG, "getView() - position: " + p_iPosition);

        if (p_oConvertView == null) {
            p_oConvertView = inflater.inflate(R.layout.arret_item, null);
        }
        Arret mArret = this.getItem(p_iPosition);
//		Log.d(LOG_TAG, "getView() - mArret: " + mArret);
//		Log.d(LOG_TAG, "getView() - mArret: " + mArret.getLibelle());
//		Log.d(LOG_TAG, "getView() - mArret: " + mArret.getDistance());

//		Log.d(LOG_TAG, "getView() - uiArretDistance: " + uiArretDistance);

        ((TextView) p_oConvertView.findViewById(R.id.arret_item_nom)).setText(getItem(p_iPosition).getLibelle());
        ((TextView) p_oConvertView.findViewById(R.id.arret_item_distance)).setText(getItem(p_iPosition).getDistance());

        LinearLayout llArrets;
        llArrets = (LinearLayout) p_oConvertView.findViewById(R.id.arret_item_arrets);

        for (NumLigne ligne: getItem(p_iPosition).getLigne()) {
            TextView tvLigne = new TextView(mContext);
            tvLigne.setText(ligne.getNumLigne());
            llArrets.addView(tvLigne);
        }

        //TODO mapper vos vues

        return p_oConvertView;
    }

    public List<Arret> getListArret() {
        return mListArret;
    }
}
