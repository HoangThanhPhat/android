package vn.edu.usth.testview.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.usth.testview.MainActivity;
import vn.edu.usth.testview.R;
import vn.edu.usth.testview.homepage.BestSellerAdapter;


public class Tab5HomePageFragment extends Fragment {
    private RecyclerView rcvBestSeller;
    private View mView;
    private MainActivity mainActivity;
    private BestSellerAdapter bestSellerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_tab5_homepage, container, false);
        mainActivity = (MainActivity) getActivity();

        rcvBestSeller = mView.findViewById(R.id.rcv_Best_Seller);
        LinearLayoutManager LinearLayoutManagerBestSeller = new LinearLayoutManager(mainActivity);
        rcvBestSeller.setLayoutManager(LinearLayoutManagerBestSeller);
//        bestSellerAdapter = new BestSellerAdapter();
//        bestSellerAdapter.setData(getListBestSeller(), new BestSellerAdapter.IClickAddToCartListener() {
//            @Override
//            public void OnClickAddToCart(ImageView imgAddCartBestSeller, BestSeller bestSeller) {
//                AnimationUtilBest.translateAnimationBest(mainActivity.getViewAnimation(), imgAddCartBestSeller, mainActivity.getViewEndAnimation(), new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//
//                    }
//                });
//            }
//        });
//        rcvBestSeller.setAdapter(bestSellerAdapter);
//        return mView;
//    }
//
//    private List<BestSeller> getListBestSeller() {
//        List<BestSeller> List = new ArrayList<>();
//        List.add(new BestSeller(R.drawable.pizza, "Product 1 ", "ngon vklll"));
//        List.add(new BestSeller(R.drawable.chicken, "product 2", "this is hello"));
//        List.add(new BestSeller(R.drawable.hamburger, "product 3", "this is hello"));
//        List.add(new BestSeller(R.drawable.seafood, "product 4", "this is hello"));
//        List.add(new BestSeller(R.drawable.comtam, "product 5", "this is hello"));
//        List.add(new BestSeller(R.drawable.friedegg, "product 6", "this is hello"));
//        List.add(new BestSeller(R.drawable.friedchicken, "product 7", "this is hello"));
//        List.add(new BestSeller(R.drawable.hamburgernoti, "product 8", "this is hello"));
//        List.add(new BestSeller(R.drawable.kimbap, "product 9", "this is hello"));
//        List.add(new BestSeller(R.drawable.tok, "product 10", "this is hello"));
//        List.add(new BestSeller(R.drawable.meat, "product 11", "this is hello"));
//        List.add(new BestSeller(R.drawable.trasua, "product 12", "this is hello"));
//        List.add(new BestSeller(R.drawable.sushi, "product 13", "this is hello"));
//        List.add(new BestSeller(R.drawable.vegetables, "product 14", "this is hello"));
//        List.add(new BestSeller(R.drawable.meat, "product 15", "this is hello"));
//        List.add(new BestSeller(R.drawable.seafood, "product 16", "this is hello"));
//        List.add(new BestSeller(R.drawable.pizzanoti, "product 17", "this is hello"));
//        List.add(new BestSeller(R.drawable.ramennoti, "product 18", "this is hello"));
//
//        return List;
        return mView;
    }
}