package com.moringaschool.trackbug.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.trackbug.Adpater.BugAdapter;
import com.moringaschool.trackbug.R;
import com.moringaschool.trackbug.models.Bug;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BugActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.recyclerView) RecyclerView mRecylerView;
    @BindView(R.id.floatingAction) FloatingActionButton floatingAction;
    private DatabaseReference bugReference;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug);
        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRecylerView.setLayoutManager(linearLayoutManager);
        bugReference = FirebaseDatabase
                .getInstance()
                .getReference();

        bugReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                ArrayList<Bug> bugReport=new ArrayList<>();

                Toast.makeText(BugActivity.this,"successful",Toast.LENGTH_LONG).show();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    bugReport.add(postSnapshot.getValue(Bug.class));

                }
                mRecylerView.setAdapter(new BugAdapter(BugActivity.this,bugReport));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(BugActivity.this,"error",Toast.LENGTH_LONG).show();
            }
        });

        floatingAction.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==floatingAction){
            Intent intent = new Intent(BugActivity.this, AddBugActivity.class);
            intent.putExtra(" payment","payment");
            startActivity(intent);
            onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(BugActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}