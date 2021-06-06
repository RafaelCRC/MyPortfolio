package com.example.myportifolio.skills;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myportifolio.R;



import java.util.ArrayList;
import java.util.List;


public class SkillsFragment extends Fragment {
    List<com.example.myportifolio.skills.SkillsItem> mdata;
    RecyclerView skills_frame;
    com.example.myportifolio.skills.SkillsAdaptor skillsAdaptor;

    public SkillsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skills, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        skills_frame = view.findViewById(R.id.skills_frame);
        mdata = new ArrayList<>();
        mdata.add(new com.example.myportifolio.skills.SkillsItem(R.drawable.pyicon1, "Python"));
        mdata.add(new com.example.myportifolio.skills.SkillsItem(R.drawable.jupytericon, "Jupyter"));
        mdata.add(new com.example.myportifolio.skills.SkillsItem(R.drawable.javaicon, "Java"));
        mdata.add(new com.example.myportifolio.skills.SkillsItem(R.drawable.htmlicon, "html"));
        mdata.add(new com.example.myportifolio.skills.SkillsItem(R.drawable.cssicon, "css"));
        mdata.add(new com.example.myportifolio.skills.SkillsItem(R.drawable.jsicon, "Javascript"));



        skillsAdaptor = new com.example.myportifolio.skills.SkillsAdaptor(mdata);

        skills_frame.setLayoutManager(new GridLayoutManager(getActivity(),3));
        skills_frame.setAdapter(skillsAdaptor);
    }
}