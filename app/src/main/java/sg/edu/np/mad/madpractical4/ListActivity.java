package sg.edu.np.mad.madpractical4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        /*ImageView ivImage = findViewById(R.id.imageView01);

        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle(R.string.list_title)
                        .setMessage("MADness")
                        .setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Random random = new Random();
                                int randomInt = random.nextInt(99999);

                                Intent toMainActivity = new Intent(ListActivity.this, MainActivity.class);
                                toMainActivity.putExtra("randInt", randomInt);
                                ListActivity.this.startActivity(toMainActivity);
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.create();
                builder.show();
            }
        });*/

        String[] user_name = {
                "John Doe",
                "Erl Emlen",
                "Jade Fesby",
                "Johny Kenwood",
                "Luis Ransom",
                "Kermie Mattack",
                "Heinrick Bruneton",
                "Jermayne Tilson",
                "Juanita Paton",
                "Todd Twinborough",
                "Terrye Janawa",
                "Grannie Colaco",
                "Worden Cartmale",
                "Stanton Keemer",
                "Oswald Buist",
                "Dame Delleschi",
                "Urbanus Dallin",
                "Dina Rodriguez",
                "Troy Moss",
                "Ophelie Harcarse"
        };

        String[] user_description = {
                "MAD Developer",
                "Health Coach IV",
                "Analog Circuit Design manager",
                "Mechanical Systems Engineer",
                "Recruiter",
                "Nuclear Power Engineer",
                "Assistant Professor",
                "Accounting Assistant III",
                "Mechanical Systems Engineer",
                "Sales Associate",
                "Compensation Analyst",
                "Administrative Officer",
                "Payment Adjustment Coordinator",
                "Operator",
                "Senior Financial Analyst",
                "Chief Design Engineer",
                "Media Manager II",
                "Teacher",
                "Occupational Therapist",
                "Administrative Officer"
        };

        boolean[] user_follow = {
                false,
                false,
                true,
                false,
                false,
                true,
                false,
                false,
                true,
                false,
                true,
                true,
                false,
                false,
                true,
                true,
                true,
                true,
                false,
                true
        };

        ArrayList<User> userArrayList = new ArrayList<User>();
        for (int i = 0; i < 20; i++){

            int randomInt = new Random().nextInt(99999);
            String name = "Name" + randomInt;
            randomInt = new Random().nextInt(99999);
            String description = "Description " + randomInt;

            User user = new User(name,description,i+1,user_follow[i]);
            userArrayList.add(user);
        };

        RecyclerView recyclerView = findViewById(R.id.recyclerView01);
        UserAdapter userAdapter = new UserAdapter(userArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);
    }
}