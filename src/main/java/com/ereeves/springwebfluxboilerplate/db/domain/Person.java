package com.ereeves.springwebfluxboilerplate.db.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Document(collection = "people")
public class Person extends BaseDomain<UUID> {

    @NotBlank
    @Size(max = 140)
    private String firstName;

    @NotBlank
    @Size(max = 140)
    private String middleName;

    @NotBlank
    @Size(max = 140)
    private String lastName;

    public Person() {
        setID(UUID.randomUUID());
    }

}
