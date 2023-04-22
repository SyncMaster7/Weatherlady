package edu.weatherlady.database;

import jakarta.persistence.*;

@Entity
@Table(name = "locationinfo")
public class LocationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int locationId;
    @Column(name = "lon", nullable = false)
    private double lon;
    @Column(name = "lat", nullable = false)
    private double lat;
    @Column(name = "region")
    private String region;
    @Column(name = "country_name", nullable = false)
    private String countryName;
    @Column(name = "city_name", nullable = false)
    private String cityName;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
