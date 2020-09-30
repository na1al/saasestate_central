package com.saasestate.central.service;

import com.saasestate.central.component.geo.GeoCoder;
import com.saasestate.central.dto.EstateDto;
import com.saasestate.central.entity.Address;
import com.saasestate.central.mappers.AddressMapper;
import com.saasestate.central.repository.AddressRepository;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.Point2D;

@Service
public class AddressService {

    AddressRepository addressRepository;

    GeoCoder geoCoder;

    AddressMapper addressMapper;

    @Autowired
    AddressService(AddressRepository addressRepository, GeoCoder geoCoder, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.geoCoder = geoCoder;
        this.addressMapper = addressMapper;
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address findFirstByPoint(Point2D point) {

        var locations = geoCoder.reverse(point.getX(), point.getY());

        if (locations.length == 0) {
            return null;
        }

        return addressRepository
                .findOneByPlaceId(locations[0].placeId)
                .orElseGet(() -> {
                    var adr = addressMapper.toEntity(locations[0]);
                    addressRepository.save(adr);
                    return adr;
                });
    }

}
