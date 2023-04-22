package edu.weatherlady.accuweather;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Connection {
    public static void main(String[] args) throws IOException, ParseException {

        // Accuweather.com registered API
        // API Key = eJBmWYI9s5eY94AEWk221Eq0vZcAwpGH
        // http://dataservice.accuweather.com/currentconditions/v1/{locationKey}

        URL url = new URL("http://dataservice.accuweather.com/currentconditions/v1/127964" +
                "?apikey=eJBmWYI9s5eY94AEWk221Eq0vZcAwpGH&language=et-ee&details=true");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("Houston, we have a problem ... there is no connection." +
                    "Connection response code is " + responseCode);
        } else {

            StringBuilder dataString = new StringBuilder();
            Scanner sc = new Scanner(url.openStream());

            while (sc.hasNext()) {
                dataString.append(sc.nextLine());
            }
            sc.close();

            JSONParser parse = new JSONParser();
            JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(dataString));;

            System.out.println(dataObject.get(0));
        }
    }
}
