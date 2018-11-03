package com.example.consultants.week2daily4.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.consultants.week2daily4.R;
import com.example.consultants.week2daily4.model.Animal;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Animal> animalList;

    public RecyclerViewAdapter(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        int itemViewLayout = getItemViewLayout(viewType);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemViewLayout, viewGroup, false);
        return new ViewHolder(view);
    }

    // TODO: 11/1/2018 change layout by weight of animal
    private int getItemViewLayout(int viewType) {
        int itemViewLayout;
        if(viewType == 1)
            itemViewLayout = R.layout.item_row;
        else
            itemViewLayout = R.layout.item_row_heavy;

        return itemViewLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Animal animal = animalList.get(position);

        viewHolder.tvName.setText((animal.getName()));
        viewHolder.tvWeight.setText(animal.getWeight() + " lbs");
        Bitmap imgResult = BitmapFactory.decodeByteArray(animal.getPicture(), 0, animal.getPicture().length);
        viewHolder.ivImage.setImageBitmap(imgResult);
        viewHolder.sound = animal.getSound();
        viewHolder.ivSound.setImageDrawable(context.getResources().getDrawable(R.drawable.sound));
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    @Override
    public int getItemViewType(int position) {

        int weight = Integer.parseInt(animalList.get(position).getWeight());

        if(weight < 400)
            return 1;
        else
            return 2;
    }

    class ViewHolder extends  RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvWeight;
        private ImageView ivImage;
        private ImageView ivSound;
        private int sound;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    MediaPlayer mPlayer = MediaPlayer.create(v.getContext(), sound);
                    mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mPlayer.start();
                }
            });

            tvName = itemView.findViewById(R.id.tvName);
            tvWeight = itemView.findViewById(R.id.tvWeight);
            ivImage = itemView.findViewById(R.id.ivImage);
            ivSound = itemView.findViewById(R.id.ivSound);
        }
    }

}
