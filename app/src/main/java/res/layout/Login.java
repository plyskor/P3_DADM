package res.layout;
import com.example.jose.connect3.C3Preference;
import android.app.Activity;
import android.content.Intent;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;
import com.example.jose.connect3.DatabaseAdapter;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import com.example.jose.connect3.R;


import static android.Manifest.permission.READ_CONTACTS;


public class Login extends Activity implements OnClickListener {


    private static final int REQUEST_READ_CONTACTS = 0;
    private DatabaseAdapter db;
    private EditText usernameEditText;
    private EditText passwordEditText;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
}