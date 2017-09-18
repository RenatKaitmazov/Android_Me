package com.example.android.android_me.bodypartlist;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.android_me.databinding.ItemBodyPartBinding;

/**
 * @author Renat Kaitmazov
 */

public final class BodyPartViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    /*------------------------------------------------------------------------*/
    // Fields
    /*------------------------------------------------------------------------*/

    private final ItemBodyPartBinding binding;
    private final BodyPartListFragment.OnImageClickListener callback;

    @DrawableRes
    private int imageResId;

    /*------------------------------------------------------------------------*/
    // Constructors
    /*------------------------------------------------------------------------*/

    public BodyPartViewHolder(ItemBodyPartBinding binding,
                              @NonNull BodyPartListFragment.OnImageClickListener callback) {
        super(binding.getRoot());
        this.binding = binding;
        this.callback = callback;
        binding.bodyPartImageView.setOnClickListener(this);
    }

    /*------------------------------------------------------------------------*/
    // View.OnClickListener implementation
    /*------------------------------------------------------------------------*/

    @Override
    public final void onClick(View view) {
        callback.onImageClicked(getAdapterPosition());
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    public final void bind(@DrawableRes int imageResId) {
        this.imageResId = imageResId;
        binding.bodyPartImageView.setImageResource(imageResId);
    }
}
