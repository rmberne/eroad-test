package nz.co.eroad.assignment.model;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Rafael Berne
 * @since 30/08/17.
 */
public class VehicleData implements Serializable {

    private DateTime dateTime;
    private Double latitude;
    private Double longitude;
    private String timezone;
    private DateTime localizedDateTime;

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public DateTime getLocalizedDateTime() {
        return localizedDateTime;
    }

    public void setLocalizedDateTime(DateTime localizedDateTime) {
        this.localizedDateTime = localizedDateTime;
    }

}
