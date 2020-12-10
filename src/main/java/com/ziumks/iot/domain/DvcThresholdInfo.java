package com.ziumks.iot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dvc_threshold_info", schema = "iot_web")
public class DvcThresholdInfo {
    private static final long serialVersionUID = -2861675854717593136L;

    @Id
    @Column(name = "threshold_id")
    private String thresholdId;

    @Column(name = "dvc_pk_id")
    private String dvcPkId;

    @Column(name = "stream_pk_id")
    private String streamPkId;

    @Column(name = "min_val")
    private String minVal;

    @Column(name = "max_val")
    private String maxVal;

    @Column(name = "color")
    private String color;

    @Column(name = "order_idx")
    private int orderIdx;

    public String getThresholdId() {
        return thresholdId;
    }

    public void setThresholdId(String thresholdId) {
        this.thresholdId = thresholdId;
    }

    public String getDvcPkId() {
        return dvcPkId;
    }

    public void setDvcPkId(String dvcPkId) {
        this.dvcPkId = dvcPkId;
    }

    public String getStreamPkId() {
        return streamPkId;
    }

    public void setStreamPkId(String streamPkId) {
        this.streamPkId = streamPkId;
    }

    public String getMinVal() {
        return minVal;
    }

    public void setMinVal(String minVal) {
        this.minVal = minVal;
    }

    public String getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(String maxVal) {
        this.maxVal = maxVal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOrderIdx() {
        return orderIdx;
    }

    public void setOrderIdx(int orderIdx) {
        this.orderIdx = orderIdx;
    }
}
