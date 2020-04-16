package in.tvac.akshayejh.photoblog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class dashboard extends AppCompatActivity {
    private Button btn_academics;
    private Button btn_others;
    private Button btn_community;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btn_academics=findViewById(R.id.btn_academics);
        btn_others=findViewById(R.id.btn_others);
        btn_community=findViewById(R.id.btn_community);
        mAuth = FirebaseAuth.getInstance();

        btn_academics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,AcademicActivity.class);
                startActivity(intent);

            }
        });

        btn_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(dashboard.this,MainActivity.class);
                startActivity(in);

            }
        });
        btn_community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_logout_btn:
                logOut();
                return true;

            case R.id.action_settings_btn:

                Intent settingsIntent = new Intent(dashboard.this, SetupActivity.class);
                startActivity(settingsIntent);

                return true;

            case R.id.action_reminder:

                Intent remindIntent = new Intent(dashboard.this, Main2Activity.class);
                startActivity(remindIntent);

            default:
                return false;

        }

    }
    private void logOut() {


        mAuth.signOut();
        sendToLogin();
    }
    private void sendToLogin() {

        Intent loginIntent = new Intent(dashboard.this, LoginActivity.class);
        startActivity(loginIntent);

    }

}
