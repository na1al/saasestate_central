package com.saasestate.central.mappers;

import com.saasestate.central.component.geo.Response;
import com.saasestate.central.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {

    @Mapping(target = "id", ignore = true)
    public abstract Address toEntity(Response.Location location);
}
