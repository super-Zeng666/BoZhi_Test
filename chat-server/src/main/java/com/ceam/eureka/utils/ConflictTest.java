package com.ceam.eureka.utils;

import com.ceam.eureka.pojo.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;

/**
 * @author 曾帅
 * @create 2023/5/25 15:05
 **/
public class ConflictTest {
  public static void main(String[] args) {
    List<Person> list = dataPre();

    //根据list内某个字段值，条件去重后获取新的list
    List<Person> newList = list.stream()
        .filter(person -> StringUtils.isNotBlank(person.getName()))
        .collect(Collectors.collectingAndThen(Collectors.toCollection(
            () -> new TreeSet<>(Comparator.comparing(Person::getName))), ArrayList::new));
    newList.forEach(person -> System.out.println(person.toString()));

    //取出集合内某个属性集合
    List<String> nameList = list.stream().map(Person::getName).collect(Collectors.toList());
    System.out.println(nameList);

    //List转map  用id作为键，name做value, 由于id不存在重复故不进行覆盖设置
    Map<Integer, String> newMap = list.stream()
        .collect(Collectors.toMap(Person::getId, Person::getName));
    //打印
    Set<Integer> set = newMap.keySet();
    Iterator<Integer> iterator = set.iterator();
    while (iterator.hasNext()) {
      int key = iterator.next();
      System.out.println(key + ":" + newMap.get(key));
    }

    //List分组
    Map<String, List<Person>> groupMap = list.stream()
        .collect(Collectors.groupingBy(Person::getName));
    //打印
    Set<String> set1 = groupMap.keySet();
    Iterator<String> iteratorGroup = set1.iterator();
    while (iteratorGroup.hasNext()) {
      String key = iteratorGroup.next();
      System.out.println(key + ":" + groupMap.get(key).toString());
    }

    //List升序降序  最终按照降序输出
    Collections.sort(list, Comparator.comparing(Person::getAge));
    Collections.reverse(list);
    System.out.println(list);

    //6.list条件过滤==>>happy
    List<Person> userList = list.stream().filter(o->"张三".equals(o.getName())).collect(Collectors.toList());
    userList.forEach(System.out::println);

    //list条件过滤  设条件为年龄大于18岁
    List<Person> checkList = list.stream()
        .filter(o -> Objects.nonNull(o))
        .filter(o -> o.getAge() > 18)
        .collect(Collectors.toList());
    System.out.println(checkList);
    //1.根据list内某个字段值，条件去重后获取新的list
    ArrayList<Person> newList2 = list.stream()
        .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(
            Comparator.comparing(Person::getName))), ArrayList::new));
    newList2.forEach(o -> {
      System.out.println(o.getName() + "," + o.getAge());
    });
    //2.取出集合内某个属性集合
    List<Integer> ageList = list.stream().map(o -> o.getAge()).collect(Collectors.toList());
    ageList.forEach(o -> {
      System.out.println(o);
    });
  }


  /**
   * 数据准备，给任务提供数据来源
   *
   * @date 2023/5/24 17:23
   */
  public static List<Person> dataPre() {
    List<Person> list = new ArrayList<>();
    list.add(new Person(1, "张三", 19));
    list.add(new Person(2, "李四", 18));
    list.add(new Person(3, "王二", 17));
    list.add(new Person(4, "麻子", 28));
    list.add(new Person(5, "李四", 15));
    return list;
  }
}