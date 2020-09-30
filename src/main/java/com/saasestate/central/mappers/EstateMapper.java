package com.saasestate.central.mappers;


import com.saasestate.central.dto.EstateDto;
import com.saasestate.central.entity.*;
import com.saasestate.central.service.AddressService;
import com.saasestate.central.service.CurrencyService;
import com.saasestate.central.service.TagService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//TODO query cache
@Mapper(componentModel = "spring", imports = {Param.ParamType.class, Tag.TagType.class, Currency.class})
public abstract class EstateMapper {


    @Autowired
    CurrencyService currencyService;

    @Autowired
    TagService tagService;

    @Autowired
    AddressService addressService;

    @AfterMapping
    public void calledWithSourceAndTarget(EstateDto source, @MappingTarget Estate target) {

        var params = target.getParams();

        Currency currency = currencyService.findByType(Currency.CurrencyType.valueOf(source.currency));
        params.add(new Param(Param.ParamType.PRICE, Math.round(source.price * currency.rate)));


        params.forEach(v -> v.setEstate(target));
    }


    @Mapping(target = "peId", expression = "java(dto.getPeId())")
    @Mapping(target = "address", source = "point")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "params", source = "params")
    public abstract Estate toEntity(EstateDto dto);

    @Mapping(target = "peId", expression = "java(dto.getPeId())")
    @Mapping(target = "address", source = "point")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "params", source = "params")
    public abstract Estate toEntity(EstateDto dto, @MappingTarget Estate estate);

    protected Currency toCurrency(String currency) {
        return new Currency(currency);
    }

    protected Address toAddress(EstateDto.Point point) {
        return addressService.findById(19L); //TODO: delete
        // return addressService.findFirstByPoint(point);
    }

    protected Set<Tag> toTags(List<EstateDto.Tag> data) {
        if (data == null) {
            return null;
        }
        var ids = data.stream().map(e -> e.id).collect(Collectors.toList());
        return tagService.findAll(ids).stream().map(e -> e).collect(Collectors.toSet());
    }

    protected Set<Param> toParams(List<EstateDto.Param> data) {
        if (data == null) {
            return null;
        }
        return data.stream().map(v -> new Param(Param.ParamType.valueOf(v.type), v.value)).collect(Collectors.toSet());
    }


//    protected Currency toParams(String curr) {
//
//        Set<Param> params = new HashSet<>();
//
//        Currency currency = currencyService.findByType(Currency.CurrencyType.valueOf(curr));
//        params.add(new Param(Param.ParamType.PRICE, Math.round(dto.price * currency.rate)));
//
//
//        return params;
//    }

}
