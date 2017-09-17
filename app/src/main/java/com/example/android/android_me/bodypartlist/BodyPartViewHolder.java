package com.example.android.android_me.bodypartlist;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;

import com.example.android.android_me.databinding.ItemBodyPartBinding;

/**
 * @author Renat Kaitmazov
 */

public final class BodyPartViewHolder extends RecyclerView.ViewHolder {

    /*------------------------------------------------------------------------*/
    // Fields
    /*------------------------------------------------------------------------*/

    private final ItemBodyPartBinding binding;

    @DrawableRes
    private int imageResId;

    /*------------------------------------------------------------------------*/
    // Constructors
    /*------------------------------------------------------------------------*/

    public BodyPartViewHolder(ItemBodyPartBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    public final void bind(@DrawableRes int imageResId) {
        this.imageResId = imageResId;
        binding.bodyPartImageView.setImageResource(imageResId);
    }
}
