/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projet.Interface_service.Interface_cours;
import projet.entity.Cours;
import projet.utils.Database;

/**
 *
 * @author shado
 */
public class Servicecours implements Interface_cours {
  Connection cnx ;
    public Servicecours() {
         cnx = Database.getInstance().getConn();
       
    }
    @Override
    public void add(Cours t) throws SQLException {
          Statement st = cnx.createStatement();
    //    String req = "insert into personne values ("+p.getId()+" , " +p.getNom()+ ", " +p.getPrenom() +")";
          String req =" insert into cours (id_cours, nom_cours,domaine,lien ) values (" +t.getId_cours()+ ", '"+t.getNom_cours()+"','"+t.getDomaine()+"','"+t.getLien()+"' )"; 
    st.executeUpdate(req);       
    }

    @Override
    public List<Cours> read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Cours t) throws SQLException {
          
        PreparedStatement pt = cnx.prepareStatement("update cours set nom_cours = ? ,  domaine= ? ,  lien = ? where id_cours = ? ");
      pt.setString(1,t.getNom_cours());
      pt.setString(2,t.getDomaine());
      pt.setString(3,t.getLien());
      pt.setInt(4,t.getId_cours());
         
        pt.executeUpdate(); 
    }

    @Override
    public void delete(Cours t) throws SQLException {
             PreparedStatement pt = cnx.prepareStatement("delete from cours where id_cours = ?");
        pt.setInt(1,t.getId_cours());
        pt.executeUpdate(); 
    }

    @Override
    public List<Cours> getCours() throws SQLException {
               Statement st = cnx.createStatement();
        
       
        String query = "SELECT * FROM  `cours` ";
        ResultSet rst = st.executeQuery(query);
        List<Cours> cours = new ArrayList<>();
        while (rst.next()) {
           
             Cours c = new Cours();
             c.setId_cours(rst.getInt("id_cours"));
             c.setNom_cours(rst.getString("nom_cours"));
             c.setDomaine(rst.getString("domaine"));
             c.setLien(rst.getString("lien"));
          
           System.out.println(c);
            cours.add(c);
            
        }
        return cours;
    }

    @Override
    public List<Integer> get_id() throws SQLException {
              Statement st = cnx.createStatement();
        
       int i=0;
        String query = "SELECT id_cours FROM  `cours` ";
         ResultSet rst = st.executeQuery(query);
      ArrayList<Integer> T=new ArrayList<>();
       while (rst.next())
       {
           T.add(rst.getInt("id_cours"));
         
       }
      return T; 
    }
   
    
}
