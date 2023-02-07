package com.abdulrehman1793;

public abstract class GenericBase<T> {
    abstract ControlHelper filter(T filters);

    abstract void update();

    abstract void delete();
}
