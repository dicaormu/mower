package fr.com.mowitnow.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;

public class Tuple<T,R> {

    public final T first;
    public final R second;


    public Tuple(T first, R second) {
        this.first = first;
        this.second = second;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
