package com.blogspot.devnip.lombok.builder;

public class PetService {

    public Pet getDummyPetObject() {
        return Pet.builder()
                .id("001")
                .name("Zest")
                .type("CAT")
                .build();
    }
}
