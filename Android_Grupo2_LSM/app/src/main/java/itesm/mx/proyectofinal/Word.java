package itesm.mx.proyectofinal;

import java.util.List;

import mx.itesm.expandablerecyclerview.models.ExpandableGroup;

public class Word extends ExpandableGroup<Content> {

    private int iconResId;

    public Word(String title, List<Content> items, int iconResId) {
        super(title, items);
        this.iconResId = iconResId;
    }

    public int getIconResId() {
        return iconResId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word = (Word) o;

        return getIconResId() == word.getIconResId();

    }

    @Override
    public int hashCode() {
        return getIconResId();
    }
}

