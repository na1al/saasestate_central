package com.saasestate.central.repository;


import com.saasestate.central.entity.AddressNearest;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressNearestRepository extends CrudRepository<AddressNearest, Integer> {

    @Query(value = "SELECT n.* FROM address_nearest n " +
            "INNER JOIN address a ON a.id = n.address_id " +
            "WHERE ST_DWithin(location, ?1, 750, true)", nativeQuery = true)
    public AddressNearest[] findNearest(Point point, int distance);

}
