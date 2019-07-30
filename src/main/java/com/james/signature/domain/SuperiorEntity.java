package com.james.signature.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "superior", schema = "sign")
public class SuperiorEntity {
    private int id;
    private String managementType;
    private String description;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "management_type")
    public String getManagementType() {
        return managementType;
    }

    public void setManagementType(String managementType) {
        this.managementType = managementType;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperiorEntity that = (SuperiorEntity) o;
        return id == that.id &&
                Objects.equals(managementType, that.managementType) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, managementType, description);
    }
}
