package amu.zhcetstudent.ui.presenter;

import android.util.Log;

import amu.zhcetstudent.contract.model.ResultRepositoryModel;
import amu.zhcetstudent.contract.presenter.MainPresenter;
import amu.zhcetstudent.contract.view.MainView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter implements MainPresenter {
    private final String  TAG = "MainPresenter";
    private MainView mainView;
    private ResultRepositoryModel resultRepositoryModel;

    public MainActivityPresenter(MainView mainView, ResultRepositoryModel resultRepositoryModel) {
        this.mainView = mainView;
        this.resultRepositoryModel = resultRepositoryModel;
    }

    @Override
    public void loadResult(String facultyNo, String enrolmentNo) {

        mainView.showProgress(true);
        Log.d(TAG, "In the MainPresneter");
        resultRepositoryModel.getResult(facultyNo, enrolmentNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    Log.d(TAG, result.getName());
                    if (result.getError()) {
                        mainView.showError(result.getMessage());
                    } else {
                        mainView.showResult(result);
                    }
                    mainView.showProgress(false);
                }, throwable -> {
                    Log.d(TAG, throwable.toString());
                    mainView.showError("Network Error Occurred");
                    mainView.showProgress(false);
                });
    }
}
