/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Mario
 */
import Model.SQL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.xml.transform.Result;
public class InitModel {
       public static SQL sql;
    public InitModel(){
        this.sql=new SQL();    
    }
    
    public boolean Login(String Username, String Password){
        boolean result=false;
      try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(Username,Password));
           ResultSet rs = sql.SELECT("Select `Username` From Login Where `Username`=? and Password=?", objs);
           if (sql.Exists(rs)) {
              result=true;
          } 
           return result;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return false;
        }        
    
    }
   
    
    
}
