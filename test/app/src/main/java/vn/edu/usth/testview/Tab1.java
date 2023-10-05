package vn.edu.usth.testview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import vn.edu.usth.testview.homepage.BestSeller;
import vn.edu.usth.testview.homepage.BestSellerAdapter;
import vn.edu.usth.testview.order.CategoryHomePageViewpageAdapter;
import vn.edu.usth.testview.order.Tab1HomePageFragment;
import vn.edu.usth.testview.widget.CustomViewPager;


public class Tab1 extends Fragment {
    private TabLayout tabLayoutCate;
    private CustomViewPager viewPagerCate;
    private View oViewCate;

//    SearchView searchView;
//    RecyclerView recyclerView;
//    ArrayList<ModelClass> arrayList = new ArrayList<>();
//    ArrayList<ModelClass> searchList;

    SearchView searchView;
    private BestSellerAdapter bestSellerAdapter;
    ArrayList<BestSeller> bestSellers;
    ArrayList<BestSeller> bestSellersOld;
    ArrayList<BestSeller> searchList;
    ArrayList<BestSeller> arrayList = new ArrayList<>();

    private RecyclerView rcvBestSeller;

    private MainActivity mainActivity;


    public Tab1() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        oViewCate = inflater.inflate(R.layout.fragment_tab1, container, false);
        tabLayoutCate = oViewCate.findViewById(R.id.category_homepage1);
        viewPagerCate = oViewCate.findViewById(R.id.order_viewpagerCate);

        CategoryHomePageViewpageAdapter adapter = new CategoryHomePageViewpageAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerCate.setAdapter(adapter);
        viewPagerCate.setPagingEnabled(false);

        tabLayoutCate.setupWithViewPager(viewPagerCate);








//
//        searchView = oViewCate.findViewById(R.id.searchview);
//        mainActivity = (MainActivity) getActivity();
//        bestSellers = new ArrayList<>();
//        bestSellersOld = bestSellers;
//
//        for (int i = 0; i < bestSellers.toArray().length ; i++) {
//            BestSeller bestSeller = new BestSeller();
//            bestSeller.getStrMeal();
//            bestSeller.getStrMealThumb();
//            arrayList.add(bestSeller);
//
//        }
//
//
////-------------------can thiet-----------------------------------------------------------------------------------
//        rcvBestSeller = oViewCate.findViewById(R.id.rcv_Best_Seller);
////        LinearLayoutManager LinearLayoutManagerBestSeller = new LinearLayoutManager(mainActivity);
////        rcvBestSeller.setLayoutManager(LinearLayoutManagerBestSeller);
////        rcvBestSeller.setLayoutManager(new LinearLayoutManager(Tab1HomePageFragment.getApplicationContext()));
//
//
//        rcvBestSeller.setLayoutManager(new LinearLayoutManager(requireContext()));
//
//        bestSellerAdapter = new BestSellerAdapter(Tab1.this,bestSellers);
//        rcvBestSeller.setAdapter(bestSellerAdapter);
////-----------------------------------------------------------------------------------------------------------------
//
//
//
//
////----------------------------------------------------Search View---------------------------------------------------
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                searchList = new ArrayList<>();
//
//                if (query.length() > 0 ) {
//                    for (int i = 0; i < arrayList.size(); i++) {
//                        if (arrayList.get(i).getStrMeal().toUpperCase().contains(query.toUpperCase())){
//                            BestSeller bestSeller = new BestSeller();
//                            bestSeller.setStrMeal(arrayList.get(i).getStrMeal());
//                            bestSeller.setStrMealThumb(arrayList.get(i).getStrMealThumb());
//                            searchList.add(bestSeller);
//                        }
//
//                    }
//
//                    rcvBestSeller.setLayoutManager(new LinearLayoutManager(requireContext()));
//
//                    bestSellerAdapter = new BestSellerAdapter(Tab1.this,bestSellers);
//                    rcvBestSeller.setAdapter(bestSellerAdapter);
//
//
//                }
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });









//------------------------------------------------------------------------------------------------------------------




































        return oViewCate;
    }
}