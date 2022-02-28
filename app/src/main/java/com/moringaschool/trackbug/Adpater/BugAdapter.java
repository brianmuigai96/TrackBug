package com.moringaschool.trackbug.Adpater;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.trackbug.R;
import com.moringaschool.trackbug.models.Bug;
import com.moringaschool.trackbug.ui.BugDetailsActivity;

import java.util.ArrayList;

public class BugAdapter extends RecyclerView.Adapter<BugAdapter.ViewHolder> {
    Context context;
    ArrayList<Bug> bugReport;

    public BugAdapter(Context context, ArrayList<Bug> bugReport) {
        this.context = context;
        this.bugReport = bugReport;
    }

    @Override
    public BugAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflate =LayoutInflater.from(context);
        View view = inflate.inflate(R.layout.add_bug_strip,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(BugAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);
        holder.textView1.setText(bugReport.get(position).getBugName());
        holder.textView2.setText(bugReport.get(position).getSubmitDate());
//        holder.textView3.setText(bugReport.get(position).getBugReporter());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BugDetailsActivity.class);
                intent.putExtra("bug", bugReport.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bugReport.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView1;
            TextView textView2;
            TextView textView3;
            CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView1 =itemView.findViewById(R.id.bugName);
            textView2 =itemView.findViewById(R.id.submitDate);
            textView3 =itemView.findViewById(R.id.bugReport);
            cardView =itemView.findViewById(R.id.cardview);
        }


    }
}

