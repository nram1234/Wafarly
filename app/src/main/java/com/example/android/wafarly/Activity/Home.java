package com.example.android.wafarly.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.wafarly.Adapter.AdsSlide;
import com.example.android.wafarly.Adapter.RecyclerViewItem;
import com.example.android.wafarly.DataType.GanralDataType;
import com.example.android.wafarly.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Home extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    ViewPager viewPager;
    AdsSlide adpter;
    CircleIndicator indicator;
    LinearLayout linearLayout;
    Handler handler;
    Runnable runnable;
    Timer timer;
    RecyclerView recyclerView1;
    RecyclerViewItem adapter1;

    RecyclerView recyclerView2;
    RecyclerViewItem adapter2;

    RecyclerView recyclerView3;
    RecyclerViewItem adapter3;

    RecyclerView recyclerView4;
    RecyclerViewItem adapter4;

    RecyclerView recyclerView5;
    RecyclerViewItem adapter5;

    RecyclerView recyclerView6;
    RecyclerViewItem adapter6;
    List<GanralDataType>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        list=new ArrayList<>();
        adddata();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        viewPager=(ViewPager)findViewById(R.id.viwpagerhome);
        recyclerView1=findViewById(R.id.rv1);
        recyclerView2=findViewById(R.id.rv2);
        recyclerView3=findViewById(R.id.rv3);
        recyclerView4=findViewById(R.id.rv4);
        recyclerView5=findViewById(R.id.rv5);
        recyclerView6=findViewById(R.id.rv6);
        adpter=new AdsSlide(this);
        viewPager.setAdapter(adpter);
        indicator=(CircleIndicator) findViewById(R.id.circularhome);
        indicator.setViewPager(viewPager);
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                int i=viewPager.getCurrentItem();
                int p=adpter.image.length;
                if(i==p-1){

                    i=0;

                    viewPager.setCurrentItem(i,true);
                }else {
                    i++;

                    viewPager.setCurrentItem(i,true);
                }


            }
        };
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },2000,2000);


        adapter1=new RecyclerViewItem(this,list);
        adapter2=new RecyclerViewItem(this,list);
        adapter3=new RecyclerViewItem(this,list);
        adapter4=new RecyclerViewItem(this,list);
        adapter5=new RecyclerViewItem(this,list);
        adapter6=new RecyclerViewItem(this,list);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(mLayoutManager);
        recyclerView1.setAdapter(adapter1);
       //---------------------------------------------------------------
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(this);

        ((LinearLayoutManager) mLayoutManager1).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(mLayoutManager1);
        recyclerView2.setAdapter(adapter2);
        //---------------------------------------------------------------
        RecyclerView.LayoutManager mLayoutManager3 = new LinearLayoutManager(this);

        ((LinearLayoutManager) mLayoutManager3).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView3.setLayoutManager(mLayoutManager3);
        recyclerView3.setAdapter(adapter3);
        //---------------------------------------------------------------
        RecyclerView.LayoutManager mLayoutManager4 = new LinearLayoutManager(this);

        ((LinearLayoutManager) mLayoutManager4).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView4.setLayoutManager(mLayoutManager4);
        recyclerView4.setAdapter(adapter4);
        //---------------------------------------------------------------
        RecyclerView.LayoutManager mLayoutManager5 = new LinearLayoutManager(this);

        ((LinearLayoutManager) mLayoutManager5).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView5.setLayoutManager(mLayoutManager5);
        recyclerView5.setAdapter(adapter5);
        //---------------------------------------------------------------
        RecyclerView.LayoutManager mLayoutManager6 = new LinearLayoutManager(this);

        ((LinearLayoutManager) mLayoutManager6).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView6.setLayoutManager(mLayoutManager6);
        recyclerView6.setAdapter(adapter6);
    }


void adddata(){
        for (int i=0;i<20;i++){
            list.add(new GanralDataType(R.drawable.joy,"it item number   "+i));

        }
}


    }


