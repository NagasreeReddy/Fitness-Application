package com.fitnessapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.fitnessapp.R;
import com.fitnessapp.activities.WomensWorkoutDetailsActivity;
import com.fitnessapp.models.WomensWorkoutPojo;

import java.util.List;

public class GuestWomensWorkoutPlanAdapter extends BaseAdapter {
    List<WomensWorkoutPojo> workoutPojos;
    Context cnt;
    String URL="http://getfitt.club/getfit/";


    public GuestWomensWorkoutPlanAdapter(List<WomensWorkoutPojo> womensWorkoutPojos, Context cnt) {
        this.workoutPojos = womensWorkoutPojos;
        this.cnt = cnt;
    }

    @Override
    public int getCount() {
        return workoutPojos.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int pos, View view, ViewGroup viewGroup) {
        LayoutInflater obj1 = (LayoutInflater) cnt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View obj2 = obj1.inflate(R.layout.adapter_guest_women_workout, null);

        ImageView imageview=(ImageView)obj2.findViewById(R.id.imageview);
        Glide.with(cnt).load(URL+workoutPojos.get(pos).getPhoto()).into(imageview);

        TextView tvWorkoutname = (TextView) obj2.findViewById(R.id.tvWorkoutname);
        tvWorkoutname.setText(workoutPojos.get(pos).getWname());


        CardView cvWorkout=(CardView)obj2.findViewById(R.id.cvWorkout);
        cvWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(cnt, WomensWorkoutDetailsActivity.class);
                intent.putExtra("image",workoutPojos.get(pos).getPhoto());
                intent.putExtra("wname",workoutPojos.get(pos).getWname());
                intent.putExtra("desc",workoutPojos.get(pos).getDes());
                cnt.startActivity(intent);

            }
        });


        return obj2;
    }

}