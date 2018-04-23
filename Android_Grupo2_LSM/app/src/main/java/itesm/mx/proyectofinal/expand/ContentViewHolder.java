package itesm.mx.proyectofinal.expand;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import itesm.mx.proyectofinal.R;
import mx.itesm.expandablerecyclerview.viewholders.ChildViewHolder;

public class ContentViewHolder extends ChildViewHolder {

    private TextView childTextView;
    private VideoView childVideo;
    private ImageView childImage;

    public ContentViewHolder(View itemView) {
        super(itemView);
        childVideo = (VideoView) itemView.findViewById(R.id.childVideo);
        childImage = (ImageView) itemView.findViewById(R.id.childImage);
    }

    public void setContentName(String name) {
        //childTextView.setText(name);
        if (name.length() > 10) {
            childVideo.setVisibility(View.VISIBLE);
            childImage.setVisibility(View.INVISIBLE);
            childVideo.setVideoURI(Uri.parse(name));
        }
        else {
            childImage.setVisibility(View.VISIBLE);
            childVideo.setVisibility(View.INVISIBLE);
            childImage.setImageResource(R.drawable.amin);
        }
        childVideo.start();
    }
}
