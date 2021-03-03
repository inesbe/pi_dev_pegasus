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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import projet.Interface_service.Interface_utilisateur;
import projet.entity.Cours;
import projet.entity.Utilisateur;
import projet.utils.Database;

/**
 *
 * @author shado
 */
public class Serviceutilisateur implements Interface_utilisateur {
  Connection cnx ;
     public Serviceutilisateur() {
            cnx = Database.getInstance().getConn();
    }
    @Override
    public void add(Utilisateur t) throws SQLException {
                  Statement st = cnx.createStatement();
    //    String req = "insert into personne values ("+p.getId()+" , " +p.getNom()+ ", " +p.getPrenom() +")";
          String req =" insert into user (id_utilisateur,nom_utilisateur,mot_de_passe,nom,prénom,age,email,moyenne,salaire,role,metier ) values (" +t.getId_utilisateur()+ ", '"+t.getNom_utilisateur()+"','"+t.getMot_de_passe()+"','"+t.getNom()+"' ,'"+t.getPrénom()+"',"+t.getAge()+",'"+t.getEmail()+"',"+t.getMoyenne()+","+t.getSalaire()+","+t.getRole()+","+t.getMetier()+")"; 
    st.executeUpdate(req); 
    }

   

    @Override
    public List<Cours> read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Utilisateur t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Utilisateur t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> get_id() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> getUtilisateur() throws SQLException {
        Statement st = cnx.createStatement();
        
      String query = "SELECT * FROM  user ";
        ResultSet rst = st.executeQuery(query);
        ArrayList<Utilisateur> userlist = new ArrayList<>();
        while (rst.next()) {
            Utilisateur u=new Utilisateur();
            u.setId_utilisateur(rst.getInt("id_utilisateur"));
             u.setNom_utilisateur(rst.getString("nom_utilisateur"));
             u.setMot_de_passe(rst.getString("mot_de_passe"));
           u.setNom(rst.getString("nom"));
           u.setPrénom(rst.getString("prénom"));
           u.setAge(rst.getInt("age"));
           u.setEmail(rst.getString("email"));
           u.setRole(rst.getInt("role"));
           u.setSalaire(rst.getInt("salaire"));
           u.setMoyenne(rst.getInt("moyenne"));
           u.setMetier(rst.getString("metier"));
           System.out.println(u);
           
           userlist.add(u);
            
        }
        return userlist;
        }
    

    @Override
    public boolean login(Utilisateur t) {
        
               String sql ="SELECT * from user WHERE nom_utilisateur = ? and mot_de_passe = ? ";
         PreparedStatement ps=null;
        ResultSet rs=null;
      try {
          ps=cnx.prepareStatement(sql);
  
          ps.setString(1,t.getNom_utilisateur());
           ps.setString(2,t.getMot_de_passe());
  
          rs=ps.executeQuery();
      
        System.out.println(rs);  
    
          if(!rs.next())
          {
           return false;
          }
          else
          {
          return true;    
          }
      } catch (SQLException ex) {
          Logger.getLogger(Serviceutilisateur.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      return false;
         
    }
    
}
