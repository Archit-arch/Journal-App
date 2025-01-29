package net.engineeringdigest.jounalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

import java.util.List;
@Getter
@Setter
public class WeatherResponse{
    public Current current;
    @Getter
    @Setter
    public class Current{

        private int temperature;
        @JsonProperty("weather_code")
        private int weatherCode;

        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;
        private int wind_speed;

        public int feelslike;

    }

}







