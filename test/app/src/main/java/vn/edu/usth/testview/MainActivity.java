package vn.edu.usth.testview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ViewPager aviewPager;
    private BottomNavigationView abottomNavigationView;
//    private View  viewEndAnimation;
//    private ImageView viewAnimation;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        viewEndAnimation=findViewById(R.id.view_end_animation_best);//ANIMATION ANIMATION BEST SELLER
//        viewAnimation =findViewById(R.id.view_animation_best);//ANIMATION BEST SELLER

        aviewPager = findViewById(R.id.view_pager);
        abottomNavigationView = findViewById(R.id.BottomNavigation);

        ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        aviewPager.setAdapter(adapter);
        aviewPager.setOffscreenPageLimit(3);



        aviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Add any necessary code here
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        abottomNavigationView.getMenu().findItem(R.id.menu_tab1).setChecked(true);
                        break;
                    case 1:
                        abottomNavigationView.getMenu().findItem(R.id.menu_tab2).setChecked(true);
                        break;
                    case 2:
                        abottomNavigationView.getMenu().findItem(R.id.menu_tab3).setChecked(true);
                        break;
                    case 3:
                        abottomNavigationView.getMenu().findItem(R.id.menu_tab4).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Add any necessary code here
            }
        });

        abottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_tab1) {
                    aviewPager.setCurrentItem(0);
                } else if (itemId == R.id.menu_tab2) {
                    aviewPager.setCurrentItem(1);
                } else if (itemId == R.id.menu_tab3) {
                    aviewPager.setCurrentItem(2);
                } else if (itemId == R.id.menu_tab4) {
                    aviewPager.setCurrentItem(3);
                }
                return true;
                }

        });
    }

//    public View getViewEndAnimation() {
//        return viewEndAnimation;
//    }
//
//    public ImageView getViewAnimation() {
//        return viewAnimation;
//    }

}
