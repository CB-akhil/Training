/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentTeacher;
import java.util.Set;
import org.json.*;
import java.io.FileReader;
/*
 *
 * @author cb-akhil
 */
public class StudentTeacher {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        JSONTokener tokener = new JSONTokener(new FileReader("StudentTeacher/students-teachers.json"));
        JSONObject obj = (JSONObject) new JSONObject(tokener);
        JSONObject stu = (JSONObject) obj.get("Student");
        Student s = new Student(stu.getString("Name"),stu.getString("ID"),stu.getString("Date Of Joining"),stu.getString("Date Of Joining"));
        s.setstd(stu.getString("Std"));
        JSONArray marks =  stu.getJSONArray("Marks");
        int n=marks.length();
        Mark[] temp=new Mark[n];
        for(int i=0;i<n;i++){
            stu = marks.getJSONObject(i);
            temp[i]=new Mark(stu.getInt("Mark"),stu.getString("Subject"));
        }
        s.setMarks(temp);
        s.display();
    }
    
}
