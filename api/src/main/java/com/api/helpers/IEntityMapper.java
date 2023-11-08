package com.api.helpers;

import java.util.List;

public interface IEntityMapper<T,S> {

    public T mapObject(S object);
    public S mapReverse(T object);

    public List<T> mapObjects(Iterable<S> objects);
    public List<S> mapReverseObjects(Iterable<T> objects);
}
