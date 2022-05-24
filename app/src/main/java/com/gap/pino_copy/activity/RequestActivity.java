package com.gap.pino_copy.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.gap.pino_copy.R;
import com.gap.pino_copy.util.GeneralLogic;
import com.gap.pino_copy.widget.persiandatepicker.PersianDatePicker;
import com.jaiselrahman.filepicker.activity.DirSelectActivity;
import com.jaiselrahman.filepicker.activity.FilePickerActivity;
import com.jaiselrahman.filepicker.activity.PickFile;
import com.jaiselrahman.filepicker.config.Configurations;
import com.jaiselrahman.filepicker.model.MediaFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RequestActivity extends AppCompatActivity {

    private AppCompatTextView txt_year, txt_month, txt_day, txt_gender, txt_status, txt_marriageYear, txt_marriageMonth, txt_marriageDay, txt_dateMarriageTitle;
    private EditText txt_nationalCode;
    private LinearLayout marriageLinearLayout;
    private RelativeLayout layout_attach;
    private ArrayList<MediaFile> mediaFiles = new ArrayList<>();
    private final static int FILE_REQUEST_CODE = 1;
    private static final int MY_PERMISSIONS_REQUEST = 100;
    private int fileType = 0;


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



        final ActivityResultLauncher<Configurations> pickImage = registerForActivityResult(new PickFile().throughDir(true), new ActivityResultCallback<List<MediaFile>>() {
            @Override
            public void onActivityResult(List<MediaFile> result) {

                System.out.println("=====result====" + result);
                if (result != null) {
                    setMediaFiles(result);
                } else
                    Toast.makeText(RequestActivity.this, "Image not selected", Toast.LENGTH_SHORT).show();
            }
        });

        layout_attach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAttachDialog(pickImage);
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

    private void showAttachDialog(ActivityResultLauncher<Configurations> pickImage) {

        // Create custom dialog object
        final Dialog dialog = new Dialog(RequestActivity.this);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        // set values for custom dialog components - text, image and button
        TextView cameraVT = (TextView) dialog.findViewById(R.id.camera_VT);
        TextView galleryVT = (TextView) dialog.findViewById(R.id.gallery_VT);
        TextView fileVT = (TextView) dialog.findViewById(R.id.file_VT);
        RelativeLayout closeIcon = (RelativeLayout) dialog.findViewById(R.id.closeIcon);
        dialog.show();

        cameraVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImage.launch(new Configurations.Builder()
                        .setCheckPermission(true)
                        .setSelectedMediaFiles(mediaFiles)
                        .enableImageCapture(true)
                        .setShowVideos(false)
                        .setSkipZeroSizeFiles(true)
                        .setSingleChoiceMode(true)
                        .build());
                dialog.dismiss();
            }
        });

        fileVT.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View view) {
                // fileIntent();

                Intent intent = new Intent(RequestActivity.this, DirSelectActivity.class);
                intent.putExtra(DirSelectActivity.CONFIGS, new Configurations.Builder()
                        .setCheckPermission(true)
                        .setSelectedMediaFiles(mediaFiles)
                        .setShowFiles(true)
                        .setShowImages(true)
                        .setShowAudios(false)
                        .setShowVideos(false)
                        .setIgnoreNoMedia(false)
                        .enableVideoCapture(false)
                        .enableImageCapture(true)
                        .setIgnoreHiddenFile(false)
                        .setSingleChoiceMode(true)
                        .setTitle("Select a file")
                        .build());
                startActivityForResult(intent, FILE_REQUEST_CODE);

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

    private void setMediaFiles(List<MediaFile> mediaFilesParam) {
        this.mediaFiles.clear();
        this.mediaFiles.addAll(mediaFilesParam);

        for (MediaFile mediaFile : this.mediaFiles) {
            System.out.println("getName=====" + mediaFile.getName());
            System.out.println("getPath=====" + mediaFile.getPath());
            System.out.println("getSize=====" + mediaFile.getSize());
            System.out.println("getUri=====" + mediaFile.getUri());
            System.out.println("getMediaType=====" + mediaFile.getMediaType());
            fileType = mediaFile.getMediaType();

            // sendChatMessageAttachFile(mediaFile.getPath());
        }

        // fileListAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_REQUEST_CODE
                && resultCode == RESULT_OK
                && data != null) {
            List<MediaFile> mediaFiles = data.<MediaFile>getParcelableArrayListExtra(FilePickerActivity.MEDIA_FILES);
            if (mediaFiles != null) {

                setMediaFiles(mediaFiles);

            } else {
                Toast.makeText(RequestActivity.this, "Image not selected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}