package vn.edu.usth.testview.Cart;

import android.content.Context;
import android.widget.Toast;

//import com.example.project1301.Domain.FoodDomain;

import java.util.ArrayList;

import vn.edu.usth.testview.homepage.BestSeller;

public class ManagmentCart {

    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(BestSeller item) {
        ArrayList<BestSeller> listfood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int y = 0; y < listfood.size(); y++) {
            if (listfood.get(y).getStrMeal().equals(item.getStrMeal())) {
                existAlready = true;
                n = y;
                break;
            }
        }
        if (existAlready) {
            //listfood.get(n).setNumberinCart(item.getNumberinCart());
            Toast.makeText(context, "Already Exist", Toast.LENGTH_SHORT).show();
        } else {
            listfood.add(item);
            Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
        }
        tinyDB.putListObject("CartList", listfood);

    }

    public ArrayList<BestSeller> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public void minusNumberFood(ArrayList<BestSeller> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        //if (listfood.get(position).getNumberinCart() == 1) {
            listfood.remove(position);
        /*} else {
            listfood.get(position).setNumberinCart(listfood.get(position).getNumberinCart() - 1);
        } */
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }

    /*
    public void plusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listfood.get(position).setNumberinCart(listfood.get(position).getNumberinCart() + 1);
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<FoodDomain> listfood2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listfood2.size(); i++) {
            fee = fee + (listfood2.get(i).getPrice() * listfood2.get(i).getNumberinCart());
        }
        return fee;
    }

     */
}
