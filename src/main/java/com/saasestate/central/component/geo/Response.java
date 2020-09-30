package com.saasestate.central.component.geo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
public class Response {
    public String status;
    public Location[] result;

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Location {
        public long id;
        public String placeId;
        public String name;
        public String type;
        public double lat;
        public double lng;
    }



}
