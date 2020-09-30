package com.saasestate.central.component.geo;

public interface GeoCoder {
    public Response.Location[] search(String query);

    public Response.Location[] autocomplete(String query);

    public Response.Location[] reverse(double lat, double lng);
}

