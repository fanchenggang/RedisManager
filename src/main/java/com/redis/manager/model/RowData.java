package com.redis.manager.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author: FanChengGang
 * @date: 2019-10-09 10:32
 * @describe: TODO
 **/
public  class RowData {
    private final SimpleIntegerProperty index;
    private final SimpleStringProperty value;

    public RowData(Integer index, String value){
        this.index = new SimpleIntegerProperty(index);
        this.value = new SimpleStringProperty(value);
    }

    public int getIndex() {
        return index.get();
    }

    public SimpleIntegerProperty indexProperty() {
        return index;
    }

    public void setIndex(int index) {
        this.index.set(index);
    }

    public String getValue() {
        return value.get();
    }

    public SimpleStringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }
}
