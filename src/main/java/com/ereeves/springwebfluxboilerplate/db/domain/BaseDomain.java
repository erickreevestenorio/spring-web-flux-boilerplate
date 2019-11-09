package com.ereeves.springwebfluxboilerplate.db.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Data
public class BaseDomain<T> {

    @Id
    private T ID;

    public boolean isNew() {
        if (Objects.isNull(ID)) {
            return true;
        }
        return false;
    }
}
