package amu.zhcetstudent.ui.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import amu.zhcetstudent.R;
import amu.zhcetstudent.data.model.Result;
import amu.zhcetstudent.data.model.Subject;
import amu.zhcetstudent.ui.ViewHolder.SubjectViewHolder;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectViewHolder> {
    private List<Subject> subjects;

    public SubjectAdapter() {
        this.subjects = new ArrayList<>();
    }

    public void addAllSubjects(List<Subject> subjects) {
        this.subjects.clear();
        this.subjects.addAll(subjects);
        notifyDataSetChanged();
    }

    @Override
    public SubjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_view, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubjectViewHolder holder, int position) {
        holder.bindSubjectViews(subjects.get(position));
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }
}
