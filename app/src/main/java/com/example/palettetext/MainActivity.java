package com.example.palettetext;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.RadialGradient;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    // 设置变量
    TextView display, textView;
    Button buttonLeft, buttonRight, buttonConfirm;
    Switch aSwitch;
    ProgressBar progressBar;
    EditText editText;
    RadioButton radioButtonbat, radioButtonghost;
    RadioGroup radioGroup;
    ImageView imageView;
    SeekBar seekBar;
    CheckBox checkBoxChi, checkBoxShui, checkBoxWan;
    RatingBar ratingBar;
    ToggleButton toggleButton;
    String[] a = {"", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState)      {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 变量与控件关联
        radioButtonbat = findViewById(R.id.radioButton3);
        radioButtonghost = findViewById(R.id.radioButton4);
        textView = findViewById(R.id.textView2);
        display = findViewById(R.id.textView);
        buttonRight = findViewById(R.id.button2);
        buttonLeft = findViewById(R.id.button);
        buttonConfirm = findViewById(R.id.button3);
        progressBar = findViewById(R.id.progressBar2);
        editText = findViewById(R.id.editText);
        toggleButton = findViewById(R.id.toggleButton);
        radioGroup = findViewById(R.id.radiogroup);
        aSwitch = findViewById(R.id.switch1);
        imageView = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);
        checkBoxChi = findViewById(R.id.checkBox);
        checkBoxShui = findViewById(R.id.checkBox2);
        checkBoxWan = findViewById(R.id.checkBox3);
        ratingBar = findViewById(R.id.ratingBar);


        // button控件监听方法为setOnClickListener()
        // 在XML文件Button标签下加style="@style/Widget.AppCompat.Button.Borderless"可设置为无边框效果
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextView控件设置显示内容方法
                display.setText(R.string.左);
            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(R.string.右);
            }
        });
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    s = "0";
                }
                progressBar.setProgress(Integer.valueOf(s));
                display.setText(s);
            }
        });



        // Switch控件监听方法为setOnCheckChangListener()
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    display.setText("开");
                } else display.setText("关");
            }

        });


        // RadioButton控件监听方法setOnClickListener()
        radioButtonbat.setOnClickListener(new RadioButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(R.string.bat);
            }
        });
        radioButtonghost.setOnClickListener(new RadioButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(R.string.ghost);
            }
        });



        // RadioGroup将RadioButton放到一个组中可以创造出单选效果
        // RadioGroup控件监听方法为serOnCheckChangeListener()
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton3) imageView.setImageResource(R.drawable.bat);
                else imageView.setImageResource(R.drawable.ghost);
            }
        });



        //SeekBar控件监听方法为setOnSeekBarChangeListener()
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            // 在滑动过程中
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                display.setText(String.valueOf(progress));
            }
            // 滑动开始时
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            // 滑动结束时
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // CheckBox控件监听方法setOnCheckedChangeListener()
        checkBoxChi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) a[0] = "爱吃";
                else a[0] = "";
                String A = a[0] + " " + a[1] + " " + a[2];
                display.setText(A);
            }


        });
        checkBoxShui.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) a[1] = "爱睡";
                else a[1] = "";
                String A = a[0] + " " + a[1] + " " + a[2];
                display.setText(A);
            }
        });
        checkBoxWan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) a[2] = "爱玩";
                else a[2] = "";
                String A = a[0] + " " + a[1] + " " + a[2];
                display.setText(A);
            }
        });



        // RatingBar控件监听方法setOnRatingBarChangeListener()
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });



        // ToggleButton控件监听方法SetOnCheckedChangeListener()
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) display.setText(R.string.Yes);
                else display.setText(R.string.No);
            }
        });
    }
}
