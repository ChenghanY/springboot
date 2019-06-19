package com.james.signature.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin_user", schema = "sign", catalog = "")
public class AdminUserEntity {
    private int id;
    private String userName;
    private String userPwd;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_pwd")
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminUserEntity that = (AdminUserEntity) o;
        return id == that.id &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userPwd, that.userPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPwd);
    }
}
