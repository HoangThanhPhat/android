package vn.edu.usth.testview.homepage;

import com.google.gson.annotations.SerializedName;

public class BestSeller {
   private String strMeal ;
   @SerializedName("strMealThumb")
   private String strMealThumb;

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }
}
