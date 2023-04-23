package edu.weatherlady.database;

import jakarta.persistence.*;
import java.util.List;

public class DataService {

    public static void main(String[] args) {

        addLocation(45.5797149, 9.2347872, "Europe", "Italy", "Monza");
        addLocation(43.7378806, 7.4052529, "Europe", "Monaco", "Monaco");
        addLocation(52.0899713, -1.0263459, "Europe", "England", "Silverstone");
        addLocation(50.4543583,5.9419142, "Europe", "Belgium", "Francorchamps");
        addLocation(45.5593046,-73.876681, "North America", "Canada", "Montreal");
        addLocation(-23.6814346,-46.924952, "South America", "Brazil", "Sao Paulo");
        addLocation(49.3314173,8.488602, "Europe", "Germany", "Hockenheim");
        addLocation(47.6035274,19.2201059, "Europe", "Hungary", "Mogyorod");
        addLocation(47.2177609,14.7422354, "Europe", "Austria", "Spielberg");
        addLocation(41.5517386,2.2361661, "Europe", "Spain", "Montmelo");
        addLocation(52.380545,4.525128, "Europe", "Netherlands", "Zandvoort");
        addLocation(34.8935205,136.4364729, "Asia", "Japan", "Suzuka");
        addLocation(44.3605756,11.6673442, "Europe", "Italy", "Imola");
        addLocation(-37.9696432,144.3937484, "Australia", "Australia", "Melbourne");
        addLocation(19.3208489,-99.4822713, "South America", "Mexico", "Mexico City");
        addLocation(26.0336078,50.5065873, "Middle East", "Bahrein", "Sakhir");
        addLocation(21.4504394, 38.8814922, "Middle East", "Saudi Arabia", "Jeddah");
        addLocation(24.3870541, 54.3938092, "Middle East", "United Arab Emirates", "Abu Dhabi");
        addLocation(40.394737, 49.6901509, "Caucasus", "Azerbaijan", "Baku");
        addLocation(59.4717637,24.5734371, "Europe", "Estonia", "Tallinn");


//        getLocationInfo(1);
//        getAllLocationInfo();
    }

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("weatherlady");

    public static void addLocation(double lat, double lon, String region, String countryName, String cityName) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;

        try  {
            et = em.getTransaction();
            et.begin();

            LocationInfo location = new LocationInfo();
            location.setLat(lat);
            location.setLon(lon);
            location.setRegion(region);
            location.setCountryName(countryName);
            location.setCityName(cityName);

            em.persist(location);
            et.commit();

        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void getLocationInfo(int id) {
        EntityManager em = emf.createEntityManager();
        String strQuery = "select c from LocationInfo c where c.id=" + id;

        TypedQuery<LocationInfo> tq = em.createQuery(strQuery, LocationInfo.class);
        List<LocationInfo> locationInfoList;

        try {
            locationInfoList = tq.getResultList();
            locationInfoList.forEach(locat -> System.out.println(locat.getLocationId() + ". " + locat.getCityName() +
                    ", " + locat.getCountryName() + " @ " + locat.getLat() + ", " + locat.getLon()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void getAllLocationInfo() {

        EntityManager em = emf.createEntityManager();
        String strQuery = "select c from LocationInfo c where c.id is not null";

        TypedQuery<LocationInfo> tq = em.createQuery(strQuery, LocationInfo.class);
        List<LocationInfo> locationInfoList;

        try {
            locationInfoList = tq.getResultList();
            locationInfoList.forEach(locat -> System.out.println(locat.getLocationId() + ". " + locat.getCityName() +
                    ", " + locat.getCountryName() + " @ " + locat.getLat() + ", " + locat.getLon()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
