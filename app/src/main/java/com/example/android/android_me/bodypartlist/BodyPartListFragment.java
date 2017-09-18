package com.example.android.android_me.bodypartlist;

import android.content.Context;
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

import java.util.ArrayList;

/**
 * @author Renat Kaitmazov
 */

public final class BodyPartListFragment extends Fragment {

    /*------------------------------------------------------------------------*/
    // Interfaces
    /*------------------------------------------------------------------------*/

    public interface OnImageClickListener {
        void onImageClicked(int position);
    }

    /*------------------------------------------------------------------------*/
    // Fields
    /*------------------------------------------------------------------------*/

    FragmentBodyPartListBinding binding;
    private OnImageClickListener imageClickListener;

    /*------------------------------------------------------------------------*/
    // Constructors
    /*------------------------------------------------------------------------*/

    public BodyPartListFragment() {
    }

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    @Override
    public final void onAttach(Context context) {
        super.onAttach(context);
        try {
            imageClickListener = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            final String msg = String.format("%s must implement OnImageClickListener", context.toString());
            throw new ClassCastException(msg);
        }
    }

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
        return binding.getRoot();
    }

    @Override
    public final void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(binding.bodyPartRecyclerView);
    }

    /*------------------------------------------------------------------------*/
    // Helper Methods
    /*------------------------------------------------------------------------*/

    private void setUpRecyclerView(@NonNull RecyclerView recyclerView) {
        final ArrayList<Integer> imageIds = ImageResourceProvider.getAll();
        final BodyPartAdapter adapter = new BodyPartAdapter(imageIds, imageClickListener);
        final int spanCount = getGridLayoutSpanCount();
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), spanCount);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private int getGridLayoutSpanCount() {
        final Resources res = getResources();
        final int defaultSpanCount = 2;
        final float availableWidth = getView().getMeasuredWidth();
        final float bodyPartImageSize = res.getDimensionPixelSize(R.dimen.body_part_image_size);
        final int calculatedSpanCount = (int) Math.floor(availableWidth / bodyPartImageSize);
        return Math.max(defaultSpanCount, calculatedSpanCount);
    }
}
