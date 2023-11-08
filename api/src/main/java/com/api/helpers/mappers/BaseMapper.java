package com.api.helpers.mappers;

import java.util.ArrayList;
import java.util.List;

import com.api.helpers.IEntityMapper;

public abstract class BaseMapper<T,S> implements  IEntityMapper<T,S>{

    @Override
    public abstract T mapObject(S object);

    @Override
    public abstract S mapReverse(T object);

    @Override
    public List<T> mapObjects(Iterable<S> objects) {
        List<T> res = new ArrayList<>();
        for(S obj : objects){
            res.add(mapObject(obj));
        }
        return res;
    }

    @Override
    public List<S> mapReverseObjects(Iterable<T> objects) {
        List<S> res = new ArrayList<>();
        for(T obj : objects){
            res.add(mapReverse(obj));
        }
        return res;
    }
    
}
