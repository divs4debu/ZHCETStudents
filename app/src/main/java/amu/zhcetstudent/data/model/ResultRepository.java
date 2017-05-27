package amu.zhcetstudent.data.model;

import amu.zhcetstudent.api.ResultAPI;
import amu.zhcetstudent.contract.model.ResultRepositoryModel;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class ResultRepository implements ResultRepositoryModel {
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://ctengg-api.appspot.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    @Override
    public Observable<Result> getResult(String facultyNo, String enrolmentNo) {
        return retrofit.create(ResultAPI.class).getResult(facultyNo, enrolmentNo, "debug_iamdebu");
    }
}
