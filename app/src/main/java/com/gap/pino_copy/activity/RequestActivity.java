package com.gap.pino_copy.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.gap.pino_copy.R;
import com.gap.pino_copy.util.GeneralLogic;
import com.gap.pino_copy.widget.persiandatepicker.PersianDatePicker;

import java.util.Objects;

public class RequestActivity extends AppCompatActivity {

    private AppCompatTextView txt_year, txt_month, txt_day, txt_gender, txt_status, txt_marriageYear, txt_marriageMonth, txt_marriageDay, txt_dateMarriageTitle;
    private EditText txt_nationalCode;
    private LinearLayout marriageLinearLayout;
    private RelativeLayout layout_attach;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        txt_nationalCode = findViewById(R.id.txt_nationalCode);
        txt_year = findViewById(R.id.txt_year);
        txt_month = findViewById(R.id.txt_month);
        txt_day = findViewById(R.id.txt_day);
        txt_day = findViewById(R.id.txt_day);
        txt_gender = findViewById(R.id.txt_gender);
        txt_status = findViewById(R.id.txt_status);
        RelativeLayout marriageDate = findViewById(R.id.marriageDate);
        txt_dateMarriageTitle = findViewById(R.id.txt_dateMarriageTitle);
        txt_marriageYear = findViewById(R.id.txt_marriageYear);
        txt_marriageMonth = findViewById(R.id.txt_marriageMonth);
        txt_marriageDay = findViewById(R.id.txt_marriageDay);
        marriageLinearLayout = findViewById(R.id.marriageLinearLayout);
        layout_attach = findViewById(R.id.layout_attach);

        txt_dateMarriageTitle.setVisibility(View.GONE);
        marriageLinearLayout.setVisibility(View.GONE);

        txt_marriageYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersianDatePicker.showDatePickerCopy(RequestActivity.this, (LayoutInflater) Objects.requireNonNull(getSystemService(Context.LAYOUT_INFLATER_SERVICE)), txt_marriageYear, "year");
                PersianDatePicker.monthNumberPicker.setVisibility(View.GONE);
                PersianDatePicker.dayNumberPicker.setVisibility(View.GONE);
                PersianDatePicker.monthNumberPicker.setVisibility(View.GONE);
            }
        });

        txt_marriageMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersianDatePicker.showDatePickerCopy(RequestActivity.this, (LayoutInflater) Objects.requireNonNull(getSystemService(Context.LAYOUT_INFLATER_SERVICE)), txt_marriageMonth, "month");
                PersianDatePicker.monthNumberPicker.setVisibility(View.VISIBLE);
                PersianDatePicker.dayNumberPicker.setVisibility(View.GONE);
                PersianDatePicker.yearNumberPicker.setVisibility(View.GONE);
            }
        });

        txt_marriageDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersianDatePicker.showDatePickerCopy(RequestActivity.this, (LayoutInflater) Objects.requireNonNull(getSystemService(Context.LAYOUT_INFLATER_SERVICE)), txt_marriageDay, "day");
                PersianDatePicker.monthNumberPicker.setVisibility(View.GONE);
                PersianDatePicker.dayNumberPicker.setVisibility(View.VISIBLE);
                PersianDatePicker.yearNumberPicker.setVisibility(View.GONE);
            }
        });

        txt_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersianDatePicker.showDatePickerCopy(RequestActivity.this, (LayoutInflater) Objects.requireNonNull(getSystemService(Context.LAYOUT_INFLATER_SERVICE)), txt_year, "year");
                PersianDatePicker.monthNumberPicker.setVisibility(View.GONE);
                PersianDatePicker.dayNumberPicker.setVisibility(View.GONE);
                PersianDatePicker.monthNumberPicker.setVisibility(View.GONE);
            }
        });

        txt_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersianDatePicker.showDatePickerCopy(RequestActivity.this, (LayoutInflater) Objects.requireNonNull(getSystemService(Context.LAYOUT_INFLATER_SERVICE)), txt_month, "month");
                PersianDatePicker.monthNumberPicker.setVisibility(View.VISIBLE);
                PersianDatePicker.dayNumberPicker.setVisibility(View.GONE);
                PersianDatePicker.yearNumberPicker.setVisibility(View.GONE);
            }
        });

        txt_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersianDatePicker.showDatePickerCopy(RequestActivity.this, (LayoutInflater) Objects.requireNonNull(getSystemService(Context.LAYOUT_INFLATER_SERVICE)), txt_day, "day");
                PersianDatePicker.monthNumberPicker.setVisibility(View.GONE);
                PersianDatePicker.dayNumberPicker.setVisibility(View.VISIBLE);
                PersianDatePicker.yearNumberPicker.setVisibility(View.GONE);
            }
        });

        txt_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(" زن ", " مرد ", "gender");
            }
        });

        txt_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(" متاهل ", " مجرد ", "married");
            }
        });

        findViewById(R.id.backIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.btn_sendRequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nationalCodeIsValid(txt_nationalCode.getText().toString())) {

                } else {

                }
            }
        });
    }

    public void showDialog(String title1, String title2, String str_txt) {
        Dialog dialog = new Dialog(RequestActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_request_activity);
        TextView txt_title_one = (TextView) dialog.findViewById(R.id.txt_title_one);
        TextView txt_title_two = (TextView) dialog.findViewById(R.id.txt_title_two);
        RelativeLayout closeIcon = (RelativeLayout) dialog.findViewById(R.id.closeIcon);

        txt_title_one.setText(title1);
        txt_title_two.setText(title2);
        dialog.show();


        txt_title_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str_txt.equals("gender")) {
                    txt_gender.setText(title1);
                } else {
                    txt_status.setText(title1);
                    txt_dateMarriageTitle.setVisibility(View.VISIBLE);
                    marriageLinearLayout.setVisibility(View.VISIBLE);
                }

                dialog.dismiss();
            }
        });

        txt_title_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str_txt.equals("gender")) {
                    txt_gender.setText(title2);
                } else {
                    txt_status.setText(title2);
                    txt_dateMarriageTitle.setVisibility(View.GONE);
                    marriageLinearLayout.setVisibility(View.GONE);
                }

                dialog.dismiss();
            }
        });

        closeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    protected Boolean nationalCodeIsValid(String nationalCode) {
        Boolean result = true;
        if (!GeneralLogic.nationalCodeValidate(nationalCode)) {
            result = false;
        }
        return result;
    }
}