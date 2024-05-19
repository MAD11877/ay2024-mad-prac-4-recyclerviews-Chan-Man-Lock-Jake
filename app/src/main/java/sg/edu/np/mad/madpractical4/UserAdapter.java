package sg.edu.np.mad.madpractical4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> data;

    public UserAdapter (ArrayList<User> input) {
        data = input;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list,parent,false);
        return new UserViewHolder(item);
    }

    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = data.get(position);
        holder.userName.setText(user.name);
        holder.userDescription.setText(user.description);
    }

    public int getItemCount() {
        return data.size();
    }
}
