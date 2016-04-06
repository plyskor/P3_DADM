package com.example.jose.connect3;
import android.os.Bundle;
import android.preference.PreferenceFragment;
public class C3PreferenceFragment extends PreferenceFragment{
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}