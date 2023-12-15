/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Record {
    private String name;
    private int tpnumber;
    private String shipadd;
    private String billadd;
    private Long bankacc;
    private String city;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tpnumber
     */
    public int getTpnumber() {
        return tpnumber;
    }

    /**
     * @param tpnumber the tpnumber to set
     */
    public void setTpnumber(int tpnumber) {
        this.tpnumber = tpnumber;
    }

    /**
     * @return the shipadd
     */
    public String getShipadd() {
        return shipadd;
    }

    /**
     * @param shipadd the shipadd to set
     */
    public void setShipadd(String shipadd) {
        this.shipadd = shipadd;
    }

    /**
     * @return the billadd
     */
    public String getBilladd() {
        return billadd;
    }

    /**
     * @param billadd the billadd to set
     */
    public void setBilladd(String billadd) {
        this.billadd = billadd;
    }

    /**
     * @return the bankacc
    

    /**
     * @param bankacc the bankacc to set
   
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    public boolean insertrecord(Record data) {
        boolean result = false;

        try {
            String strinsert = "insert into customer values(?,?,?,?,?,?)";
            Connection conn = dbcon.Openconnection();
            PreparedStatement ps = conn.prepareStatement(strinsert);
            ps.setString(1, data.getName());
            ps.setInt(2, data.getTpnumber());
            ps.setString(3, data.getBilladd());
            ps.setString(4, data.getShipadd());
            ps.setLong(5, data.getBankacc());
            ps.setString(6, data.getCity());

            int i = ps.executeUpdate();
            if (i > 0) {
                result = true;
            } else {
                result = false;
            }

        } catch (Exception ex) {
            System.out.print(ex);
            result = false;
        }
        return result;
    }
    public ArrayList<Record> getAllrecords() {
        ArrayList<Record> list = null;
        Record data = null;

        try {
            String strSelect = "select * from customer";
            Connection conn = dbcon.Openconnection();
            PreparedStatement ps = conn.prepareStatement(strSelect);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) 
            {
                rs.beforeFirst();
                list = new ArrayList();
                while (rs.next()) 
                {
                    
                    data = new Record();
                    data.setName(rs.getString(1));
                    data.setTpnumber(Integer.parseInt(rs.getString(2)));
                    data.setBilladd(rs.getString(3));
                    data.setShipadd(rs.getString(4));
                    data.setBankacc(Long.parseLong(rs.getString(5)));
                    data.setCity(rs.getString(6));
                    list.add(data);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }

    /**
     * @return the bankacc
     */
    public Long getBankacc() {
        return bankacc;
    }

    /**
     * @param bankacc the bankacc to set
     */
    public void setBankacc(Long bankacc) {
        this.bankacc = bankacc;
    }
     public Record getrecord(String c_name)
    {
      Record data=null;
      try
        {
           String strselect = "select * from customer where customer_name =?";
           Connection conn=dbcon.Openconnection();
           PreparedStatement ps = conn.prepareStatement(strselect);
               
           ResultSet rs = ps.executeQuery();
           if(rs.next())
           {
              data = new Record();
              data.setName(rs.getString(1));
              data.setTpnumber(rs.getInt(2));
              data.setBilladd(rs.getString(3)); 
               data.setShipadd(rs.getString(4));
               data.setBankacc(rs.getLong(5));
               data.setCity(rs.getString(6));
              
              
           }
           
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return null;
        }
        
         return data;
}
    
}



   
    

