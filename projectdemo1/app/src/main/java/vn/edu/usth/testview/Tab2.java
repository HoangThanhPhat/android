package vn.edu.usth.testview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.testview.widget.CustomViewPager;

public class Tab2 extends Fragment {
    private TabLayout tabLayout;
    private CustomViewPager viewPager;
    private View oView ;

    public Tab2 () {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tab2, container, false);

        return view;
    }
}