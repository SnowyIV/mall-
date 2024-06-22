package com.geekaca.employee.pojo;

public class Job {
    private Integer id;
    private String jName;
    private String description;

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jname='" + jName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Job() {
        this.id = id;
        this.jName = jName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJname() {
        return jName;
    }

    public void setJname(String jname) {
        this.jName = jname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
