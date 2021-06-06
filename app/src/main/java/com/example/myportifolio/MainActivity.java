package com.example.myportifolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.bumptech.glide.load.engine.Resource;
import com.example.myportifolio.botmenu.Callback;
import com.example.myportifolio.botmenu.MenuAdapter;
import com.example.myportifolio.botmenu.MenuItem;
import com.example.myportifolio.botmenu.MenuUtil;
import com.example.myportifolio.home.HomeFragment;
import com.example.myportifolio.profile.ProfileFragment;
import com.example.myportifolio.settings.SettingsFragment;
import com.example.myportifolio.skills.SkillsFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView menuRv;
    List<MenuItem> menuItems;
    MenuAdapter adapter;
    int fragmentint;
    String language = "en";
    Switch switchS;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setupBotMenu();

        setHomeFragment();
        if (savedInstanceState != null){
            int temp = savedInstanceState.getInt("fragment");
            onBotMenuClick(temp);
            String templang = savedInstanceState.getString("langsave");
            setLocale(templang);
        }

        //setLocale(language);


    }

    public void setLocale(String lang) {
        language = lang;
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        editor.putString("My_lang",lang);
        editor.apply();
        setSettingsFragment();
    }

    private void setupBotMenu() {

        menuRv = findViewById(R.id.rv_bot_menu);

        // get menu list item  will get data from a static data class
        menuItems = MenuUtil.getMenuList();
        adapter = new MenuAdapter(menuItems,this);
        menuRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL ,false));
        menuRv.setAdapter(adapter);

    }

    void setHomeFragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

    }

    void setSkillsfragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new SkillsFragment()).commit();

    }

    void setProfilefragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProfileFragment()).commit();
    }

    void setSettingsFragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new SettingsFragment()).commit();

    }

    public void mailto(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:rafael.2019107852@unicap.br"));
        startActivity(i);
    }

    public void callto(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:81-996186591"));
        startActivity(i);
    }

    public void linkelink(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rafael-cardoso-4761ba14a/"));
        startActivity(i);
    }

    public void gitlink(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/RafaelCRC"));
        startActivity(i);
    }

    public void instalink(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/rafael_cardoso22/"));
        startActivity(i);
    }

    @Override
    public void onBotMenuClick(int i) {

        switch (menuItems.get(i).getCode()) {

            case MenuUtil.HOME_FRAGMENT_CODE: setHomeFragment();
            break;
            case MenuUtil.SKILLS_FRAGMENT_CODE: setSkillsfragment();
            break;
            case MenuUtil.PROFILE_FRAGMENT_CODE:setProfilefragment();
            break;
            case  MenuUtil.SETTINGS_FRAGMENT_CODE:setSettingsFragment();
            break;
            default: setHomeFragment();
        }

        menuItems.get(fragmentint).setSelected(false);
        menuItems.get(i).setSelected(true);
        fragmentint = i;
        adapter.notifyDataSetChanged();


    }

    @Override
    protected void onSaveInstanceState(@NonNull  Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("fragment",fragmentint);
        outState.putString("langsave", language);



    }



}