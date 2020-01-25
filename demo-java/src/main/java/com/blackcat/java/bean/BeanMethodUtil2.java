package com.blackcat.java.bean;

import com.blackcat.java.common.User;

import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * <p> ：
 *
 * @author : blackcat
 * @date : 2020/1/21 11:41
 */
public class BeanMethodUtil2 {

    public static void main(String[] args) throws Exception {

        // test removeLine
        System.out.println(removeLine("abg_dwr"));
        System.out.println(removeLine("ab_wr"));
        System.out.println(removeLine("abgwr"));
        System.out.println(removeLine(null));


        // test get

        User user = new User();
        user.setUsername("111");
        user.setUserpassword("222");
        Object ob = getGetMethod(user, "username");
        System.out.println("get:"+ob);
        System.out.println("get2:"+ BeanUtil.getReadMethod(User.class,"username"));

        // test set
        User user2 = new User();
        String field2 = "username";
        setValue(user2, user2.getClass(), field2, User.class.getDeclaredField(field2).getType(), "汪汪");
        System.out.println("set:"+user2);

        // 获取某个属性的类型
        System.out.println("type:"+User.class.getDeclaredField("username").getType());



    }


    /**

     * 根据属性，获取get方法

     *

     * @param ob   对象

     * @param name 属性名

     * @return

     * @throws Exception

     */
    public static Object getGetMethod(Object ob, String name) throws Exception {
        Method[] m = ob.getClass().getMethods();
        for (int i = 0; i < m.length; i++) {
            if (("get" + name).toLowerCase().equals(m[i].getName().toLowerCase())) {
                return m[i].invoke(ob);
            }
        }
        return null;
    }



    /**

     * 根据属性，拿到set方法，并把值set到对象中

     *

     * @param obj       对象

     * @param clazz     对象的class

     * @param typeClass

     * @param value

     */

    public static void setValue(Object obj, Class<?> clazz, String filedName, Class<?> typeClass, Object value) {

        filedName = removeLine(filedName);

        String methodName = "set" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);

        try {

            Method method = clazz.getDeclaredMethod(methodName, new Class[] { typeClass });

            method.invoke(obj, new Object[] { getClassTypeValue(typeClass, value) });

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }



    /**

     * 通过class类型获取获取对应类型的值

     *

     * @param typeClass class类型

     * @param value     值

     * @return Object

     */

    private static Object getClassTypeValue(Class<?> typeClass, Object value) {

        if (typeClass == int.class || value instanceof Integer) {

            if (null == value) {

                return 0;

            }

            return value;

        } else if (typeClass == short.class) {

            if (null == value) {

                return 0;

            }

            return value;

        } else if (typeClass == byte.class) {

            if (null == value) {

                return 0;

            }

            return value;

        } else if (typeClass == double.class) {

            if (null == value) {

                return 0;

            }

            return value;

        } else if (typeClass == long.class) {

            if (null == value) {

                return 0;

            }

            return value;

        } else if (typeClass == String.class) {

            if (null == value) {

                return "";

            }

            return value;

        } else if (typeClass == boolean.class) {

            if (null == value) {

                return true;

            }

            return value;

        } else if (typeClass == BigDecimal.class) {

            if (null == value) {

                return new BigDecimal(0);

            }

            return new BigDecimal(value + "");

        } else {

            return typeClass.cast(value);

        }

    }



    /**

     * 处理字符串 如： abc_dex ---> abcDex

     *

     * @param str

     * @return

     */

    public static String removeLine(String str) {

        if (null != str && str.contains("_")) {

            int i = str.indexOf("_");

            char ch = str.charAt(i + 1);

            char newCh = (ch + "").substring(0, 1).toUpperCase().toCharArray()[0];

            String newStr = str.replace(str.charAt(i + 1), newCh);

            String newStr2 = newStr.replace("_", "");

            return newStr2;

        }

        return str;

    }
}
