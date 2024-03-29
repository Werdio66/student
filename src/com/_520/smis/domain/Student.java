package com._520.smis.domain;

//学生信息类

public class Student {
    private Long id;
    private String name;         //姓名
    private Integer age;         //年龄
    private Integer math;        //数学成绩
    private Integer computer;    //计算机成绩
    private Integer english;     //英语成绩
    private Integer average;        //平均成绩

    public Student(){}
    public Student(String name, Integer age, Integer math, Integer computer, Integer english) {
        this.name = name;
        this.age = age;
        this.math = math;
        this.computer = computer;
        this.english = english;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getComputer() {
        return computer;
    }

    public void setComputer(Integer computer) {
        this.computer = computer;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", math=" + math +
                ", computer=" + computer +
                ", english=" + english +
                ", average=" + average +
                '}';
    }

    public void setAverage(Integer average) {
        this.average = average;
    }
}
