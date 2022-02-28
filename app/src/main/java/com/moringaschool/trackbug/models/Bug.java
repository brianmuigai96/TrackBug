package com.moringaschool.trackbug.models;

import java.io.Serializable;

public class Bug implements Serializable {
    private String bugName;
    private String bugReporter;
    private String submitDate;
    private String summary;
    private String url;

    public Bug(String bugName, String bugReporter, String submitDate, String summary, String url) {
        this.bugName = bugName;
        this.bugReporter = bugReporter;
        this.submitDate = submitDate;
        this.summary = summary;
        this.url = url;
    }

    public Bug() {
    }

    public String getBugName() {
        return bugName;
    }

    public void setBugName(String bugName) {
        this.bugName = bugName;
    }

    public String getBugReporter() {
        return bugReporter;
    }

    public void setBugReporter(String bugReporter) {
        this.bugReporter = bugReporter;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

