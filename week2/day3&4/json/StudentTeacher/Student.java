/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentTeacher;

/**
 *
 * @author cb-akhil
 */
public class Student {
    private String dateOfJoining,std,name;
    private String id;
    private Mark[] marks;
    public Student(String name,String id,String std,String doj) {
        this.name=name;
        dateOfJoining=doj;
        this.id=id;
        this.std=std;
    }
    void setMarks(Mark[] temp){
        marks=temp;
    }
    void setstd(String value){
        std=value;
    }
    void display(){
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("std: " + std);
        System.out.println("Date of Joining: " + dateOfJoining);
        System.out.println(marks[0].toString());
        System.out.println(marks[1].toString());
        System.out.println(marks[2].toString());
        System.out.println(marks[3].toString());
        System.out.println(marks[4].toString());
    }
}
