package com.gap.pino_copy.util.volly.attach;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SavedAttachFile {
    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("totalReceivedBytes")
    @Expose
    public Integer totalReceivedBytes;
}
