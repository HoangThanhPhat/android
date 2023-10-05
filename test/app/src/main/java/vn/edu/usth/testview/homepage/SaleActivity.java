package vn.edu.usth.testview.homepage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.testview.R;

public class SaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_detail);

        Bundle bundle = getIntent().getExtras();
        if(bundle==null){
            return;
        }
        Sale sale = (Sale) bundle.get("object_sale_homepage");

        @SuppressLint({"MissingInflatedId", "LocalSuppress", "WrongViewCast"})
        ImageView imgSale = findViewById(R.id.img_sale_homepage);
        imgSale.setImageResource(sale.getResourceId());


    }
}