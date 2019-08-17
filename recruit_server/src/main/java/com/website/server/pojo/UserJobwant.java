package com.website.server.pojo;

public class UserJobwant {
    private Integer id;

    private Integer resumeId;

    private String salaryWant;

    private String placeWant;

    private String postWant;

    private String workTypes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getSalaryWant() {
        return salaryWant;
    }

    public void setSalaryWant(String salaryWant) {
        this.salaryWant = salaryWant == null ? null : salaryWant.trim();
    }

    public String getPlaceWant() {
        return placeWant;
    }

    public void setPlaceWant(String placeWant) {
        this.placeWant = placeWant == null ? null : placeWant.trim();
    }

    public String getPostWant() {
        return postWant;
    }

    public void setPostWant(String postWant) {
        this.postWant = postWant == null ? null : postWant.trim();
    }

    public String getWorkTypes() {
        return workTypes;
    }

    public void setWorkTypes(String workTypes) {
        this.workTypes = workTypes == null ? null : workTypes.trim();
    }
}