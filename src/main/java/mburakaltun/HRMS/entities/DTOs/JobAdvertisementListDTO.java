package mburakaltun.HRMS.entities.DTOs;

import java.util.Date;

public class JobAdvertisementListDTO {
    private String companyName;
    private String jobTitleName;
    private int openPositionCount;
    private Date applicationDeadline;
    private Date publishingDate;

    public JobAdvertisementListDTO(String companyName, String jobTitleName, int openPositionCount, Date applicationDeadline, Date publishingDate) {
        this.companyName = companyName;
        this.jobTitleName = jobTitleName;
        this.openPositionCount = openPositionCount;
        this.applicationDeadline = applicationDeadline;
        this.publishingDate = publishingDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobTitleName() {
        return jobTitleName;
    }

    public int getOpenPositionCount() {
        return openPositionCount;
    }

    public Date getApplicationDeadline() {
        return applicationDeadline;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }
}
