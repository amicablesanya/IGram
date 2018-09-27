package com.example.abcplusd.igram.activity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.abcplusd.igram.R;
import com.example.abcplusd.igram.utils.CircleTransformation;
import com.squareup.picasso.Picasso;

import butterknife.BindDimen;
import butterknife.BindString;
import butterknife.BindView;

public class BaseDrawerActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
      @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

     @BindView(R.id.vNavigation)
    NavigationView vNavigation;
        @BindDimen(R.dimen.global_menu_avatar_size)
    int avatarSize;
    @BindString(R.string.user_profile_photo)
    String profilePhoto;


    private ImageView ivMenuUserProfilePhoto;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentViewWithoutInject(R.layout.activity_drawers);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.flContentRoot);
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
//        vNavigation = (NavigationView) findViewById(R.id.vNavigation);
        LayoutInflater.from(this).inflate(layoutResID, viewGroup, true);
        bindViews();
        setupHeader();
    }

//    private void draw(){
////        drawerLayout.draw(Canvas  );
//    }
    @Override
    protected void setupToolbar() {
        super.setupToolbar();
        if (getToolbar() != null) {
            getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            });
        }
    }

    private void setupHeader() {
        View headerView = vNavigation.getHeaderView(0);
        ivMenuUserProfilePhoto = (ImageView) headerView.findViewById(R.id.ivMenuUserProfilePhoto);
        headerView.findViewById(R.id.vGlobalMenuHeader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGlobalMenuHeaderClick(v);
            }
        });

        Picasso.with(this)
                .load(profilePhoto)
                .placeholder(R.drawable.img_circle_placeholder)
                .resize(avatarSize, avatarSize)
                .centerCrop()
                .transform(new CircleTransformation())
                .into(ivMenuUserProfilePhoto);
    }

    public void onGlobalMenuHeaderClick(final View v) {
        drawerLayout.closeDrawer(Gravity.LEFT);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int[] startingLocation = new int[2];
                v.getLocationOnScreen(startingLocation);
                startingLocation[0] += v.getWidth() / 2;
                UserProfileActivity.startUserProfileFromLocation(startingLocation, BaseDrawerActivity.this);
                overridePendingTransition(0, 0);
            }
        }, 200);
    }
    public void menu_feed(MenuItem item){

        Intent i = new Intent();
        i.setClass(this,PublishActivity.class);
        startActivity(i);
    }
//    public void menu_direct(MenuItem item){
//        Intent i = new Intent();
//        i.setClass(this,PublishActivity.class);
//        startActivity(i);
//
//    }
//    public void menu_news(MenuItem item){
//        Intent i = new Intent();
//        i.setClass(this,MainActivity.class);
//        startActivity(i);
//    }
//    public void menu_popular(MenuItem item){
//        Intent i = new Intent();
//        i.setClass(this,PublishActivity.class);
//        startActivity(i);
//    }
//    public void menu_photo_you_liked(MenuItem item){
//        Intent i = new Intent();
//        i.setClass(this,PublishActivity.class);
//        startActivity(i);
//    }
//    public void menu_photos_nearby(MenuItem item){
//        Intent i = new Intent();
//        i.setClass(this,PublishActivity.class);
//        startActivity(i);
//    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_feed: {
                Intent i = new Intent(BaseDrawerActivity.this, MainActivity.class);
                startActivity(i);
                return true;

            }
            case R.id.menu_direct: {
                break;

            }
            case R.id.menu_news: {
                break;

            }
            case R.id.menu_popular: {
                break;

            }
            case R.id.menu_photo_you_liked: {
                break;

            }
            case R.id.menu_photos_nearby: {
                break;

            }
            case R.id.menu_settings: {
                break;

            }
            case R.id.menu_about: {
                break;

            }
        }

            return false;
        }
    }




