package com.example.android.android_me.bodypartlist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.android_me.R;
import com.example.android.android_me.databinding.ItemBodyPartBinding;

import java.util.ArrayList;

/**
 * @author Renat Kaitmazov
 */

public final class BodyPartAdapter extends RecyclerView.Adapter<BodyPartViewHolder> {

    /*------------------------------------------------------------------------*/
    // Fields
    /*------------------------------------------------------------------------*/

    private final ArrayList<Integer> imageIds;

    /*------------------------------------------------------------------------*/
    // Constructors
    /*------------------------------------------------------------------------*/

    public BodyPartAdapter(@NonNull ArrayList<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    /*------------------------------------------------------------------------*/
    // RecyclerView.Adapter implementation
    /*------------------------------------------------------------------------*/

    @Override
    public final int getItemCount() {
        return imageIds.size();
    }

    @Override
    public final BodyPartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        final LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final ItemBodyPartBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.item_body_part,
                parent,
                false
        );
        return new BodyPartViewHolder(binding);
    }

    @Override
    public final void onBindViewHolder(BodyPartViewHolder holder, int position) {
        final Integer imageResId = imageIds.get(position);
        holder.bind(imageResId);
    }
}
