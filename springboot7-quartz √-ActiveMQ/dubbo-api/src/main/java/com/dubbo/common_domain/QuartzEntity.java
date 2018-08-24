package com.dubbo.common_domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DonY15
 * @description
 * @create 2018/8/24
 */
public class QuartzEntity implements Serializable {
    private String jobName;
    private String jobGroupName;
    private String triggerName;
    private String triggerGroupName;
    private String cron;
    private String params;

    public QuartzEntity() {
    }


    @Override
    public String toString() {
        return "QuartzNames{" +
                "jobName='" + jobName + '\'' +
                ", jobGroupName='" + jobGroupName + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", triggerGroupName='" + triggerGroupName + '\'' +
                ", cron='" + cron + '\'' +
                ", params=" + params +
                '}';
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}
