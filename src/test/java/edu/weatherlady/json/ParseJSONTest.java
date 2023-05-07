//package edu.weatherlady.json;
//
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class ParseJSONTest {
//    private HTTPWeather httpWeather = null;
//    LocationRepository locationRepository;
//
//    @Order(1)
//    @Test
//    public void testAddLocation() throws SQLException {
//        assertNotNull(locationRepository);
//        locationRepository.addLocation(city, country, region, lon, lat);
//    }
//
//    @Order(2)
//    @Test
//    public void testGetAllLocations() throws SQLException {
//        List<Location> locations = locationRepository.getAll();
//        assertNotNull(locations);
//        assertTrue(locations.size() > 0);
//    }
//    final HTTPWeather httpWeather = new HTTPWeather(AcceessKey.one, location.get(0).getCity());
//
//}
