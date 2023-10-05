package vn.edu.usth.testview.homepage;

import java.util.ArrayList;

public class BestSellerApiResponse {
    private ArrayList<BestSeller> meals;

    public BestSellerApiResponse(ArrayList<BestSeller> meals) {
        this.meals = meals;
    }

    public ArrayList<BestSeller> getMeals() {
        return meals;
    }
}
