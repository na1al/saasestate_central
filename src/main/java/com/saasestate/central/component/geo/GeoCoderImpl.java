package com.saasestate.central.component.geo;


import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GeoCoderImpl implements GeoCoder {


    private final String uri;

    private final String accessToken;

    public GeoCoderImpl(String uri, String accessToken) {
        this.uri = uri;
        this.accessToken = accessToken;
    }

    RestTemplate restTemplate = new RestTemplate();

    public Response.Location[] search(String query) {

        var params = Map.of("q", query);
        var url = createUrl("/api/reverse", params);

        Response response = restTemplate.getForObject(url, Response.class);

        return response != null ? response.result : new Response.Location[]{};
    }

    public Response.Location[] autocomplete(String query) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Response.Location[] reverse(double lat, double lng) {

        var params = Map.of("lat", String.valueOf(lat), "lng", String.valueOf(lng));
        var url = createUrl("/api/reverse", params);

        Response response = restTemplate.getForObject(url, Response.class);

        return response != null ? response.result : new Response.Location[]{};
    }

    private String createUrl(String path, Map<String, String> params) {

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("access-token", accessToken);
        requestParams.putAll(params);

        return requestParams.keySet().stream()
                .map(key -> key + "=" + requestParams.get(key))
                .collect(Collectors.joining("&", uri + path + "?", ""));
    }

}
