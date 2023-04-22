package edu.weatherlady.database;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "locationinfo")
public class LocationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private UUID locationId;
    @Column(name = "lon", nullable = false)
    private float lon;
    @Column(name = "lat", nullable = false)
    private float lat;
    @Column(name = "region")
    private String region;
    @Column(name = "country_name", nullable = false)
    private String countryName;

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
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
}
