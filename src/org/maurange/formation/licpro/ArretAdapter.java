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

    // Liste des arrêts gérés
    private List<Arret> mListArret;

    private LayoutInflater inflater;

    /**
     * Créer l'adapter
     *
     * @param p_oContext   Context dans lequel l'adapter sera utilisé
     * @param p_oListArret Liste des arrêts à gérer
     */
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

    /**
     * Créé la vue correspondant à un arrêt
     *
     * @param p_iPosition    Position dans la liste
     * @param p_oConvertView Vue à "recycler"
     * @param p_oParentView  Vue parente, non utilisée ici
     * @return La vue créé représentant l'arrêt
     */
    @Override
    public View getView(int p_iPosition, View p_oConvertView, ViewGroup p_oParentView) {

        if (p_oConvertView == null) {
            p_oConvertView = inflater.inflate(R.layout.arret_item, null);
        }
        Arret mArret = this.getItem(p_iPosition);

        // Attribue les valeurs de l'arrêt aux différentes vues
        ((TextView) p_oConvertView.findViewById(R.id.arret_item_nom)).setText(mArret.getLibelle());
        ((TextView) p_oConvertView.findViewById(R.id.arret_item_distance)).setText(mArret.getDistance());

        LinearLayout llArrets;
        llArrets = (LinearLayout) p_oConvertView.findViewById(R.id.arret_item_arrets);
        llArrets.removeAllViews();

        ImageView imageLigne;

        // On récupère les images des arrêts
        for (NumLigne ligne : mArret.getLigne()) {
            imageLigne = (ImageView) inflater.inflate(R.layout.ligne_item, null);
            imageLigne.setImageResource((mContext.getResources().getIdentifier("l_" + ligne.getNumLigne(), "drawable", mContext.getPackageName())));
            llArrets.addView(imageLigne);
        }

        return p_oConvertView;
    }

    /**
     * Getter
     *
     * @return La liste d'arrêt
     */
    public List<Arret> getListArret() {
        return mListArret;
    }
}
