package com.example.android.android_me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public final class MainActivity extends AppCompatActivity {

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
