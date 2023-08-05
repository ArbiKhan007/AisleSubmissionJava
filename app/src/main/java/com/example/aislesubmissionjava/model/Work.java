
package com.example.aislesubmissionjava.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Work {

    @SerializedName("industry_v1")
    @Expose
    private IndustryV1 industryV1;
    @SerializedName("monthly_income_v1")
    @Expose
    private Object monthlyIncomeV1;
    @SerializedName("experience_v1")
    @Expose
    private ExperienceV1 experienceV1;
    @SerializedName("highest_qualification_v1")
    @Expose
    private HighestQualificationV1 highestQualificationV1;
    @SerializedName("field_of_study_v1")
    @Expose
    private FieldOfStudyV1 fieldOfStudyV1;

    public IndustryV1 getIndustryV1() {
        return industryV1;
    }

    public void setIndustryV1(IndustryV1 industryV1) {
        this.industryV1 = industryV1;
    }

    public Object getMonthlyIncomeV1() {
        return monthlyIncomeV1;
    }

    public void setMonthlyIncomeV1(Object monthlyIncomeV1) {
        this.monthlyIncomeV1 = monthlyIncomeV1;
    }

    public ExperienceV1 getExperienceV1() {
        return experienceV1;
    }

    public void setExperienceV1(ExperienceV1 experienceV1) {
        this.experienceV1 = experienceV1;
    }

    public HighestQualificationV1 getHighestQualificationV1() {
        return highestQualificationV1;
    }

    public void setHighestQualificationV1(HighestQualificationV1 highestQualificationV1) {
        this.highestQualificationV1 = highestQualificationV1;
    }

    public FieldOfStudyV1 getFieldOfStudyV1() {
        return fieldOfStudyV1;
    }

    public void setFieldOfStudyV1(FieldOfStudyV1 fieldOfStudyV1) {
        this.fieldOfStudyV1 = fieldOfStudyV1;
    }

}
