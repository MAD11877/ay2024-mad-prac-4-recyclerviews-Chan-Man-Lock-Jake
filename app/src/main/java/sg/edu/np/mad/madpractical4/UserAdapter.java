package sg.edu.np.mad.madpractical4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> data;
    private String TAG = "UserAdapter.Java";
    private Context context;

    public UserAdapter (ArrayList<User> input, Context context) {
        data = input;
        this.context = context;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.custom_activity_list,parent,false);
        return new UserViewHolder(item);
    }

    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = data.get(position);
        holder.userName.setText(user.name);
        holder.userDescription.setText(user.description);
        if (user.name.substring(user.name.length()-1).equals("7")) {
            holder.addImage.setVisibility(View.VISIBLE);
        }
        else holder.addImage.setVisibility(View.GONE);

        holder.userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Profile")
                        .setMessage(user.name)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent toMainActivity = new Intent(v.getContext(), MainActivity.class);
                                toMainActivity.putExtra("userData", user);
                                Log.d(TAG,user.name.toString());
                                v.getContext().startActivity(toMainActivity);
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create();
                builder.show();
            }
        });
    }

    public int getItemCount() {
        return data.size();
    }
}
