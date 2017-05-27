package amu.zhcetstudent.ui.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import amu.zhcetstudent.R;
import amu.zhcetstudent.data.model.Subject;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SubjectViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.course) TextView courseCode;
    @BindView(R.id.total) TextView total;
    @BindView(R.id.grade) TextView grade;

    public SubjectViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void bindSubjectViews(Subject subject){
        courseCode.setText(subject.getCourse());
        total.setText(subject.getTotal());
        grade.setText(subject.getGrades());
    }
}
