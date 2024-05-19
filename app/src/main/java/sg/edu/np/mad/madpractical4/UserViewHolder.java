package sg.edu.np.mad.madpractical4;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView userName, userDescription;
    public UserViewHolder(View itemView) {
        super(itemView);
        userName = itemView.findViewById(R.id.textView01);
        userDescription = itemView.findViewById(R.id.textView02);
    }
}
