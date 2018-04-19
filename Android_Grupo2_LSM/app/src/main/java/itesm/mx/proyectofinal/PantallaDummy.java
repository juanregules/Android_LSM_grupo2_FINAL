package itesm.mx.proyectofinal;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Martin RB on 27/03/2018.
 */

public class PantallaDummy extends Fragment implements View.OnClickListener {


    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.layout_juegos, container, false);


    }

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        //text = getActivity().findViewById(R.id.texttext);
        //text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }


}
