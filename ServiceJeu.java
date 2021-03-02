/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entités.Jeu;
import Intservice.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Database;

/**
 *
 * @author JAIDI
 */
public class ServiceJeu implements IService<Jeu>{
 Connection cnx ;
    public ServiceJeu() {
         cnx = Database.getInstance().getConn();
        
    }

    
    
    
    @Override
    public void add(Jeu p) throws SQLException{
        
        Statement st = cnx.createStatement();
          String req =" insert into Jeux (id,titre,description,cours,diff,topscore,source) values (" +p.getId()+ ", '"+p.getTitre()+" ' , '"+p.getDescription() +"', '"+p.getCours() +"', '"+p.getDiff()+"','"+null+"','"+p.getSource()+"')"; 
    st.executeUpdate(req);

    }
    
    
    
    

    @Override
    public List<Jeu> read() throws SQLException{
   List<Jeu> ls = new ArrayList<Jeu>();
    Statement st = cnx.createStatement();
    String req = "select * from jeux";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
       int id = rs.getInt("id");
        String titre = rs.getString(2);
        String description = rs.getString(3);
        int cours = rs.getInt("cours");
         String diff = rs.getString(6);
                 String topscore = rs.getString("topscore");
                 String source=rs.getString("source");

    
        
        Jeu p = new Jeu(id,titre,description,cours,diff,topscore,source);
        ls.add(p);
      //  System.out.println( id + ", " + nom + ", " + prenom);
    }
         return ls;
    }
    
    
    public List<Integer> getId() throws SQLException {
               Statement st = cnx.createStatement();
        
       
        String query = "SELECT id FROM  JEUX ";
        ResultSet rst = st.executeQuery(query);
        List<Integer> jeux = new ArrayList<>();
        while (rst.next()) {
           
             int j;
             j=rst.getInt("id");
     
            jeux.add(j);
            
        }
        return jeux;
    }
    
    
    
   

    @Override
    public void update(Jeu p) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update JEUX set titre = ?,description = ?,cours = ?,diff = ?,source=? where id = ? ");
        pt.setString(1,p.getTitre());
        pt.setString(2,p.getDescription());
        pt.setInt(3, p.getId());
        pt.setString(4,p.getDiff());
    pt.setString(5,p.getSource());

        pt.setInt(6, p.getId());

        pt.executeUpdate(); 


    }

    
    public void delete(int idd) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from Jeux where id = ?");
        pt.setInt(1,idd);
        pt.executeUpdate();    }

    public void get_id() {
        
    }

  
    
}
