package vn.edu.usth.testview.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.testview.MainActivity;
import vn.edu.usth.testview.R;
import vn.edu.usth.testview.client.ApiClient;
import vn.edu.usth.testview.client.ApiInterface;
import vn.edu.usth.testview.homepage.BestSeller;
import vn.edu.usth.testview.homepage.BestSellerAdapter;
import vn.edu.usth.testview.homepage.BestSellerApiResponse;
import vn.edu.usth.testview.homepage.Photo;
import vn.edu.usth.testview.homepage.PhotoAdapter;
import vn.edu.usth.testview.homepage.Sale;
import vn.edu.usth.testview.homepage.SaleAdapter;

public class Tab1HomePageFragment extends Fragment {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private List<Photo> mlistPhoto;
    private Timer mTimer;


    private RecyclerView rcvDataSale;
    private SaleAdapter saleAdapter;
    SearchView searchView;
    private String a = new String("");


    private RecyclerView rcvBestSeller;
    private View mView;
    private MainActivity mainActivity;
    private BestSellerAdapter bestSellerAdapter;
    ArrayList<BestSeller> bestSellers;
    ArrayList<BestSeller> bestSellersOld;
    ArrayList<BestSeller> searchList;
    ArrayList<BestSeller> arrayList = new ArrayList<>();





    public Tab1HomePageFragment() {

    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_tab1_homepage, container, false);
        //Best seller


        searchView = mView.findViewById(R.id.searchview);
        mainActivity = (MainActivity) getActivity();
        bestSellers = new ArrayList<>();
        bestSellersOld = bestSellers;

        for (int i = 0; i < bestSellers.toArray().length ; i++) {
                BestSeller bestSeller = new BestSeller();
                bestSeller.getStrMeal();
                bestSeller.getStrMealThumb();
                arrayList.add(bestSeller);

        }


//-------------------can thiet-----------------------------------------------------------------------------------
        rcvBestSeller = mView.findViewById(R.id.rcv_Best_Seller);
//        LinearLayoutManager LinearLayoutManagerBestSeller = new LinearLayoutManager(mainActivity);
//        rcvBestSeller.setLayoutManager(LinearLayoutManagerBestSeller);
//        rcvBestSeller.setLayoutManager(new LinearLayoutManager(Tab1HomePageFragment.getApplicationContext()));


        rcvBestSeller.setLayoutManager(new LinearLayoutManager(requireContext()));

        bestSellerAdapter = new BestSellerAdapter(Tab1HomePageFragment.this,bestSellers);
        rcvBestSeller.setAdapter(bestSellerAdapter);
        populateBest();
//-----------------------------------------------------------------------------------------------------------------




//----------------------------------------------------Search View---------------------------------------------------
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList = new ArrayList<>();


                if (query.length() > 0) {
                    for (int i = 0; i < bestSellers.size(); i++) {
                        if (bestSellers.get(i).getStrMeal().toUpperCase().contains(query.toUpperCase())) {
                            searchList.add(bestSellers.get(i));
                        }
                    }

                    if (searchList.isEmpty()) {
                        // Không có kết quả tìm kiếm, hiển thị danh sách ban đầu
                        bestSellerAdapter.setData(bestSellers);
                    } else {
                        // Có kết quả tìm kiếm, hiển thị danh sách tìm kiếm
                        bestSellerAdapter.setData(searchList);
                    }

                    bestSellerAdapter.notifyDataSetChanged();
                }
                else {
                    bestSellerAdapter.setData(bestSellers);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = "no have data" ;
                return false;
            }
        });










//------------------------------------------------------------------------------------------------------------------







//------------------------------------------------ANIMATION--------------------------------------------------------------------
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
//--------------------------------------------------------------------------------------------------------------------------------



        rcvBestSeller.setAdapter(bestSellerAdapter);


        //COLLECTION

        rcvDataSale = mView.findViewById(R.id.rcv_sale_homepage);
        LinearLayoutManager linearLayoutManagerSale = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvDataSale.setLayoutManager(linearLayoutManagerSale);


        saleAdapter = new SaleAdapter(requireContext(), getListSale1());
        rcvDataSale.setAdapter(saleAdapter);






        //VIEW PAGER

        viewPager = mView.findViewById(R.id.viewpagerslide);
        circleIndicator = mView.findViewById(R.id.circle_indicator);

        mlistPhoto = getListPhoto();
        photoAdapter = new PhotoAdapter(requireContext(), mlistPhoto);
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        return mView;

    }

    private static Context getApplicationContext() {

        return null;
    }




    // Recycle view của collection
    private List<Sale> getListSale1() {
        List<Sale> list1 = new ArrayList<>();
        list1.add(new Sale(R.drawable.sale1, "Tiếp Sức 'Mùa Sale' Giảm 40%"));
        list1.add(new Sale(R.drawable.sale2, "Tiệc độc quyền: 1Đ + Freeship"));
        list1.add(new Sale(R.drawable.sale3, "Siêu Deal 0Đ Món Gì Cũng Có"));
        list1.add(new Sale(R.drawable.sale4, "Thứ 7 vui vẻ giảm tới 50.000Đ"));
        list1.add(new Sale(R.drawable.sale5, "Voucher Vạn Năng"));
        list1.add(new Sale(R.drawable.sale6, "Vạn Món Giá Hời"));

        return list1;
    }

    //VIEW PAGER
    private List<Photo> getListPhoto() {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.slideimg1));
        list.add(new Photo(R.drawable.slideimg2));
        list.add(new Photo(R.drawable.slideimg3));
        return list;
    }

// Auto slide------------------------------------------------------------------
    private void autoSlideImages() {
        if (mlistPhoto == null || mlistPhoto.isEmpty() || viewPager == null) {
            return;
        }
        if (mTimer == null) {
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = mlistPhoto.size() - 1;
                        if (currentItem < totalItem) {
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        } else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 1000, 2000);
    }

    @Override
    public void onResume() {
        super.onResume();
        autoSlideImages();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }

        if (saleAdapter != null) {
            saleAdapter.release();
        }
    }

    public void populateBest(){
        ApiClient.getClient().create(ApiInterface.class).getBestSeller("Canadian").enqueue(new Callback<BestSellerApiResponse>() {
            @Override
            public void onResponse(Call<BestSellerApiResponse> call, Response<BestSellerApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<BestSeller> mealList = response.body().getMeals();
                    if (mealList != null && !mealList.isEmpty()) {
                        bestSellers.addAll(mealList);
                        bestSellerAdapter.notifyDataSetChanged();
                    } else {

                        Log.e("populateBest", "Danh sách món ăn trống");
                    }
                } else {
                    Log.e("populateBest", "Yêu cầu API thất bại với mã phản hồi: " + response.code());
                }
            }


            @Override
            public void onFailure(Call<BestSellerApiResponse> call, Throwable t) {

            }
        });
    }
}
