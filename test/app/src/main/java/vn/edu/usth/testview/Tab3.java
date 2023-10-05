package vn.edu.usth.testview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.testview.Notification.Noti;
import vn.edu.usth.testview.Notification.NotiAdapter;

public class Tab3 extends Fragment {


    private RecyclerView rcvData;
    private int contentView;
    private NotiAdapter userAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tab3, container, false);

        return view;
    }


}