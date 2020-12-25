package com.example.Spring_Boot_JPA.mappers;

public interface DtoBoMapperIface<S, T> {

    // abstract method to convert Dto
    // (Data transfer object) to Bo (Business object)
    S toBo(final T t);

    // abstract method to convert Bo
    // (Business object) to Dto (Data transfer object)
    T toDto(final S s);
}
