package com.blackcat.java.bean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p> ：
 *
 * @author : blackcat
 * @date : 2020/1/21 13:18
 */
public abstract  class FatherReflectUtils<T> {

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
