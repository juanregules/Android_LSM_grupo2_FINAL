package itesm.mx.proyectofinal.expand;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import itesm.mx.proyectofinal.R;
import mx.itesm.expandablerecyclerview.viewholders.ChildViewHolder;

public class ContentViewHolder extends ChildViewHolder {

    private TextView childTextView;
    private VideoView childVideo;

    public ContentViewHolder(View itemView) {
        super(itemView);
        childTextView = (TextView) itemView.findViewById(R.id.list_item_content_name);
        childVideo = (VideoView) itemView.findViewById(R.id.childVideo);
    }

    public void setContentName(String name) {
        //childTextView.setText(name);
        childVideo.setVideoURI(Uri.parse(name));
        childVideo.start();
    }
}
