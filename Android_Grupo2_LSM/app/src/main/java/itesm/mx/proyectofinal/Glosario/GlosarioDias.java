package itesm.mx.proyectofinal.Glosario;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.expand.ExpandActivity;
import itesm.mx.proyectofinal.expand.WordAdapter;

/**
 * Created by ArturoCantu on 4/19/2018.
 */

public class GlosarioDias extends Fragment {
    TextView text;
    public WordAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.activity_expand, container, false);
    }

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        Context context = getActivity();
        adapter = new WordAdapter(WordDataFactory.makeWords("dias", context));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Button clear = (Button) getActivity().findViewById(R.id.toggle_button);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.toggleGroup(WordDataFactory.makeLeonWord());
            }
        });


    }

    private View.OnClickListener myClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), ExpandActivity.class);
            startActivity(intent);

        }
    };



}
