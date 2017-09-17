package com.example.android.android_me.bodypartlist;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_me.ImageResourceProvider;
import com.example.android.android_me.R;
import com.example.android.android_me.databinding.FragmentBodyPartListBinding;

/**
 * @author Renat Kaitmazov
 */

public final class BodyPartListFragment extends Fragment {

    /*------------------------------------------------------------------------*/
    // Fields
    /*------------------------------------------------------------------------*/

    FragmentBodyPartListBinding binding;

    /*------------------------------------------------------------------------*/
    // Constructors
    /*------------------------------------------------------------------------*/

    public BodyPartListFragment() {
    }

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater,
                                   @Nullable ViewGroup container,
                                   @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_body_part_list,
                container,
                false
        );
        setUpRecyclerView(binding.bodyPartRecyclerView);
        return binding.getRoot();
    }

    /*------------------------------------------------------------------------*/
    // Helper Methods
    /*------------------------------------------------------------------------*/

    private void setUpRecyclerView(@NonNull RecyclerView recyclerView) {
        final BodyPartAdapter adapter = new BodyPartAdapter(ImageResourceProvider.getAll());
        final int spanCount = getGridLayoutSpanCount();
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), spanCount);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private int getGridLayoutSpanCount() {
        final Resources res = getResources();
        final int defaultSpanCount = 2;
        final float screenWidth = res.getDisplayMetrics().widthPixels;
        final float bodyPartImageSize = res.getDimensionPixelSize(R.dimen.body_part_image_size);
        final int calculatedSpanCount = (int) Math.floor(screenWidth / bodyPartImageSize);
        return Math.max(defaultSpanCount, calculatedSpanCount);
    }
}
