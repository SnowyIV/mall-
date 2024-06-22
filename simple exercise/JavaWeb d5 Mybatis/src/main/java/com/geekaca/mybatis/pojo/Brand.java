package com.geekaca.mybatis.pojo;

public class Brand {
    private Integer id;
    private String bdName;
    private String companyName;
    private Integer ordered;
    private String description;
    private Integer brandStatus;

    public Brand(Integer id, String bdName, String companyName, Integer ordered, String description, Integer brandStatus) {
        this.id = id;
        this.bdName = bdName;
        this.companyName = companyName;
        this.ordered = ordered;
        this.description = description;
        this.brandStatus = brandStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBrandStatus() {
        return brandStatus;
    }

    public void setBrandStatus(Integer brandStatus) {
        this.brandStatus = brandStatus;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + bdName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + brandStatus +
                '}';
    }
}
