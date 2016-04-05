package res.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;

import com.example.jose.connect3.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void startLogin(View view){
        Intent intent= new Intent("android.intent.action.C3.LOGIN");
        startActivity(intent);
    }
    public void startRatings(View view){
        Intent intent= new Intent("android.intent.action.C3.RATINGS");
        startActivity(intent);
    }
    public void startTopTen(View view){
        Intent intent= new Intent("android.intent.action.C3.TOPTEN");
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
}
