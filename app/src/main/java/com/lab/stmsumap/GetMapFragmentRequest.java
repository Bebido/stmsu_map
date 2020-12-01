package com.lab.stmsumap;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

public class GetMapFragmentRequest implements KvmSerializable {

    public GetMapFragmentRequest() {
        pixelTopLeftCorner = new Point("0", "0");
        pixelBottomRightCorner = new Point("1000", "1000");
    }

    public GetMapFragmentRequest(Point pixelTopLeftCorner, Point pixelBottomRightCorner, Point geoTopLeftCorner, Point geoBottomRightCorner) {
        this.pixelTopLeftCorner = pixelTopLeftCorner;
        this.pixelBottomRightCorner = pixelBottomRightCorner;
        this.geoTopLeftCorner = geoTopLeftCorner;
        this.geoBottomRightCorner = geoBottomRightCorner;
    }

    protected Point pixelTopLeftCorner;
    protected Point pixelBottomRightCorner;
    protected Point geoTopLeftCorner;
    protected Point geoBottomRightCorner;

    public Point getPixelTopLeftCorner() {
        return pixelTopLeftCorner;
    }

    public void setPixelTopLeftCorner(Point pixelTopLeftCorner) {
        this.pixelTopLeftCorner = pixelTopLeftCorner;
    }

    public Point getPixelBottomRightCorner() {
        return pixelBottomRightCorner;
    }

    public void setPixelBottomRightCorner(Point pixelBottomRightCorner) {
        this.pixelBottomRightCorner = pixelBottomRightCorner;
    }

    public Point getGeoTopLeftCorner() {
        return geoTopLeftCorner;
    }

    public void setGeoTopLeftCorner(Point geoTopLeftCorner) {
        this.geoTopLeftCorner = geoTopLeftCorner;
    }

    public Point getGeoBottomRightCorner() {
        return geoBottomRightCorner;
    }

    public void setGeoBottomRightCorner(Point geoBottomRightCorner) {
        this.geoBottomRightCorner = geoBottomRightCorner;
    }

    @Override
    public Object getProperty(int index) {
        switch (index) {
            case 0:
                return pixelTopLeftCorner;
            case 1:
                return pixelBottomRightCorner;
            case 2:
                return geoTopLeftCorner;
            case 3:
                return geoBottomRightCorner;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void setProperty(int index, Object value) {
        switch (index) {
            case 0:
                pixelTopLeftCorner = (Point) value;
                break;
            case 1:
                pixelBottomRightCorner = (Point) value;
                break;
            case 2:
                geoTopLeftCorner = (Point) value;
                break;
            case 3:
                geoBottomRightCorner = (Point) value;
                break;
        }
    }

    @Override
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "pixelTopLeftCorner";
                info.namespace = "http://stm.pg.edu.pl/mapWS";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "pixelBottomRightCorner";
                info.namespace = "http://stm.pg.edu.pl/mapWS";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "geoTopLeftCorner";
                info.namespace = "http://stm.pg.edu.pl/mapWS";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "geoBottomRightCorner";
                info.namespace = "http://stm.pg.edu.pl/mapWS";
                break;
            default:
                break;
        }
    }
}
