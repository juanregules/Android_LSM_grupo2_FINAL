package itesm.mx.proyectofinal.Glosario;

/**
 * Created by 59159 on 18/04/2018.
 */

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Content implements Parcelable {

    public static final Creator<Content> CREATOR = new Creator<Content>() {
        @Override
        public Content createFromParcel(Parcel in) {
            return new Content(in);
        }

        @Override
        public Content[] newArray(int size) {
            return new Content[size];
        }
    };
    private String name;
    private boolean isFavorite;
    private Drawable drawable;

    public Content(String name, boolean isFavorite) {
        this.drawable = null;
        this.name = name;
        this.isFavorite = isFavorite;
    }

    public Content(String name, Drawable drawable, boolean isFavorite) {
        this.name = "";
        this.drawable = drawable;
        this.isFavorite = isFavorite;
    }

    protected Content(Parcel in) {
        name = in.readString();
    }

    public String getName() {
        return name;
    }
    public Drawable getDrawable() {
        return drawable;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Content)) return false;

        Content content = (Content) o;

        if (isFavorite() != content.isFavorite()) return false;
        return getName() != null ? getName().equals(content.getName()) : content.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (isFavorite() ? 1 : 0);
        return result;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}

