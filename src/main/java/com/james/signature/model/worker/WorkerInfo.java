package com.james.signature.model.worker;

public class WorkerInfo {
    private int id;
    private String name;
    private String tel;
    private String email;
    private Integer age;
    private String hireDate;
    private Integer isActive;

    public WorkerInfo() {
    }

    public WorkerInfo(int id, String name, String tel, String email, Integer age, String hireDate, Integer isActive) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.age = age;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
