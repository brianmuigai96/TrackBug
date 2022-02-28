package com.moringaschool.trackbug.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.moringaschool.trackbug.R;
import com.moringaschool.trackbug.models.Bug;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BugDetailsActivity extends AppCompatActivity {
    @BindView(R.id.name) TextView mName;
    @BindView(R.id.textView4) TextView mReport;
    @BindView(R.id.date) TextView mDate;
    @BindView(R.id.description) TextView mSummary;
    @BindView(R.id.textView6) TextView mUrl;
    @BindView(R.id.textView7) TextView mViewBugName;
    @BindView(R.id.textView5) TextView  mViewBugReporter ;
    @BindView(R.id.textView8) TextView mViewSubmitDate;
    @BindView(R.id.textView9) TextView mViewSummary;
    @BindView(R.id.textView10) TextView   mViewUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug_details);
        ButterKnife.bind(this);
        Bug bug = (Bug) getIntent().getSerializableExtra("bug");
        mViewBugName.setText(bug.getBugName());
        mViewBugReporter.setText(bug.getBugReporter());
        mViewSubmitDate.setText(bug.getSubmitDate());
        mViewSummary.setText(bug.getSummary());
        mViewUrl.setText(bug.getUrl());
    }
}