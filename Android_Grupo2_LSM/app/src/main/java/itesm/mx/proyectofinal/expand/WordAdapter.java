package itesm.mx.proyectofinal.expand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import itesm.mx.proyectofinal.Content;
import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.Word;
import mx.itesm.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import mx.itesm.expandablerecyclerview.models.ExpandableGroup;


public class WordAdapter extends ExpandableRecyclerViewAdapter<WordViewHolder, ContentViewHolder> {

    public WordAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public WordViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_word, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public ContentViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_content, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ContentViewHolder holder, int flatPosition,
                                      ExpandableGroup group, int childIndex) {

        final Content artist = ((Word) group).getItems().get(childIndex);
        holder.setContentName(artist.getName());
    }

    @Override
    public void onBindGroupViewHolder(WordViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {

        holder.setWordTitle(group);
    }
}
