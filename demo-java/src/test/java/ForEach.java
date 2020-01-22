import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * jdk 1.8 ForEach使用示例
 * @author: blackcat
 * @date: 2019/12/31 16:03
 */
public class ForEach {

    /**
     * 遍历list String类型
     * @author: blackcat
     * @date: 2019/12/31 16:15
     * @param []
    */
    @Test
    public void string(){
        List<String> list = new ArrayList<String>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("four");
        list.add("five");

        list.forEach((num)->System.out.println(num));

        list.forEach(item->{
            System.out.println("Item : " + item);
            if("four".equals(item)){
                System.out.println("E");
            }
        });
    }

    /**
     * 遍历list Integer类型
     * @author: blackcat
     * @date: 2019/12/31 16:15
     * @param []
     */
    @Test
    public void Integer(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        System.out.println("no.1>>");
        numbers.forEach((Integer integer) -> System.out.print(integer));
        System.out.println();

        System.out.println("no.2>>");
        numbers.forEach(integer -> System.out.print(integer));
        System.out.println();

        System.out.println("no.3>>");
        numbers.forEach(integer -> System.out.print(integer));
        System.out.println();

        System.out.println("no.4>>");
        numbers.forEach(System.out::print);
        System.out.println();

        System.out.println("no.5>>");
        numbers.forEach(new MyConsumer());
    }

    class MyConsumer implements Consumer<Integer> {
        @Override
        public void accept(Integer integer) {
            System.out.print(integer);
        }
    }

    /**
     * 遍历map
     * @author: blackcat
     * @date: 2019/12/31 16:15
     * @param []
     */
    @Test
    public void queryMapExt(){
        Map<String, Object> map = new HashMap<>(5);
        map.put("1", "2");
        map.put("6", 7);

        map.forEach((k,v)->System.out.print("Item : " + k + " Count : " + v));

        map.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            System.out.println(Objects.equals(k, "E"));
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });
    }

}


