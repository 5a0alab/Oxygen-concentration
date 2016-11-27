package app.tabsample.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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
 */
public class activityFragment extends Fragment{
    public BarChart barChart;
    public ArrayList<BarEntry> entries=new ArrayList<BarEntry>();
    public BarDataSet dataset;
    public String[] labels = new String[] {"0", "1", "2", "3", "4", "5",  "6", "7", "8", "9", "10", "11",  "12", "13", "14", "15", "16", "17",  "18", "19", "20", "21", "22", "23"};;
    public int[] activity = new int[] {5,2,3,0,0,0,0,0,0,1,1,0,0,6,5,10,66,67,80,120,289,547,600,321};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_layout, container, false);
        setView(view);
        setListener(view);
        EntriesData();
        show();
        return view;
    }
    //初始化view
    public void setView(View view){
        barChart= (BarChart) view.findViewById(R.id.bar_chart);
    }
    //初始化listener
    public void setListener(View view){
        barChart.setOnClickListener(barViewClick);
    }
    //data setting
    public void addData(){
        //activity[0]=10;
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

        //取消highlight
        barChart.setHighlightPerDragEnabled(false);
        barChart.setHighlightPerTapEnabled(false);
        barChart.invalidate(); // refresh
    }

    //畫面禁止room in out
    private View.OnClickListener barViewClick = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            barChart.fitScreen();
        }
    };

}
