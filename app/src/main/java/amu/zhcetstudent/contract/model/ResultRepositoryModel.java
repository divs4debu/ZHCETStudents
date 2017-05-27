package amu.zhcetstudent.contract.model;

import amu.zhcetstudent.data.model.Result;
import io.reactivex.Observable;

public interface ResultRepositoryModel {

    Observable<Result> getResult(String facultyNo, String enrolmentNo);

}
