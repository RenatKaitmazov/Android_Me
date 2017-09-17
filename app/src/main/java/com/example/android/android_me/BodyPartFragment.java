package com.example.android.android_me;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_me.databinding.FragmentBodyPartBinding;

/**
 * @author Renat Kaitmazov
 */

public final class BodyPartFragment extends Fragment {

    /*------------------------------------------------------------------------*/
    // Fields
    /*------------------------------------------------------------------------*/

    private FragmentBodyPartBinding binding;

    /*------------------------------------------------------------------------*/
    // Constructors
    /*------------------------------------------------------------------------*/

    public BodyPartFragment() {
    }

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_body_part, container, false);
        setStartingImage();
        return binding.getRoot();
    }

    /*------------------------------------------------------------------------*/
    // Helper Methods
    /*------------------------------------------------------------------------*/

    // Fake image for the image view just to observe that the fragment is there.
    private void setStartingImage() {
        final int greenColor = 0x00FF00;
        final Drawable greenColorDrawable = new ColorDrawable(greenColor);
        binding.bodyPartImageView.setImageDrawable(greenColorDrawable);
    }
}
