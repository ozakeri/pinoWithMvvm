package com.gap.pino_copy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gap.pino_copy.R;
import com.gap.pino_copy.app.AppController;
import com.gap.pino_copy.common.Constants;
import com.gap.pino_copy.db.manager.DatabaseManager;
import com.gap.pino_copy.db.manager.IDatabaseManager;
import com.gap.pino_copy.db.objectmodel.DeviceSetting;
import com.gap.pino_copy.db.objectmodel.User;
import com.gap.pino_copy.service.CoreService;
import com.gap.pino_copy.service.Services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private Services services;
    private boolean userIsNull = false;
    private SharedPreferences.Editor editor;
    private CoreService coreService;
    private String action = null;
    private String groupId = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        coreService = new CoreService(new DatabaseManager(this));

        action = AppController.getInstance().getSharedPreferences().getString("action", "");
        groupId = AppController.getInstance().getSharedPreferences().getString("groupId", "");

        SharedPreferences.Editor editor = AppController.getInstance().getSharedPreferences().edit();
        editor.putString("action", null);
        editor.putString("groupId", null);
        editor.apply();
        AppController.getInstance().setNewMessage(false);

        IDatabaseManager databaseManager = new DatabaseManager(this);
        List<User> userList = databaseManager.listUsers();

        if (!userList.isEmpty()) {
            userIsNull = false;
        } else {
            userIsNull = true;
        }


        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    if (!userIsNull) {
                        if (isConnected()) {
                           // services = new Services(getApplicationContext());

                            /*if (action.equals("newChatMessage") && groupId != null) {

                                AppController.getInstance().setNewMessage(true);
                                services.getChatMessageList();

                                ChatGroup tmp = new ChatGroup();
                                tmp.setServerGroupId(Long.valueOf(groupId));
                                ChatGroup chatGroup = coreService.getChatGroupByServerGroupId(tmp);
                                if (chatGroup != null) {
                                    services.getUserPermissionList();
                                    services.getDocumentUserList();
                                    Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                                    intent.putExtra("chatGroupId", chatGroup.getId());
                                    intent.putExtra("chatGroupName", chatGroup.getName());
                                    startActivity(intent);
                                    finish();
                                }
                                return;
                            }*/

                            //services.getUserPermissionList();
                           // services.getDocumentUserList();
                            //services.getLastDocumentVersion();
                            //services.getChatMessageList();
                            //services.sendChatMessageReadReport();


                            sleep(4 * 1000);
                            Intent i = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(i);
                     /*       Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                            startActivity(i);
                            finish();*/

                           // services.resumeChatMessageAttachFileList();
                           // services.resumeAttachFileList("");
                           // services.getChatGroupList();
                           // services.getChatMessageStatusList();
                            // services.getChatGroupMemberList();

                        } else {
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.Some_error_accor_contact_admin), Toast.LENGTH_LONG).show();
                        }
                    } else {

                        sleep(4 * 1000);
                        Intent i = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(i);
                       /* Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                        startActivity(i);
                        finish();*/
                    }

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();

    }

    public boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


    private DeviceSetting getDeviceSettingByKey(String key) {
        DeviceSetting deviceSetting = coreService.getDeviceSettingByKey(key);
        if (deviceSetting == null) {
            deviceSetting = new DeviceSetting();
            deviceSetting.setKey(key);
        }
        deviceSetting.setBeforeSyncDate(new Date());
        return deviceSetting;
    }

    private void updateDeviceSettingByKey(DeviceSetting deviceSetting) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
        deviceSetting.setValue(simpleDateFormat.format(deviceSetting.getBeforeSyncDate()));
        deviceSetting.setDateLastChange(deviceSetting.getBeforeSyncDate());
        coreService.saveOrUpdateDeviceSetting(deviceSetting);
    }
}
