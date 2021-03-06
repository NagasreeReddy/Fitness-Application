package com.fitnessapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.fitnessapp.R;
import com.google.android.material.navigation.NavigationView;

public class  UserDashboardActivity extends AppCompatActivity {
    private ActionBarDrawerToggle t;
    private NavigationView navigation_view;
    private DrawerLayout layout_drawer;
    CardView cdMyProfile,cdworkoutplans,cdTrainers,cdDitePlan,cdMyGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        navigationView();
        cdMyProfile=(CardView)findViewById(R.id.cdMyProfile);
        cdMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserDashboardActivity.this,EditProfileActivity.class);
                startActivity(intent);

            }
        });
        cdworkoutplans=(CardView)findViewById(R.id.cdworkoutplans);
        cdworkoutplans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(UserDashboardActivity.this,WorkoutPlanActivity.class);
                startActivity(intent);

            }
        });
        cdTrainers=(CardView)findViewById(R.id.cdTrainers);
        cdTrainers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserDashboardActivity.this,GetVerifiedTrainersActivity.class);
                startActivity(intent);

            }
        });

        cdDitePlan=(CardView)findViewById(R.id.cdDitePlan);
        cdDitePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserDashboardActivity.this,GetDitePlanActivity.class);
                startActivity(intent);

            }
        });

        cdMyGoal=(CardView)findViewById(R.id.cdMyGoal);
        cdMyGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserDashboardActivity.this,MyGoalActyvity.class);
                startActivity(intent);

            }
        });
    }

    private void navigationView(){
        layout_drawer = (DrawerLayout)findViewById(R.id.layout_drawer);
        t = new ActionBarDrawerToggle(this, layout_drawer,R.string.Open, R.string.Close);
        layout_drawer.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigation_view = (NavigationView)findViewById(R.id.navigation_view);
        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.myprofile:
                        Intent intent=new Intent(getApplicationContext(), EditProfileActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.search_trainer:
                        Intent intent1=new Intent(getApplicationContext(), SearchTrainerActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.view_training_content:
                        Intent view_jobs=new Intent(getApplicationContext(), UserViewTrainingContent.class);
                        startActivity(view_jobs);
                        break;

                    case R.id.my_goals:
                        Intent my_goals=new Intent(getApplicationContext(), ViewMyGoalsActivity.class);
                        startActivity(my_goals);
                        break;


                    case R.id.my_trainer_bookings:
                        Intent bookings=new Intent(getApplicationContext(), UserBookingsActivity.class);
                        startActivity(bookings);
                        break;

                    case R.id.logout:
                        Intent logout=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(logout);
                        finish();
                        break;

                    default:
                        return true;
                }
                layout_drawer.closeDrawer(GravityCompat.START);
                return true;

            }
        });
    }
    @Override
    public void onBackPressed() {
        if (layout_drawer.isDrawerOpen(GravityCompat.START)) {
            layout_drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (layout_drawer.isDrawerOpen(GravityCompat.START)) {
            layout_drawer.closeDrawer(GravityCompat.START);
        } else {
            layout_drawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}