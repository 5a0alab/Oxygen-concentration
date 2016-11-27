package app.tabsample.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

import app.tabsample.R;
import app.tabsample.util.MyXAxisValueFormatter;


/**
 * Created by adilsoomro on 8/19/16.
 * Edit by Jim YMU lab421 2016/11/27
 */

public class activityFragment extends Fragment{
    public BarChart barChart;
    public ArrayList<BarEntry> entries=new ArrayList<BarEntry>();
    public BarDataSet dataset;
    public ImageView zoomin,zoomout;

    public String[] labels = new String[] {"0", "1", "2", "3", "4", "5",  "6", "7", "8", "9", "10", "11",  "12", "13", "14", "15", "16", "17",  "18", "19", "20", "21", "22", "23"};;
    public int[] activity = new int[24];
    public int[] activityBarColor = new int[24];
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_layout, container, false);

        setView(view);
        setListener(view);

        addData();
        EntriesData();

        show();
        return view;
    }
    //初始化view
    public void setView(View view){
        barChart= (BarChart) view.findViewById(R.id.bar_chart);
        zoomin= (ImageView) view.findViewById(R.id.zoomin);
        zoomout= (ImageView) view.findViewById(R.id.zoomout);
    }
    //初始化listener
    public void setListener(View view){
        barChart.setOnClickListener(barViewClick);
        zoomout.setOnClickListener(zoomoutClick);
        zoomin.setOnClickListener(zoominClick);
    }
    //data setting
    public void addData(){
        for (int i = 0; i < 24; i++) {
            activity[i]=(int)(Math.random()*1500);
            //設定bar顏色
            //activityBarColor[i]= setBarColor(activity[i]);
        }
    }
    //entris data
    public void EntriesData(){
        for (int i = 0; i <24 ; i++) {
            entries.add(new BarEntry(i, activity[i]));
        }
    }

    public void show(){
        dataset= new BarDataSet(entries,getResources().getString(R.string.activity));
        BarData data=new BarData(dataset);
        dataset.setColors(ColorTemplate.VORDIPLOM_COLORS[3]);

        //設定X軸
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(labels));
        xAxis.setLabelCount(24);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        //設定Y軸
        barChart.getAxisRight().setEnabled(false);
        barChart.getAxisLeft().setAxisMinimum(0f); // start at zero

        barChart.setData(data);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars

        //highlight
        barChart.setHighlightPerDragEnabled(true);
        barChart.setHighlightPerTapEnabled(true);
        barChart.invalidate(); // refresh
    }

//    //設定bar的color 根據不同的活動量
//    public int setBarColor(int barActivityCount){
//        int color;
//
//        if(barActivityCount<=10){
//            color=ColorTemplate.VORDIPLOM_COLORS[0];
//        }
//        else if(barActivityCount>10 && barActivityCount<=100){
//            color=ColorTemplate.VORDIPLOM_COLORS[1];
//        }
//        else if(barActivityCount>100 && barActivityCount<=500){
//            color=ColorTemplate.VORDIPLOM_COLORS[2];
//        }
//        else if(barActivityCount>500 && barActivityCount<=1000){
//            color=ColorTemplate.VORDIPLOM_COLORS[3];
//        }
//        else{
//            color=ColorTemplate.VORDIPLOM_COLORS[4];
//        }
//        return color;
//    }

    //畫面禁止room in out
    private View.OnClickListener barViewClick = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            barChart.fitScreen();
        }
    };

    //zoomout
    private View.OnClickListener zoomoutClick = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            barChart.zoomOut();
        }
    };

    //zoomin
    private View.OnClickListener zoominClick = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            barChart.zoomIn();
        }
    };
}
