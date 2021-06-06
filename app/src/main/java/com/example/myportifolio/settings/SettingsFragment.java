package com.example.myportifolio.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myportifolio.MainActivity;
import com.example.myportifolio.R;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;


public class SettingsFragment extends Fragment {

    TextInputLayout til_lang;
    AutoCompleteTextView act_lang;
    ArrayList<String> arraylist_lang;
    ArrayAdapter<String> arrayadap_lang;
    Switch switchS;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        switchS = getView().findViewById(R.id.switchtheme);
        int nightModeFlags =
                getContext().getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                switchS.setChecked(true);
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                switchS.setChecked(false);
                break;

            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                switchS.setChecked(false);
                break;
        }

        switchS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ((AppCompatActivity)getActivity()).getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    buttonView.setChecked(true);
                    Toast.makeText(getContext(), "Darkmode: ON",
                            Toast.LENGTH_SHORT).show();
                }else{
                    ((AppCompatActivity)getActivity()).getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    buttonView.setChecked(false);
                    Toast.makeText(getContext(), "Darkmode: OFF",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        til_lang = (TextInputLayout) getView().findViewById(R.id.til_texview);
        act_lang = (AutoCompleteTextView) getView().findViewById(R.id.act_textview);
        arraylist_lang = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.linguas)));
        arrayadap_lang = new ArrayAdapter<>(getActivity().getApplicationContext(),R.layout.dropdown_item,arraylist_lang);
        act_lang.setAdapter(arrayadap_lang);
        act_lang.setThreshold(1);

        act_lang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(getContext(), parent.getItemAtPosition(position).toString(),
                                Toast.LENGTH_SHORT).show();
                        ((MainActivity)getActivity()).setLocale("en");
                        break;
                    case 1:
                        Toast.makeText(getContext(), parent.getItemAtPosition(position).toString(),
                                Toast.LENGTH_SHORT).show();
                        ((MainActivity)getActivity()).setLocale("pt");
                        break;
                    case 2:
                        Toast.makeText(getContext(), parent.getItemAtPosition(position).toString(),
                                Toast.LENGTH_SHORT).show();
                        ((MainActivity)getActivity()).setLocale("zh");
                        break;
                    default:
                        Toast.makeText(getContext(), "unknown error at languages",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}