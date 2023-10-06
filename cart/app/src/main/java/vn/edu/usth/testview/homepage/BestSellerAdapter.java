package vn.edu.usth.testview.homepage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.testview.R;
import vn.edu.usth.testview.Tab1;


public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.ViewHolder> {

    Tab1 context;
    ArrayList<BestSeller> bestSellers;
    private ViewHolder holder;
    private int position;

    public BestSellerAdapter(Tab1 context , ArrayList<BestSeller> arrayList, OnItemClickListener listener) {
        this.context = context;
        this.bestSellers = arrayList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public BestSellerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_best_seller,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellerAdapter.ViewHolder holder, int position) {
        this.holder = holder;
        this.position = position;
        holder.bind(bestSellers.get(position));
    }

    public void setData(List<BestSeller> data) {
        this.bestSellers = (ArrayList<BestSeller>) data;
    }

    @Override
    public int getItemCount() {
        return bestSellers.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_best_seller_name);
//            descrip = itemView.findViewById(R.id.tv_description_best_seller);
            image = itemView.findViewById(R.id.img_best_seller);

        }

        public void bind(BestSeller bestSeller){
            name.setText(bestSeller.getStrMeal());
            Glide.with(context).load(bestSeller.getStrMealThumb()).into(image);
        }
    }




    // Đối tượng để gửi dữ liệu khi một mục được nhấp vào
    public interface OnItemClickListener {
        void onItemClick(BestSeller bestSeller);
    }

    private final OnItemClickListener listener;

    // Constructor
    public BestSellerAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    // ...

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        this.holder = holder;
        this.position = position;
        // Bắt sự kiện click trên mục Best Seller
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(bestSellers.get(position)); // Gửi dữ liệu đến listener
            }
        });
    }
}
}

