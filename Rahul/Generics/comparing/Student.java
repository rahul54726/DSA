package com.Rahul.Generics.comparing;

public class Student implements Comparable<Student>{
    int rollno;
    float sgpa;

    public Student(int rollno, float sgpa) {
        this.rollno = rollno;
        this.sgpa = sgpa;
    }

    @Override
    public String toString() {
        return rollno+"";
    }

    @Override
    public int compareTo(Student other) {
        int diff=(int) (this.sgpa-other.sgpa);
        //if diff=0; : means both are equal
        //if dif>0 : means o is smaller
        //if dif<0 : means o is greater
        return diff;

    }
}
