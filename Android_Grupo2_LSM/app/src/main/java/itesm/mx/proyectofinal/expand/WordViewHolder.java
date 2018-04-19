package itesm.mx.proyectofinal.expand;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.Word;
import mx.itesm.expandablerecyclerview.models.ExpandableGroup;
import mx.itesm.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class WordViewHolder extends GroupViewHolder {

    private TextView wordName;
    private ImageView arrow;
    private ImageView icon;

    public WordViewHolder(View itemView) {
        super(itemView);
        wordName = (TextView) itemView.findViewById(R.id.list_item_word_name);
        arrow = (ImageView) itemView.findViewById(R.id.list_item_word_arrow);
        icon = (ImageView) itemView.findViewById(R.id.list_item_word_icon);
    }

    public void setWordTitle(ExpandableGroup word) {
        if (word instanceof Word) {
            wordName.setText(word.getTitle());
            icon.setBackgroundResource(((Word) word).getIconResId());
        }
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}
