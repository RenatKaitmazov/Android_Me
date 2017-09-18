package com.example.android.android_me;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.bodypartlist.BodyPartListFragment;

import java.util.ArrayList;

public final class MainActivity extends AppCompatActivity
        implements BodyPartListFragment.OnImageClickListener {

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
    // BodyPartListFragment.OnImageClickListener implementation
    /*------------------------------------------------------------------------*/

    @Override
    public final void onImageClicked(int position) {
        final int size = 12;
        final int index = position % size;
        final int divider = position / size;
        final int containerId = getContainerId(divider);
        final BodyPartFragment fragment = getFragmentByContainerId(containerId);
        replaceFragment(containerId, fragment);
        fragment.setImageAt(index);
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

    private void replaceFragment(@IdRes int fragmentContainerId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(fragmentContainerId, fragment)
                .commitNow();
    }

    @IdRes
    @SuppressLint("DefaultLocale")
    private int getContainerId(int divider) {
        switch (divider) {
            case 0: return R.id.head_container;
            case 1: return R.id.body_container;
            case 2: return R.id.legs_container;
            default:
                final String msg = String.format("Unknown divider: %d", divider);
                throw new IllegalArgumentException(msg);
        }
    }

    @SuppressLint("DefaultLocale")
    private BodyPartFragment getFragmentByContainerId(@IdRes int containerId) {
        switch (containerId) {
            case R.id.head_container:
                return BodyPartFragment.newInstance(ImageResourceProvider.getHeads());
            case R.id.body_container:
                return BodyPartFragment.newInstance(ImageResourceProvider.getBodies());
            case R.id.legs_container:
                return BodyPartFragment.newInstance(ImageResourceProvider.getLegs());
            default:
                final String msg = String.format("Unknown fragment container id: %d", containerId);
                throw new IllegalArgumentException(msg);
        }
    }
}
