package com.example.android.android_me;

import android.databinding.DataBindingUtil;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public final class MainActivity extends AppCompatActivity {

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);

        final ArrayList<Integer> headsImageResources = ImageResourceProvider.getHeads();
        final ArrayList<Integer> bodiesImageResources = ImageResourceProvider.getBodies();
        final ArrayList<Integer> legsImageResources = ImageResourceProvider.getLegs();

        final BodyPartFragment headFragment = BodyPartFragment.newInstance(headsImageResources);
        final BodyPartFragment bodyFragment = BodyPartFragment.newInstance(bodiesImageResources);
        final BodyPartFragment legsFragment = BodyPartFragment.newInstance(legsImageResources);

        addFragment(R.id.head_container, headFragment);
        addFragment(R.id.body_container, bodyFragment);
        addFragment(R.id.legs_container, legsFragment);
    }

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
