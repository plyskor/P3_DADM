package res.layout;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jose.connect3.R;

public class rating extends AppCompatActivity implements rating_fr.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        getFragmentManager().beginTransaction()
                .add(android.R.id.content, rating_fr.newInstance()).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
