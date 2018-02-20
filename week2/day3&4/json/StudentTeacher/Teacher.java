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
public class Teacher {
    private String[] classesTakingCareOf;
    private String dateOfJoining;
    private String id,name;
    private int salary;
    Teacher(String id,String name){
        this.id=id;
        this.name=name;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public void setClassesTakingCareOf(String[] temp){
        this.classesTakingCareOf=temp;
    }
}
