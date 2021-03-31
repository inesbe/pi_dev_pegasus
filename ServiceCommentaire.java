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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import projet.Interface_service.Interface_commentaire;
import projet.entity.Classe;
import projet.entity.commentaire;
import projet.utils.Database;

/**
 *
 * @author Espace Info
 */
public class ServiceCommentaire implements Interface_commentaire {
     Connection cnx ;
    public ServiceCommentaire() {
         cnx = Database.getInstance().getConn();
       
    }

   

    @Override
    public void add(commentaire t) throws SQLException {
                    Statement st = cnx.createStatement();
                   
          String req =" insert into commentaire (date,email,contenu ) values ('"+ LocalDate.now()+"','"+t.getEmail()+"','"+t.getContenu()+"' )"; 
    st.executeUpdate(req);
    }

    @Override
    public List<commentaire> getcommentaire() throws SQLException {
                Statement st = cnx.createStatement();
        String query = "SELECT * FROM  `commentaire` ";
        ResultSet rst = st.executeQuery(query);
        List<commentaire> commentaire = new ArrayList<>();
        while (rst.next()) {
           
             commentaire c = new commentaire();
               c.setId_commentaire(rst.getInt("id_commentaire"));
             c.setEmail(rst.getString("email"));
             c.setContenu(rst.getString("contenu"));
             c.setDate(LocalDate.parse(rst.getString("date")));
          
           System.out.println(c);
            commentaire.add(c);
            
        }
        return commentaire;
    }

    @Override
    public List<Integer> getId_commentaire() throws SQLException {
           Statement st = cnx.createStatement();
        String query = "SELECT * FROM  `commentaire` ";
        ResultSet rst = st.executeQuery(query);
        List<Integer> commentaire = new ArrayList<>();
        while (rst.next()) {
            
         commentaire.add(rst.getInt("id_commentaire"));
            
        }
        
        return commentaire;
    }

    @Override
    public void delete(commentaire t) throws SQLException {
         PreparedStatement pt = cnx.prepareStatement("delete from commentaire where id_commentaire = ?");
        pt.setInt(1,t.getId_commentaire());;
        pt.executeUpdate(); 
    }

    @Override
    public void update(commentaire t) throws SQLException {
             PreparedStatement pt = cnx.prepareStatement("update commentaire set date = '"+t.getDate()+"' ,  email= ? ,  contenu = ? where id_commentaire = ? ");
      pt.setString(1,t.getEmail());
      pt.setString(2,t.getContenu());
      pt.setInt(3,t.getId_commentaire());
  
    
        pt.executeUpdate(); 
    }

  

  
    
}
