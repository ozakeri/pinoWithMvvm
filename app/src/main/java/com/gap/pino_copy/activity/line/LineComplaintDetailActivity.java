package com.gap.pino_copy.activity.line;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.gap.pino_copy.R;
import com.gap.pino_copy.common.HejriUtil;
import com.gap.pino_copy.webservice.GetJsonService;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LineComplaintDetailActivity extends AppCompatActivity {
    private String result;
    private String jsonData;
    TextView requestTypeTV, requestDateTV, requestNoTV, requestDescriptionTV, complaintBaseSubjectTV;
    ImageView backIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_line_complaint_detail);
        Bundle bundle = getIntent().getExtras();
        jsonData = bundle.getString("complaintList");
        init();

        new ResultTask().execute();

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void init() {
        requestTypeTV = (TextView) findViewById(R.id.requestType_TV);
        requestDateTV = (TextView) findViewById(R.id.requestDate_TV);
        backIcon = (ImageView) findViewById(R.id.back_Icon);
        requestNoTV = (TextView) findViewById(R.id.requestNo_TV);
        requestDescriptionTV = (TextView) findViewById(R.id.requestDescription_TV);
        complaintBaseSubjectTV = (TextView) findViewById(R.id.complaintBaseSubject_TV);
    }


    ////******get complaintList from bundle*******////
    private class ResultTask extends AsyncTask<Void, Void, Void> {

        ResultTask() {

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {

            GetJsonService getJson = new GetJsonService();
            result = getJson.JsonReguest("");
            return null;
        }


        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            // progress.setVisibility(View.INVISIBLE);

            result = jsonData;
            //Toast.makeText(getActivity(),result,Toast.LENGTH_LONG).show();
            System.out.println("result==" + result);
            if (result != null) {
                try {
                    JSONObject resultJson = new JSONObject(result);
                    if (!resultJson.isNull("requestType_text")) {
                        requestTypeTV.setText(resultJson.getString("requestType_text"));
                    } else {
                        requestTypeTV.setText("---");
                    }

                    if (!resultJson.isNull("requestDescription")) {
                        requestDescriptionTV.setText(resultJson.getString("requestDescription"));
                    } else {
                        requestDescriptionTV.setText("---");
                    }

                    if (!resultJson.isNull("complaintBaseSubject")) {
                        complaintBaseSubjectTV.setText(resultJson.getString("complaintBaseSubject"));
                    } else {
                        complaintBaseSubjectTV.setText("---");
                    }

                    if (!resultJson.isNull("requestDate")) {
                        String strStartDate = resultJson.getString("requestDate");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date startDate = simpleDateFormat.parse(strStartDate);
                        String hejriStartDate = HejriUtil.chrisToHejri(startDate);
                        requestDateTV.setText(hejriStartDate);
                    } else {
                        requestDateTV.setText("---");
                    }


                    if (!resultJson.isNull("requestNo")) {
                        requestNoTV.setText(resultJson.getString("requestNo"));
                    } else {
                        requestNoTV.setText("---");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
