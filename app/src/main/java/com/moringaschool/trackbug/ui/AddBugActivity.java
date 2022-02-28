package com.moringaschool.trackbug.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.trackbug.R;
import com.moringaschool.trackbug.models.Bug;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddBugActivity extends AppCompatActivity {
    @BindView(R.id.bugName) EditText name;
    @BindView(R.id.bugUrl) EditText bugUrl;
    @BindView(R.id.bugReport) EditText Report;
    @BindView(R.id.bugDate) EditText bugDate;
    @BindView(R.id.summary) EditText msummary;
    @BindView(R.id.textView2) TextView title;
    @BindView(R.id.AddBug) Button addButton;
    private DatabaseReference bugReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bug);
        ButterKnife.bind(this);
        bugReference = FirebaseDatabase
                .getInstance()
                .getReference();
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left);
                addButton.startAnimation(animation);
                String bugName  = name.getText().toString().trim();
                String url = bugUrl.getText().toString().trim();
                String bugReporter = Report.getText().toString().trim();
                String submitDate= bugDate.getText().toString().trim();
                String summary= msummary.getText().toString().trim();
                Bug bugReport = new Bug(bugName,url,bugReporter,submitDate,summary);
                bugReference.push().setValue(bugReport);
                onBackPressed();
                finish();
            }
        });
    }
}