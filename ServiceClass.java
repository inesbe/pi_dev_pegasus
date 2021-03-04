/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projet.Interface_service.Interface_class;
import projet.entity.Classe;
import projet.entity.Cours;
import projet.utils.Database;

/**
 *
 * @author Espace Info
 */
public class ServiceClass implements Interface_class{

    
    
      Connection cnx ;
    public ServiceClass() {
         cnx = Database.getInstance().getConn();
       
    }
    
    
    @Override
    public void add(Classe t) throws SQLException {
                Statement st = cnx.createStatement();
    //    String req = "insert into personne values ("+p.getId()+" , " +p.getNom()+ ", " +p.getPrenom() +")";
          String req =" insert into class (id_class, id_utilisateur,nom_class,age ) values (" +null+ ", "+t.getId_utilisateur()+",'"+t.getNom_class()+"',"+t.getAge()+" )"; 
    st.executeUpdate(req);
    }

    @Override
    public List<Classe> getclasse() throws SQLException {
              Statement st = cnx.createStatement();
        String query = "SELECT * FROM  `class` ";
        ResultSet rst = st.executeQuery(query);
        List<Classe> classe = new ArrayList<>();
        while (rst.next()) {
           
             Classe c = new Classe();
             c.setId_class(rst.getInt("id_class"));
             c.setId_utilisateur(rst.getInt("id_utilisateur"));
             c.setNom_class(rst.getString("nom_class"));
             c.setAge(rst.getInt("age"));
          
           System.out.println(c);
            classe.add(c);
            
        }
        return classe;
    }
      @Override
    public List<Integer> getTeacher() throws SQLException 
    {
         Statement st = cnx.createStatement();
        String query = "SELECT * FROM  `class` ";
        ResultSet rst = st.executeQuery(query);
        List<Integer> classe = new ArrayList<>();
        while (rst.next()) {
            
         classe.add(rst.getInt("id_utilisateur"));
            
        }
        
        return classe;
        }
        
        
    }
    
    
    
    