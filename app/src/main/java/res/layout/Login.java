package res.layout;
import android.app.Activity;

import com.example.jose.connect3.C3PreferenceFragment;
import com.example.jose.connect3.DatabaseAdapter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.jose.connect3.R;


public class Login extends AppCompatActivity implements OnClickListener,login_fr.OnFragmentInteractionListener {


    private static final int REQUEST_READ_CONTACTS = 0;
    public static DatabaseAdapter db;
    public static EditText usernameEditText;
    public static EditText passwordEditText;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        getFragmentManager().beginTransaction()
                .add(android.R.id.content, login_fr.newInstance()).commit();
        // Set up the login form.
        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.sign_in_button);
        loginButton.setOnClickListener(this);
        Button newUserButton = (Button) findViewById(R.id.register);
        newUserButton.setOnClickListener(this);


    }

    private void check() {
        /*String username = usernameEditText.getText().toString(); String password = passwordEditText.getText().toString();
        db=new DatabaseAdapter(this);
        db.open();
        boolean in = db.isRegistered(username, password); db.close();
        if (in){
            C3Preference.setPlayerName(Login.this, username); C3Preference.setPlayerPassword(Login.this, password); startActivity(new Intent(this, MainActivity.class)); finish();
        }
        else {
            new AlertDialog.Builder(this) .setTitle(R.string.loginAlertDialogTitle) .setMessage(R.string.loginAlertDialogMessage) .setNeutralButton(R.string.loginAlertDialogNeutralButtonText,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}
                    }).show();
        }*/
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                check();
                break;
            case R.id.register:
                /*startActivity(new Intent(this, Account.class)); */
                break;
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}