package vn.edu.usth.testview.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vn.edu.usth.testview.homepage.BestSellerApiResponse;

public interface ApiInterface {
    @GET("api/json/v1/1/filter.php")
    Call<BestSellerApiResponse> getBestSeller(@Query("a") String a);
}
