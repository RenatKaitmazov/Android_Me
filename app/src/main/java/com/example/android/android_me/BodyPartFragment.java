package com.example.android.android_me;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_me.databinding.FragmentBodyPartBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Renat Kaitmazov
 */

public final class BodyPartFragment extends Fragment {

    /*------------------------------------------------------------------------*/
    // Static
    /*------------------------------------------------------------------------*/

    private static final String ARGUMENT_IMAGES = "ARGUMENT_IMAGES";

    /*------------------------------------------------------------------------*/
    // Fields
    /*------------------------------------------------------------------------*/

    private FragmentBodyPartBinding binding;
    private List<Integer> imageIds;
    private int currentImageId;

    /*------------------------------------------------------------------------*/
    // Constructors
    /*------------------------------------------------------------------------*/

    public BodyPartFragment() {
    }

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        final Bundle args = getArguments();
        if (args != null) {
            imageIds = args.getIntegerArrayList(ARGUMENT_IMAGES);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_body_part, container, false);
        if (imageIds != null) {
            @DrawableRes
            final Integer imageResId = imageIds.get(0);
            binding.bodyPartImageView.setImageResource(imageResId);
        }
        return binding.getRoot();
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    public static BodyPartFragment newInstance(ArrayList<Integer> imageIds) {
        final Bundle args = new Bundle(1);
        args.putIntegerArrayList(ARGUMENT_IMAGES, imageIds);
        final BodyPartFragment fragment = new BodyPartFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
