package org.jjzhu.springmvc.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by hzzhujiajun on 2017/7/11.
 */
public class Spittle {

    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitude;
    public Spittle(String message, Date time){
        this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double longitude, Double latitude){
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object obj){
        return EqualsBuilder.reflectionEquals(this, obj, false, null,  new String[]{"id", "time"});
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this, new String[]{"id", "time"});
    }
}
