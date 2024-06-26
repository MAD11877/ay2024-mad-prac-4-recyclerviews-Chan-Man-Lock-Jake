package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.textView02);
        TextView tvDescription = findViewById(R.id.textView03);
        Button btnFollow = findViewById(R.id.button01);
        Button btnMessage = findViewById(R.id.button02);

        // Set the TextViews with the User's name, description and default button message
        User user = getIntent().getSerializableExtra("userData", User.class);
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        if (user.followed == true){
            btnFollow.setText("Followed");
        }
        else btnFollow.setText("Follow");

        btnFollow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (btnFollow.getText() == "Follow"){
                    btnFollow.setText("Unfollow");
                    user.followed = true;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                } else if (btnFollow.getText() == "Unfollow") {
                    btnFollow.setText("Follow");
                    user.followed = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ToMessageGroup = new Intent(MainActivity.this, MessageGroup.class);
                MainActivity.this.startActivity(ToMessageGroup);
            }
        });
    }
}