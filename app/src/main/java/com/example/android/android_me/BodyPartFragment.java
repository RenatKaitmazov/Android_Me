package com.example.android.android_me;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
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

    FragmentBodyPartBinding binding;
    private List<Integer> imageIds;
    private int currentImageIdIndex;

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
            setImage();
            binding.bodyPartImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    setNextImage();
                }
            });
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

    /*------------------------------------------------------------------------*/
    // Helper Methods
    /*------------------------------------------------------------------------*/

    private void setImage() {
        final Integer imageResId = imageIds.get(currentImageIdIndex);
        binding.bodyPartImageView.setImageResource(imageResId);
    }

    private void setNextImage() {
        currentImageIdIndex = (currentImageIdIndex + 1) % imageIds.size();
        setImage();
    }
}
