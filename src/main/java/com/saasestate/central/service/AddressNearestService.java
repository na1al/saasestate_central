package com.saasestate.central.service;

import com.saasestate.central.component.geo.GeoCoder;
import com.saasestate.central.entity.AddressNearest;
import com.saasestate.central.repository.AddressNearestRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressNearestService {


    public final static int MAX_NEAREST_DISTANCE_M = 1000;

    AddressNearestRepository addressNearestRepository;

    @Autowired
    AddressNearestService(AddressNearestRepository addressNearestRepository, GeoCoder geoCoder) {
        this.addressNearestRepository = addressNearestRepository;
    }

    public Optional<AddressNearest> findOne(int id) {
        return addressNearestRepository.findById(id);
    }

    public AddressNearest[] findNearest(Coordinate coordinate){

        GeometryFactory gf = new GeometryFactory();
        Point point = gf.createPoint(coordinate);
        point.setSRID(4326);

        return addressNearestRepository.findNearest(point, MAX_NEAREST_DISTANCE_M);
    }

    public void save(AddressNearest nearest){
        addressNearestRepository.save(nearest);
    }



}
