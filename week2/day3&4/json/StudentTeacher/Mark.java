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
public class Mark {
    private int mark;
    private String subject;
    Mark(int marks,String subject){
        this.mark=marks;
        this.subject=subject;
    }
    public String toString(){
        return "subject "+subject+"\n marks:"+mark; 
    }
}
