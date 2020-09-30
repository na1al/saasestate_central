package com.saasestate.central.dto;

import com.saasestate.central.entity.Currency;
import com.saasestate.central.entity.Param.ParamType;
import com.saasestate.central.entity.Tag.TagType;
import com.saasestate.central.validation.EnumValidator;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

@Data
public class EstateDto {

    @NotNull(message = "Uid is required")
    @Min(1)
    public int pid;

    @NotNull(message = "Eid is required")
    @Min(1)
    public long eid;

    @NotNull(message = "Coordinate is required")
    public Point point;

    @Min(0)
    @Max(999999999)
    public Integer price;

    @EnumValidator(enumClazz = Currency.CurrencyType.class, message = "Currency type is invalid")
    public String currency;

    @Valid
    public List<Tag> tags = new ArrayList<>();

    @Valid
    public List<Param> params = new ArrayList<>();

    public static class Tag {
        @EnumValidator(enumClazz = TagType.class, message = "Tag type is invalid")
        public String type;

        @NotNull
        @Positive
        public int id;
    }

    public static class Param {
        @EnumValidator(enumClazz = ParamType.class, message = "Param type is invalid")
        public String type;

        @NotNull
        @Positive
        @Max(99999)
        public int value;
    }

    public static class Point extends Point2D.Double {
    }

    public String getPeId() {
        return pid + "-" + eid;
    }

}
