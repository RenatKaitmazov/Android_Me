package com.example.android.android_me;

import android.databinding.DataBindingUtil;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public final class MainActivity extends AppCompatActivity {

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);

        final BodyPartFragment headFragment = BodyPartFragment.newInstance(null);
        final BodyPartFragment bodyFragment = BodyPartFragment.newInstance(null);
        final BodyPartFragment legsFragment = BodyPartFragment.newInstance(null);

        addFragment(R.id.head_container, headFragment);
        addFragment(R.id.body_container, bodyFragment);
        addFragment(R.id.legs_container, legsFragment);
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    /*------------------------------------------------------------------------*/
    // Helper Methods
    /*------------------------------------------------------------------------*/

    private void addFragment(@IdRes int fragmentContainerId, Fragment fragment) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment currentFragment = fragmentManager.findFragmentById(fragmentContainerId);
        if (currentFragment == null) {
            // The container is empty. Add the specified fragment to it.
            fragmentManager.beginTransaction()
                    .add(fragmentContainerId, fragment)
                    .commitNow();
        }
    }
}
