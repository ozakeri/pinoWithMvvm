package com.gap.pino_copy.util.volly;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseBean {
    @SerializedName("SUCCESS")
    @Expose
    public String sUCCESS;
    @SerializedName("RESULT")
    @Expose
    public RESULTBean rESULT;
}
