package com.blackcat.java;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * <p> 描述 ：org.apache.commons.lang3.ArrayUtils工具类详解
 * @author : blackcat
 * @date : 2020/2/1 8:45
 */
public class ArrayUtilsExample {

    public static void main(String[] args) {
        String[] array1 = {"a","b","c"};
        String[] array2 = {"q","w","e","r","e"};
        int[] array3 = {1,2,3,1};
        Integer[] array4 = {4,5,6,7,8,9};

        // 合并两个数组array1、array2，输出合并后的数组
        String[] addAll = ArrayUtils.addAll(array1, array2); //== [a, b, c, q, w, e, r, e]
        String string = Arrays.toString(addAll);

        // 克隆某个数组
        String[] clone = ArrayUtils.clone(array1); //== {a,b,c}
        String string3 = ArrayUtils.toString(clone);

        // 数组是否包含某个元素
        boolean flag1 = ArrayUtils.contains(array1, "a"); //== true

        // 获取数组的长度
        int array2length = ArrayUtils.getLength(array2); //== 5

        // 某个元素在数组所在的位置，有相同的取第一个
        int array_e_index = ArrayUtils.indexOf(array2, "e"); //== 2

        // 判断一个数组是否为空
        boolean empty = ArrayUtils.isEmpty(array1); //== false

        // 判断两个数组的是否相等
        boolean equals = ArrayUtils.isEquals(array1, array2); //== false

        // 判断两个数组的长度是否相等
        boolean sameLength = ArrayUtils.isSameLength(array1, array2); //== false

        // 两个数组的类型是否相同
        boolean sameType = ArrayUtils.isSameType(array1, array2); //== true

        // 获取某个元素在数组中最后一个位置
        int lastIndexOf = ArrayUtils.lastIndexOf(array3, 3); //== 2

        // 移除数组的某个元素
        int[] removeElements = ArrayUtils.removeElements(array3, 1); //== {2,3,1}

        //  将某个数组元素倒序
        ArrayUtils.reverse(array3); //== {1,3,2,1}

        // 截取某个数组返回新的数组
        int[] subarray = ArrayUtils.subarray(array3, 1, 2); //== {3}

        // int[] 数组转换成 Integer[]
        Integer[] object = ArrayUtils.toObject(array3);

        // Integer[] 数组转换成 int[]
        int[] primitive = ArrayUtils.toPrimitive(array4);

    }
}
