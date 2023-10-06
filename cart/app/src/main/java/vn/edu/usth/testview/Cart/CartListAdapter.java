package vn.edu.usth.testview.Cart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import vn.edu.usth.testview.R;
import vn.edu.usth.testview.homepage.BestSeller;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {

    private ArrayList<BestSeller> listFoodSelected;
    private ManagmentCart managmentCart;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<BestSeller> listFoodSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listFoodSelected = listFoodSelected;
        this.managmentCart = new ManagmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BestSeller selectedItem = listFoodSelected.get(position);

        holder.title.setText(selectedItem.getStrMeal());

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(selectedItem.getStrMeal(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new RoundedCorners(30))
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivityCart.class);
            intent.putExtra("object", (CharSequence) selectedItem); // Đính kèm đối tượng selectedItem vào intent
            holder.itemView.getContext().startActivity(intent);

        });

//        holder.minusItem.setOnClickListener(v -> {
//            managmentCart.minusNumberFood(listFoodSelected, position, () -> {
//                notifyDataSetChanged();
//                changeNumberItemsListener.changed();
//            });
//        });
    }

    @Override
    public int getItemCount() {
        return listFoodSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, minusItem;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.pic);
            minusItem = itemView.findViewById(R.id.minusCartBtn);
        }
    }
}
