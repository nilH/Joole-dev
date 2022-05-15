package com.itlize.Joole.entity;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "technical_specs")
@Entity
public class TechnicalSpecs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "technical_detail_id")
    private int technicalDetailId;
    @Column(name = "attribute_name")
    private String attributeName;
    private double value;
    private String unit;

    public int getTechnicalDetailId() {
        return technicalDetailId;
    }

    public void setTechnicalDetailId(int technicalDetailId) {
        this.technicalDetailId = technicalDetailId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this){
            return true;
        }
        if(!(obj instanceof TechnicalSpecs)){
            return false;
        }
        TechnicalSpecs technicalSpecs=(TechnicalSpecs) obj;
        return technicalDetailId==technicalSpecs.technicalDetailId && attributeName.equals(technicalSpecs.attributeName) && unit.equals(technicalSpecs.unit) && value==technicalSpecs.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(technicalDetailId,attributeName,value,unit);
    }
}
