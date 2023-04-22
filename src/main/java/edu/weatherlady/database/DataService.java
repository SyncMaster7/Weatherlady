package edu.weatherlady.database;

import jakarta.persistence.*;
import java.util.List;

public class DataService {

    public static void main(String[] args) {

//        truncateTable("locationinfo");

//        addLocation(45.58005, 9.27246, "Europe", "Italy", "Monza");
//        addLocation(43.73785, 7.42585, "Europe", "Monaco", "Monaco");
//        addLocation(52.09001, -1.06921, "Europe", "England", "Silverstone");
//        addLocation(59.43696, 24.75357, "Europe", "Estonia", "Tallinn");

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
            locationInfoList.forEach(locat -> System.out.println(locat.getCityName() + ", " + locat.getCountryName()));
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
            locationInfoList.forEach(locat -> System.out.println(locat.getCityName() + ", " + locat.getCountryName()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

//    public static void truncateTable(String tableName) {
//        EntityManager em = emf.createEntityManager();
//        String strQuery = "truncate table locationinfo";
//
//        TypedQuery<LocationInfo> tq = em.createQuery(strQuery, LocationInfo.class);
//
//        try {
//            tq.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//    }
}
