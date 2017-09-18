package com.example.android.android_me;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
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
    public final View onCreateView(LayoutInflater inflater,
                                   @Nullable ViewGroup container,
                                   @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_body_part, container, false);
        if (imageIds != null) {
            setImage();
            binding.bodyPartImageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return handleTouchEvent(view, motionEvent);
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

    private void setPreviousImage() {
        final int size = imageIds.size();
        currentImageIdIndex = ((currentImageIdIndex - 1) + size) % size;
        setImage();
    }

    private boolean handleTouchEvent(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    triggerCircularRevealEffect(view);
                }
                return true;
            case MotionEvent.ACTION_UP:
                final float x = event.getX();
                final boolean leftPartTouched = (view.getWidth() >> 1) <= x;
                if (leftPartTouched) {
                    setPreviousImage();
                } else {
                    setNextImage();
                }
                return true;
            default:
                return false;
        }
    }

    @SuppressLint("NewApi")
    private void triggerCircularRevealEffect(View view) {
        final int centerX = view.getMeasuredWidth() >> 1;
        final int centerY = view.getMeasuredHeight() >> 1;
        final int radius = (int) Math.hypot(centerX, centerY);
        final Animator circularReveal = ViewAnimationUtils.createCircularReveal(view,
                centerX,
                centerY,
                0,
                radius
        );
        circularReveal.start();
    }
}
