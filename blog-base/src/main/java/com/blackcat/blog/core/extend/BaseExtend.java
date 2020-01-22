package com.blackcat.blog.core.extend;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p> ：
 * @author : blackcat
 * @serialData : 2020/1/20 23:01
 */
public abstract class BaseExtend<T> {

    public T getTInstance() throws InstantiationException, IllegalAccessException {
        Type sType = getClass().getGenericSuperclass();
        Type[] generics = ((ParameterizedType) sType).getActualTypeArguments();
        Class<T> mTClass = (Class<T>) (generics[0]);
        return mTClass.newInstance();
    }

    public Class<T> getTClass() throws InstantiationException, IllegalAccessException {
        Type sType = getClass().getGenericSuperclass();
        Type[] generics = ((ParameterizedType) sType).getActualTypeArguments();
        Class<T> mTClass = (Class<T>) (generics[0]);
        return mTClass;
    }
}
