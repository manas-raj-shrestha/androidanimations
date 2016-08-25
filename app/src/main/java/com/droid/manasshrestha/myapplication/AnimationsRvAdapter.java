package com.droid.manasshrestha.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AnimationsRvAdapter extends RecyclerView.Adapter<AnimationsRvAdapter.ViewHolder> {
    Context context;
    String[] animations;
    AnimationViewChangeListener animationViewChangeListener;

    public AnimationsRvAdapter(Context context,String[] data) {
        this.context = context;
        animationViewChangeListener = (AnimationViewChangeListener) context;
        this.animations = data;
    }

    @Override
    public AnimationsRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimationsRvAdapter.ViewHolder holder, int position) {
        holder.textView.setText(animations[position]);
        holder.textView.setTextColor(Color.WHITE);
        holder.textView.setTextSize(24);
    }

    @Override
    public int getItemCount() {
        return animations.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(android.R.id.text1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animationViewChangeListener.onAnimationChanged(getPosition());
                }
            });
        }
    }
}
