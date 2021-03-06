package com.gap.pino_copy.fragment.line;


import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gap.pino_copy.R;
import com.gap.pino_copy.app.AppController;
import com.gap.pino_copy.common.Constants;
import com.gap.pino_copy.db.manager.DatabaseManager;
import com.gap.pino_copy.db.manager.IDatabaseManager;
import com.gap.pino_copy.db.objectmodel.DeviceSetting;
import com.gap.pino_copy.exception.WebServiceException;
import com.gap.pino_copy.service.CoreService;
import com.gap.pino_copy.util.DateUtils;
import com.gap.pino_copy.webservice.MyPostJsonService;


import org.json.JSONException;
import org.json.JSONObject;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinePriceFragment extends Fragment {
    ImageView backIcon;
    String lineId,code;
    private IDatabaseManager databaseManager;
    private CoreService coreService;
    ProgressBar progressBar;
    TextView yearTV,priceCoFinalTV,eCardPriceTV,lineCodeTitleTV;
    String addIcon="line";
    ASync myTask = null;

    public LinePriceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_line_price, container, false);
        init(view);

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.motion, R.anim.motion2);
            }
        });

        String getLineInfo = getArguments().getString("line");
        try {
            JSONObject lineInfoJsonObject = new JSONObject(getLineInfo);
            lineId = lineInfoJsonObject.getString("id");
            code = lineInfoJsonObject.getString("code");
            String rialStr = getActivity().getResources().getString(R.string.lineCode_label);
            lineCodeTitleTV.setText(rialStr + " " +code);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        myTask = new ASync();
        myTask.execute();

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    if (myTask != null && myTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
                        myTask.cancel(true);
                    }
                    getActivity().finish();
                    return true;
                }

                return false;
            }
        });
        return view;
    }

    private void init(View view) {
        backIcon = (ImageView) view.findViewById(R.id.backIcon);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        databaseManager = new DatabaseManager(getActivity());
        coreService = new CoreService(databaseManager);
        yearTV=(TextView)view.findViewById(R.id.year_TV);
        priceCoFinalTV=(TextView)view.findViewById(R.id.priceCoFind_TV);
        eCardPriceTV=(TextView)view.findViewById(R.id.eCardPrice_TV);
        lineCodeTitleTV=(TextView)view.findViewById(R.id.lineCodeTitle_TV);
    }

    private class ASync extends AsyncTask<Void, Void, Void> {
        private String result;
        private String errorMsg;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressBar.setVisibility(View.INVISIBLE);
            if (result != null) {
                try {
                    JSONObject resultJson = new JSONObject(result);
                    if (errorMsg == null && !resultJson.isNull(Constants.SUCCESS_KEY)) {
                        if (!resultJson.isNull(Constants.RESULT_KEY)) {
                            JSONObject jsonObject = resultJson.getJSONObject(Constants.RESULT_KEY);
                            if (!jsonObject.isNull("linePrice")) {
                                JSONObject linePricejsonObject = jsonObject.getJSONObject("linePrice");
                                String rialStr = getActivity().getResources().getString(R.string.rial_label);

                                String getyear = linePricejsonObject.getString("year");
                                yearTV.setText(getyear);

                                String getpriceCoFinal = linePricejsonObject.getString("priceCoFinal");
                                priceCoFinalTV.setText(getpriceCoFinal + " " +rialStr);

                                String geteCardPrice = linePricejsonObject.getString("eCardPrice");
                                eCardPriceTV.setText(geteCardPrice + " " +rialStr);
                            }
                        }
                    } else {
                        if (errorMsg == null) {
                            errorMsg = resultJson.getString(Constants.ERROR_KEY);
                        }
                        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    Log.d("CarUsageFragment", e.getMessage());
                    Toast.makeText(getActivity(), getResources().getString(R.string.Some_error_accor_contact_admin), Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getActivity(), (errorMsg != null) ? errorMsg : getResources().getString(R.string.Some_error_accor_contact_admin), Toast.LENGTH_LONG).show();
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected Void doInBackground(Void... voids) {
            if (isDeviceDateTimeValid()) {
                try {
                    JSONObject jsonObject = new JSONObject();
                    AppController application = (AppController) Objects.requireNonNull(getActivity()).getApplication();
                    jsonObject.put("username", application.getCurrentUser().getUsername());
                    jsonObject.put("tokenPass", application.getCurrentUser().getBisPassword());
                    jsonObject.put("lineId", lineId);

                    MyPostJsonService postJsonService = new MyPostJsonService(databaseManager, getActivity());
                    try {
                        result = postJsonService.sendData("getLinePrice", jsonObject, true);
                    } catch (SocketTimeoutException e) {
                        errorMsg = getResources().getString(R.string.Some_error_accor_contact_admin);
                    } catch (SocketException e) {
                        errorMsg = getResources().getString(R.string.Some_error_accor_contact_admin);
                    } catch (WebServiceException e) {
                        Log.d("CarUsageFragment", e.getMessage());
                    }

                } catch (JSONException e) {
                    Log.d("CarUsageFragment", e.getMessage());
                }
            }
            return null;
        }

        private boolean isDeviceDateTimeValid() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
            try {
                JSONObject jsonObjectParam = new JSONObject();
                MyPostJsonService postJsonService = new MyPostJsonService(databaseManager, getActivity());
                result = postJsonService.sendData("getServerDateTime", jsonObjectParam, true);

                if (result != null) {
                    JSONObject resultJson = new JSONObject(result);
                    if (!resultJson.isNull(Constants.SUCCESS_KEY)) {
                        JSONObject jsonObject = resultJson.getJSONObject(Constants.RESULT_KEY);
                        Date serverDateTime = simpleDateFormat.parse(jsonObject.getString("serverDateTime"));
                        if (DateUtils.isValidDateDiff(new Date(), serverDateTime, Constants.VALID_SERVER_AND_DEVICE_TIME_DIFF)) {
                            DeviceSetting deviceSetting = coreService.getDeviceSettingByKey(Constants.DEVICE_SETTING_KEY_LAST_CHANGE_DATE);
                            if (deviceSetting == null) {
                                deviceSetting = new DeviceSetting();
                                deviceSetting.setKey(Constants.DEVICE_SETTING_KEY_LAST_CHANGE_DATE);
                            }
                            deviceSetting.setValue(simpleDateFormat.format(new Date()));
                            deviceSetting.setDateLastChange(new Date());
                            coreService.saveOrUpdateDeviceSetting(deviceSetting);
                            return true;
                        } else {
                            errorMsg = getResources().getString(R.string.Invalid_Device_Date_Time);
                        }
                    }
                }
            } catch (SocketTimeoutException e) {
                errorMsg = getResources().getString(R.string.Some_error_accor_contact_admin);
            } catch (SocketException e) {
                errorMsg = getResources().getString(R.string.Some_error_accor_contact_admin);
            } catch (JSONException e) {
                errorMsg = getResources().getString(R.string.Some_error_accor_contact_admin);
                Log.d("SyncActivity", e.getMessage());
            } catch (WebServiceException e) {
                errorMsg = getResources().getString(R.string.Some_error_accor_contact_admin);
                Log.d("SyncActivity", e.getMessage());
            } catch (ParseException e) {
                errorMsg = getResources().getString(R.string.Some_error_accor_contact_admin);
                Log.d("SyncActivity", e.getMessage());
            }
            return false;
        }
    }
}
