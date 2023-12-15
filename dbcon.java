/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class dbcon
{    

    static Connection conn=null;

    private dbcon()
    {
        
    }
    public static Connection Openconnection()
    {
        try
        {
            if(conn==null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory?useSSL=false","root","1234");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception Found "+ex);
            return null;
        }
        return conn;
    }
   public static void Closeconnection()
    {
        try
        {
            if(conn!=null)
            {
                conn.close();
                conn=null;
            }
        }
        catch(Exception ex)
        {
            conn=null;
        }
    }
    
}


