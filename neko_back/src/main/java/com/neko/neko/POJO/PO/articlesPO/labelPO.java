package com.neko.neko.POJO.PO.articlesPO;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class labelPO implements Serializable {

    private int id;
    private String label;
    private String labelIntroduce;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelIntroduce() {
        return labelIntroduce;
    }

    public void setLabelIntroduce(String labelIntroduce) {
        this.labelIntroduce = labelIntroduce;
    }

    @Override
    public String toString() {
        return "labelPO{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", labelIntroduce='" + labelIntroduce + '\'' +
                '}';
    }
}
