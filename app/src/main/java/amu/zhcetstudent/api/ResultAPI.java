package amu.zhcetstudent.api;

import amu.zhcetstudent.data.model.Result;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by divy on 28/5/17.
 */

public interface ResultAPI {
    @GET("/result/btech")
    Observable<Result>  getResult(@Query("fac") String facultyNumber, @Query("en") String enrollmentNumber, @Query("api_key") String apiKey);
}
