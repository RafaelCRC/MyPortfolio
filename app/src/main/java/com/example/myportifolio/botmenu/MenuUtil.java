package com.example.myportifolio.botmenu;



import com.example.myportifolio.R;

import java.util.ArrayList;
import java.util.List;

public class MenuUtil {

    public static final int HOME_FRAGMENT_CODE = 0;
    public static final int SKILLS_FRAGMENT_CODE = 1;
    public static final int PROFILE_FRAGMENT_CODE = 2;
    public static final int SETTINGS_FRAGMENT_CODE = 3;


    public static List<MenuItem> getMenuList() {
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem(R.drawable.ic_baseline_home_24,HOME_FRAGMENT_CODE,true));
        list.add(new MenuItem(R.drawable.ic_baseline_school_24,SKILLS_FRAGMENT_CODE,false));
        list.add(new MenuItem(R.drawable.ic_baseline_person_24,PROFILE_FRAGMENT_CODE,false));
        list.add(new MenuItem(R.drawable.ic_baseline_settings_24,SETTINGS_FRAGMENT_CODE,false));


        return list;

    }


}
