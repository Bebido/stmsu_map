package com.lab.stmsumap;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

public class Point implements KvmSerializable {

    public Point() {
    }

    public Point(String x, String y) {
        this.x = x;
        this.y = y;
    }

    private String x;
    private String y;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public Object getProperty(int index) {
        switch (index) {
            case 0:
                return x;
            case 1:
                return y;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void setProperty(int index, Object value) {
        switch (index) {
            case 0:
                x = value.toString();
                break;
            case 1:
                y = value.toString();
                break;
        }

    }

    @Override
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "x";
                info.namespace = "http://stm.pg.edu.pl/mapWS";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "y";
                info.namespace = "http://stm.pg.edu.pl/mapWS";
                break;
        }

    }
}
