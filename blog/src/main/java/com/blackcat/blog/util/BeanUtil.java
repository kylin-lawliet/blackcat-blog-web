package com.blackcat.blog.util;

import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * <p> : Bean属性操作类
 * @author : blackcat
 * @date : 2020/1/20 22:26
*/
public class BeanUtil {

    /**
     * 获取属性描述信息
     * @param clazz 类型
     * @param propertyName 属性名称
     * @return 属性描述信息
     */
    public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName){
        return BeanUtils.getPropertyDescriptor(clazz,propertyName);
    }

    /**
     * 获取属性对应的写方法
     * @param clazz 类型
     * @param propertyName 属性名称
     * @return 对应的写方法
     */
    public static Method getWriteMethod(Class<?> clazz, String propertyName){
        return getPropertyDescriptor(clazz,propertyName).getWriteMethod();
    }

    /**
     * 获取属性对应的读方法
     * @param clazz 类型
     * @param propertyName 属性名称
     * @return 对应的读方法
     */
    public static Method getReadMethod(Class<?> clazz, String propertyName){
        return getPropertyDescriptor(clazz,propertyName).getReadMethod();
    }

    /**
     * 属性copy
     * @param source 源数据
     * @param target 目标数据
     * @param propertyNames 被copy的属性名称
     * @throws Exception
     */
    public static void copyAttr(Object source, Object target, String... propertyNames)throws Exception {
        if(propertyNames!=null&&propertyNames.length>0){
            for (int i = 0; i < propertyNames.length; i++) {
                String attr = propertyNames[i];
                copySingleAttr(source,target,attr);
            }
        }
    }

    /**
     * 单个属性copy
     * @param source 源数据
     * @param target 目标数据
     * @param propertyName 被copy的属性名称
     * @throws Exception
     */
    public static void copySingleAttr(Object source, Object target, String propertyName)throws Exception {
        if(propertyName!=null){
            getWriteMethod(target.getClass(),propertyName).invoke(target,getReadMethod(source.getClass(),propertyName).invoke(source));
        }
    }

    /**
     * 给对象的属性赋值
     * @param bean 数据对象
     * @param propertyName  属性名称
     * @param value 值
     * @throws Exception
     */
    public static void putAttr(Object bean, String propertyName, Object value)throws Exception {
        if(propertyName!=null){
            getWriteMethod(bean.getClass(),propertyName).invoke(bean,value);
        }
    }

    /**
     * <p> : 根据属性，获取get方法值
     * @author : blackcat
     * @date : 2020/1/21 11:45
     * @param [ob:对象, propertyName:属性名]
     * @return java.lang.Object     
    */
    public static Object getGetMethodValue(Object ob, String propertyName) throws Exception {
        Method[] m = ob.getClass().getMethods();
        for (int i = 0; i < m.length; i++) {
            if (("get" + propertyName).toLowerCase().equals(m[i].getName().toLowerCase())) {
                return m[i].invoke(ob);
            }
        }
        return null;
    }

    /**
     * <p> : 得到带构造的类的实例
     * @author : blackcat
     * @date : 2020/1/21 13:10
     * @param [className, args]
     * @return java.lang.Object     
    */
    public static Object newInstance(String className, Object[] args) throws Exception {
        Class newoneClass = Class.forName(className);
        Class[] argsClass = new Class[args.length];
        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }
        Constructor cons = newoneClass.getConstructor(argsClass);
        return cons.newInstance(args);
    }


}
