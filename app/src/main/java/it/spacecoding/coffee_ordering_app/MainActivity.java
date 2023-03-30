package it.spacecoding.coffee_ordering_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {



    // gli attributi privati non statici iniziano con m
    private int mCount;
    private double mTotalCost;
    private TextView mShowCount;
    private TextView mShowTotalCost;
    // gli attributi statici iniziano con la s
    private static double sUnitCost = 1.2;
    // gli attributi final static sono tutti in UPPERCASE
    private final static double COFFEE_COST = 1.2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCount = 0;
        mTotalCost = 0.0;

        mShowCount = (TextView) findViewById(R.id.show_count);
        mShowTotalCost = (TextView) findViewById(R.id.show_total_cost);


    }

    public void decrease(View view) {
        if(mCount <= 0){
            //Toast per gestire errore
            Toast toast = Toast.makeText(this,"Non puoi ordinare un numero negativo di caffè!",Toast.LENGTH_LONG);
            toast.show();
        }else{
            mCount--;
            if(mShowCount != null){
                mShowCount.setText(Integer.toString(mCount));

                // formatto il numero a due soli decimali
                NumberFormat formatter = new DecimalFormat("#0.00");

                mTotalCost = mCount * COFFEE_COST ;

                mShowTotalCost.setText(formatter.format(mTotalCost));
            }
        }
    }

    public void increase(View view) {
        mCount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));

            // formatto il numero a due soli decimali
            NumberFormat formatter = new DecimalFormat("#0.00");

            mTotalCost = mCount * COFFEE_COST ;

            mShowTotalCost.setText(formatter.format(mTotalCost));
        }
    }

}