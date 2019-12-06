package com.spandan.graphplottingtry2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        graph.getGridLabelRenderer().setVerticalAxisTitle("Y- Axis");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("X- Axis");
        graph.getViewport().setScalable(true);
        //graph.getViewport().setMinX(5);

        graph.setTitle("Graph Plotting Try 1");
        graph.setTitleTextSize(40);


        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6),
                new DataPoint(5, 6)
        });
        graph.addSeries(series);

        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                String msg="X: "+ dataPoint.getX()+"\nY: "+dataPoint.getY();
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
            }
        });
    }
}
