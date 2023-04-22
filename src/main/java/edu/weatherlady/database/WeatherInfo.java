package edu.weatherlady.database;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "weatherinfo")
public class WeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;
    @Column(name = "request_date")
    private Date requestDate;
    @Column(name = "city")
    private String city;
    @Column(name = "location")
    private String location;
    @Column(name = "Temperature")
    private float temperature;
    @Column(name = "RealFeelTemperature")
    private float realFeelTemperature;
    @Column(name = "RelativeHumidity")
    private float relativeHumidity;
    @Column(name = "DewPoint")
    private float dewPoint;
    @Column(name = "WindSpeed")
    private float windSpeed;
    @Column(name = "UVIndex")
    private int uvIndex;
    @Column(name = "UVIndexText")
    private String uvIndexText;
    @Column(name = "Visibility")
    private float visibility;
    @Column(name = "Pressure")
    private float pressure;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getRealFeelTemperature() {
        return realFeelTemperature;
    }

    public void setRealFeelTemperature(float realFeelTemperature) {
        this.realFeelTemperature = realFeelTemperature;
    }

    public float getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(float relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public float getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(float dewPoint) {
        this.dewPoint = dewPoint;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getUvIndexText() {
        return uvIndexText;
    }

    public void setUvIndexText(String uvIndexText) {
        this.uvIndexText = uvIndexText;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
