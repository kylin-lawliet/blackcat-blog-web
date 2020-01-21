package com.blackcat.java.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂
 * @author: blackcat
 * @date: 2019/12/21 10:36
 * 设计模式-享元 示例
 */
public class Factory {
    private Map<String, Drawable> images;//图库

    public Factory() {
        images = new HashMap<String, Drawable>();
    }

    public Drawable getDrawable(String image){
        //缓存里如果没有图件，则实例化并放入缓存。
        if(!images.containsKey(image)){
            switch (image) {
                case "河流":
                    images.put(image, new Water());
                    break;
                case "草坪":
                    images.put(image, new Grass());
                    break;
                case "石路":
                    images.put(image, new Stone());
                    break;
                case "房子":
                    images.put(image, new House());
                    break;
                default:
                    break;
            }
        }
        //缓存里必然有图，直接取得并返回。
        return images.get(image);
    }
}
 /*case "1":
                    images.put(image, new Water());
                case "2":
                    images.put(image, new Grass());
                case "3":
                    images.put(image, new Stone());
                case "4":
                    images.put(image, new House());*/