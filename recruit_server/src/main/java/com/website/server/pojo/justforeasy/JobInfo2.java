package com.website.server.pojo.justforeasy;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class JobInfo2 {
    private Integer jId;

    private String jName;

    private String jCharacter;

    private String jk2Name;

    private Integer jMlow;

    private Integer jMhigh;

    private String jExperience;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jDate;

    private Integer jNum;

    private String jLoc;

    private String jReq;

    private String jDes;

    private String jBenefit;

    private Integer cId;

    private String jkName;

    private String jk1Name;

    public JobInfo2() {
    }

    public JobInfo2(Integer jId, String jName, String jCharacter, String jk2Name, Integer jMlow, Integer jMhigh, String jExperience, Date jDate, Integer jNum, String jLoc, String jReq, String jDes, String jBenefit, Integer cId, String jkName, String jk1Name) {
        this.jId = jId;
        this.jName = jName;
        this.jCharacter = jCharacter;
        this.jk2Name = jk2Name;
        this.jMlow = jMlow;
        this.jMhigh = jMhigh;
        this.jExperience = jExperience;
        this.jDate = jDate;
        this.jNum = jNum;
        this.jLoc = jLoc;
        this.jReq = jReq;
        this.jDes = jDes;
        this.jBenefit = jBenefit;
        this.cId = cId;
        this.jkName = jkName;
        this.jk1Name = jk1Name;
    }

}
