package app.tabsample.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.txusballesteros.widgets.FitChart;
import com.txusballesteros.widgets.FitChartValue;

import java.util.ArrayList;
import java.util.Collection;

import app.tabsample.R;

/**
 * Created by adilsoomro on 8/19/16.
 *  * Edit by Jim YMU lab421 2016/11/27

 */
public class homeFragment extends Fragment{
    int statusScore;
    public FitChart fitChart;
    TextView score;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.home_layout, container, false);

        setView(v);
        setScore();
        drawCircle();
        return v;
    }
    //initial setview
    public void setView(View v){
        fitChart=(FitChart) v.findViewById(R.id.fitChart);
        score=(TextView) v.findViewById(R.id.score);
    }
    //設定分數
    public void setScore(){
        statusScore=85;
        //呈現%數
        score.setText(statusScore+"%");
    }
    //畫圖
    public void drawCircle(){
        fitChart.setMinValue(0f);
        fitChart.setMaxValue(100f);
        Collection<FitChartValue> values = new ArrayList<>();
        values.add(new FitChartValue(statusScore, getResources().getColor(R.color.chart_value_3)));
        fitChart.setValues(values);
    }


}
