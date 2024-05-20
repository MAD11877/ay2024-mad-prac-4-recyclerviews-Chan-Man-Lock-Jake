package sg.edu.np.mad.madpractical4;

import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView userName, userDescription;
    ImageView addImage, userProfile;
    public UserViewHolder(View itemView) {
        super(itemView);
        userProfile = itemView.findViewById(R.id.imageView01);
        userName = itemView.findViewById(R.id.textView01);
        userDescription = itemView.findViewById(R.id.textView02);
        addImage = itemView.findViewById(R.id.imageView02);
    }
}
