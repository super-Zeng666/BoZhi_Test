package com.ceam.eureka.pojo;

import lombok.Data;

/**
 * @author 曾帅
 * @create 2023/5/25 15:08
 **/
@Data
public class Person
{
  private Integer id;
  private String name;
  private Integer age;

  public Person() {}

  public Integer getId()
  {
    return id;
  }

  public Person(Integer id, String name, Integer age)
  {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Integer getAge()
  {
    return age;
  }

  public void setAge(Integer age)
  {
    this.age = age;
  }

  @Override
  public String toString()
  {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
