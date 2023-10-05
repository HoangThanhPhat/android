package vn.edu.usth.testview.homepage;

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
    public BestSellerAdapter(Tab1 context , ArrayList<BestSeller> arrayList) {
        this.context = context;
        this.bestSellers = arrayList;
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
}

