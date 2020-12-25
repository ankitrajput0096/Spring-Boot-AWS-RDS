package com.example.Spring_Boot_JPA.mappers;


public interface BoEntityMapperIface<S, T> {
    // Here, 'Iface' => Interface

    // abstract method to convert
    // entity to business object(bo)
    S toBo(final T t);

    // abstract method to convert
    // business object(bo) to entity object.
    T toEntity(final S s);
}
