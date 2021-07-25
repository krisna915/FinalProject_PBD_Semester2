/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualanTempe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hamba Notbook
 */
public class konsumenService {
    Connection connection;
    PreparedStatement preparedStatement;
    Konsumen Konsumen;
    List<Konsumen> konsumens=new ArrayList<Konsumen>();
    
    public konsumenService(Connection connection){
        this.connection=connection;
    }
    
    public List<Konsumen> getAllKonsumen() throws SQLException{
        preparedStatement=connection.prepareStatement("SELECT * FROM konsumen");
        ResultSet rs=preparedStatement.executeQuery();
        while(rs.next()){
            Konsumen=new Konsumen();
            Konsumen.setId(rs.getString("id_konsumen"));
            Konsumen.setNama(rs.getString("nama"));
            konsumens.add(Konsumen);
        }
        return konsumens;
    }
}
