package ru.vovan.homework2;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private TextView result_txt;
    private TextView mTextView;
    private TextView bTextView;
    private TextView cTextView;
    private StringBuilder inputStr = new StringBuilder(); // строка ввода


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_txt = findViewById(R.id.result);
        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        mTextView = (TextView)findViewById(R.id.textView);
        mTextView.setText("0");

        final SeekBar seekBar2 = (SeekBar)findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(this);
        bTextView = (TextView)findViewById(R.id.textView2);
        bTextView.setText("0");

        final SeekBar seekBar3 = (SeekBar)findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(this);
        cTextView = (TextView)findViewById(R.id.textView3);
        cTextView.setText("0");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(seekBar.getId()==R.id.seekBar)
            mTextView.setText(String.valueOf(seekBar.getProgress()));
        else if(seekBar.getId()==R.id.seekBar2)
            bTextView.setText(String.valueOf(seekBar.getProgress()));
        else
            cTextView.setText(String.valueOf(seekBar.getProgress()));


    }

    public void onButtonClick(View view)
    {
        int bill=70;
        inputStr.setLength(0);
        inputStr.append(mTextView.getText());
        int res1=Integer.parseInt(inputStr.toString());
        inputStr.setLength(0);
        inputStr.append(bTextView.getText());
        int res2=Integer.parseInt(inputStr.toString());
        inputStr.setLength(0);
        inputStr.append(cTextView.getText());
        int res3=Integer.parseInt(inputStr.toString());
        int res = (bill * res1)+(res2*(bill/2)+(res3*(bill-21)));
        result_txt.setText(Integer.toString(res));

    }
}