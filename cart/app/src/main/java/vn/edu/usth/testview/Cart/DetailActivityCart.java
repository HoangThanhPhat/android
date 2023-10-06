package vn.edu.usth.testview.Cart;


//import static android.os.Build.VERSION_CODES.R;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
//import com.example.project1301.Domain.FoodDomain;
//import com.example.project1301.Helper.ManagmentCart;
//import com.example.project1301.R;
import vn.edu.usth.testview.R;

import vn.edu.usth.testview.homepage.BestSeller;

public class DetailActivityCart extends AppCompatActivity {
    //private Button addToCartBtn;
    private TextView plusBtn, minusBtn, titleTxt, feeTxt, descriptionTxt, numberOrderTxt, startTxt, caloryTxt, timeTxt;
    private ImageView picFood;
    private BestSeller object;
    private int numberOrder = 1;
//    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cart);

//        managmentCart = new ManagmentCart(DetailActivityCart.this);

        initView();
        getBundle();
    }

    private void getBundle() {
        object = (BestSeller) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getStrMeal(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        titleTxt.setText(object.getStrMeal());
        //feeTxt.setText("$" + object.getPrice());
        descriptionTxt.setText(object.getStrMealThumb());
//        numberOrderTxt.setText("" + numberOrder);


    }



    private void initView() {
//        //addToCartBtn = findViewById(R.id.addToCartBtn);
//        timeTxt = findViewById(R.id.timeTxt);
        //feeTxt = findViewById(R.id.priceTxt);
        titleTxt=findViewById(R.id.titleTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
//        numberOrderTxt = findViewById(R.id.numberItemTxt);
//        plusBtn = findViewById(R.id.plusCardBtn);
//        minusBtn = findViewById(R.id.MinusCartBtn);
        picFood = findViewById(R.id.foodPic);
//        startTxt = findViewById(R.id.StarTxt);
//        caloryTxt = findViewById(R.id.calTxt);

    }
}