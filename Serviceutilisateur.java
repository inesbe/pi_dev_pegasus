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
import projet.entity.Enfant;
import projet.entity.Enseignant;
import projet.entity.Parents;
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
          String req =" insert into user (id_utilisateur,nom_utilisateur,mot_de_passe,nom,prénom,age,email,status,role) values (" +t.getId_utilisateur()+ ", '"+t.getNom_utilisateur()+"','"+t.getMot_de_passe()+"','"+t.getNom()+"' ,'"+t.getPrénom()+"',"+t.getAge()+",'"+t.getEmail()+"',0,"+t.getRole()+")"; 
    st.executeUpdate(req); 
    }

    public void add2(Parents t) throws SQLException {
                  Statement st = cnx.createStatement();
    //    String req = "insert into personne values ("+p.getId()+" , " +p.getNom()+ ", " +p.getPrenom() +")";
          String req =" insert into user (id_utilisateur,nom_utilisateur,mot_de_passe,nom,prénom,age,email,role,metier,status ) values (" +t.getId_utilisateur()+ ", '"+t.getNom_utilisateur()+"','"+t.getMot_de_passe()+"','"+t.getNom()+"' ,'"+t.getPrénom()+"',"+t.getAge()+",'"+t.getEmail()+"',"+t.getRole()+",'"+t.getMetier()+"',0)"; 
    st.executeUpdate(req); 
    }
     public void forget_password(Utilisateur u,int code) throws SQLException
    {
        
       PreparedStatement st = cnx.prepareStatement("update user set code= "+code+ " where email = ? ");
      st.setString(1,u.getEmail());
        
        
        st.executeUpdate();
        
    } 

    @Override
    public List<Cours> read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void confirm(Utilisateur u) throws SQLException
    {
        
       PreparedStatement st = cnx.prepareStatement("update user set status=1  where id_utilisateur = ? ");
      st.setInt(1,u.getId_utilisateur());
        
        
        st.executeUpdate();
        
    } 
    public void block(Utilisateur u) throws SQLException
            
    {
           PreparedStatement st = cnx.prepareStatement("update user set status=2  where id_utilisateur = ? ");
      st.setInt(1,u.getId_utilisateur());
        
        
        st.executeUpdate(); 
    }
    
    
    @Override
    public void update(Utilisateur t) throws SQLException {
   PreparedStatement st = cnx.prepareStatement("update user set nom_utilisateur = ? , mot_de_passe = ? , nom = ? ,  prénom = ? , age = ? , email = ?  where id_utilisateur = ? ");
      st.setString(1,t.getNom_utilisateur());
      st.setString(2,t.getMot_de_passe());
      st.setString(3,t.getNom());
      st.setString(4,t.getPrénom());
      st.setInt(5,t.getAge()); 
      st.setString(6,t.getEmail());
      
      st.setInt(7,t.getId_utilisateur());
   
        st.executeUpdate();
    }

    
    public void update_password(String t,String mail) throws SQLException {
   PreparedStatement st = cnx.prepareStatement("update user set  mot_de_passe = ?   where email = ? ");
      st.setString(1,t);
      st.setString(2,mail);
     
    
   
        st.executeUpdate();
    }
    
    
    @Override
    public void delete(Utilisateur t) throws SQLException {
      PreparedStatement pt = cnx.prepareStatement("delete from user where id_utilisateur = ? ");
        pt.setInt(1,t.getId_utilisateur());
        pt.executeUpdate(); 
    }

    @Override
    public List<Integer> get_id() throws SQLException {
         Statement st = cnx.createStatement();
        
      String query = "SELECT id_utilisateur FROM  user ";
        ResultSet rst = st.executeQuery(query);
        ArrayList<Integer> userlist = new ArrayList<>();
        while (rst.next()) {
            
            userlist.add(rst.getInt("id_utilisateur"));
        }
        return userlist;
    }

    @Override
    public List<Utilisateur> getUtilisateur() throws SQLException {
        Statement st = cnx.createStatement();
        
      String query = "SELECT * FROM  user ";
        ResultSet rst = st.executeQuery(query);
        ArrayList<Utilisateur> userlist = new ArrayList<>();
        while (rst.next()) {
            if(rst.getInt("role")==2)
            {
            Parents p=new Parents();
            Utilisateur u=new Utilisateur();
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
           p.setNom_utilisateur(rst.getString("nom_utilisateur"));
             p.setMot_de_passe(rst.getString("mot_de_passe"));
           p.setNom(rst.getString("nom"));
           p.setPrénom(rst.getString("prénom"));
           p.setAge(rst.getInt("age"));
            p.setStatus(rst.getInt("status"));
           p.setEmail(rst.getString("email"));
           p.setRole(rst.getInt("role"));
             p.setMetier(rst.getString("metier"));
     
           userlist.add(p);
            }
            else if(rst.getInt("role")==1)
            {
            Enseignant p=new Enseignant();
            Utilisateur u=new Utilisateur();
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
           p.setNom_utilisateur(rst.getString("nom_utilisateur"));
             p.setMot_de_passe(rst.getString("mot_de_passe"));
           p.setNom(rst.getString("nom"));
           p.setPrénom(rst.getString("prénom"));
           p.setAge(rst.getInt("age"));
            p.setStatus(rst.getInt("status"));
           p.setEmail(rst.getString("email"));
           p.setRole(rst.getInt("role"));
             p.setSalaire(rst.getInt("salaire"));
         
           userlist.add(p);
            }  
                        else if(rst.getInt("role")==0)
            {
            Enfant p=new Enfant();
            Utilisateur u=new Utilisateur();
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
           p.setNom_utilisateur(rst.getString("nom_utilisateur"));
             p.setMot_de_passe(rst.getString("mot_de_passe"));
           p.setNom(rst.getString("nom"));
           p.setPrénom(rst.getString("prénom"));
           p.setAge(rst.getInt("age"));
            p.setStatus(rst.getInt("status"));
           p.setEmail(rst.getString("email"));
           p.setRole(rst.getInt("role"));
             p.setMoyenne(rst.getInt("moyenne"));
             userlist.add(p);
        
            }  else
                        {
                            
                                 
            Utilisateur p=new Utilisateur();
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
           p.setNom_utilisateur(rst.getString("nom_utilisateur"));
             p.setMot_de_passe(rst.getString("mot_de_passe"));
           p.setNom(rst.getString("nom"));
           p.setPrénom(rst.getString("prénom"));
           p.setAge(rst.getInt("age"));
            p.setStatus(rst.getInt("status"));
           p.setEmail(rst.getString("email"));
           p.setRole(rst.getInt("role"));
               userlist.add(p);
          
                        }
           
            
                
            }
            
            
            
        
        return userlist;
        }
    
    
    
    
    

        public Utilisateur getu(Utilisateur t) throws SQLException {
        Statement st = cnx.createStatement();
       Utilisateur u=new Utilisateur(); 
      String query = "SELECT * FROM  user WHERE nom_utilisateur ='"+t.getNom_utilisateur()+"'  and mot_de_passe = '"+t.getMot_de_passe()+"' ";
        
        ResultSet rst = st.executeQuery(query);
 
        while (rst.next()) {
            
            u.setId_utilisateur(rst.getInt("id_utilisateur"));
             u.setNom_utilisateur(rst.getString("nom_utilisateur"));
             u.setMot_de_passe(rst.getString("mot_de_passe"));
           u.setNom(rst.getString("nom"));
           u.setPrénom(rst.getString("prénom"));
           u.setAge(rst.getInt("age"));
           u.setEmail(rst.getString("email"));
           u.setStatus(rst.getInt("status"));
           u.setRole(rst.getInt("role"));
        
           System.out.println(u.getRole());
           
           
            
        }
        return  u ;
        }
        public int getcode(Utilisateur t) throws SQLException
        {
              Statement st = cnx.createStatement();
              int cod=0;
       Utilisateur u=new Utilisateur(); 
      String query = "SELECT * FROM  user WHERE email ='"+t.getEmail()+"'   ";
        
        ResultSet rst = st.executeQuery(query);
 
        while (rst.next()) {   
            
          cod=rst.getInt("code");
        }
    return cod;
        }
                public int getRol(int id) throws SQLException
        {
              Statement st = cnx.createStatement();
              int rol=0;
       Utilisateur u=new Utilisateur(); 
      String query = "SELECT * FROM  user WHERE id_utilisateur ="+id+"   ";
        
        ResultSet rst = st.executeQuery(query);
 
        while (rst.next()) {   
            
          rol=rst.getInt("role");
        }
    return rol;
        }
    @Override
    public int login(Utilisateur t) {
        
               String sql ="SELECT * from user WHERE nom_utilisateur = ? and mot_de_passe = ? ";
         PreparedStatement ps=null;
        ResultSet rs=null;
        int r=0;
      try {
          ps=cnx.prepareStatement(sql);
  
          ps.setString(1,t.getNom_utilisateur());
           ps.setString(2,t.getMot_de_passe());
           
  
          rs=ps.executeQuery();
      
        System.out.println(rs);  
    
          if(!rs.next())
          {
           return 0;
          }
          else
          {
              r=rs.getInt("role");
          
              
            if(r==0 || r==2)
            {
             return 2;   
                
            }
              
            else 
            {
                
             return 1;
            }
              
              
          }
      } catch (SQLException ex) {
          Logger.getLogger(Serviceutilisateur.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      return 0;
         
    }
    
    
    
    
       public List<Utilisateur> searchUtilisateur(String nom) throws SQLException {
        Statement st = cnx.createStatement();
        
      String query = "SELECT * FROM  user where nom_utilisateur like '%"+nom+"%' ";
        ResultSet rst = st.executeQuery(query);
        ArrayList<Utilisateur> userlist = new ArrayList<>();
        while (rst.next()) {
            if(rst.getInt("role")==2)
            {
            Parents p=new Parents();
            Utilisateur u=new Utilisateur();
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
           p.setNom_utilisateur(rst.getString("nom_utilisateur"));
             p.setMot_de_passe(rst.getString("mot_de_passe"));
           p.setNom(rst.getString("nom"));
           p.setPrénom(rst.getString("prénom"));
           p.setAge(rst.getInt("age"));
            p.setStatus(rst.getInt("status"));
           p.setEmail(rst.getString("email"));
           p.setRole(rst.getInt("role"));
             p.setMetier(rst.getString("metier"));
     
           userlist.add(p);
            }
            else if(rst.getInt("role")==1)
            {
            Enseignant p=new Enseignant();
            Utilisateur u=new Utilisateur();
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
           p.setNom_utilisateur(rst.getString("nom_utilisateur"));
             p.setMot_de_passe(rst.getString("mot_de_passe"));
           p.setNom(rst.getString("nom"));
           p.setPrénom(rst.getString("prénom"));
           p.setAge(rst.getInt("age"));
            p.setStatus(rst.getInt("status"));
           p.setEmail(rst.getString("email"));
           p.setRole(rst.getInt("role"));
             p.setSalaire(rst.getInt("salaire"));
         
           userlist.add(p);
            }  
                        else if(rst.getInt("role")==0)
            {
            Enfant p=new Enfant();
            Utilisateur u=new Utilisateur();
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
           p.setNom_utilisateur(rst.getString("nom_utilisateur"));
             p.setMot_de_passe(rst.getString("mot_de_passe"));
           p.setNom(rst.getString("nom"));
           p.setPrénom(rst.getString("prénom"));
           p.setAge(rst.getInt("age"));
            p.setStatus(rst.getInt("status"));
           p.setEmail(rst.getString("email"));
           p.setRole(rst.getInt("role"));
             p.setMoyenne(rst.getInt("moyenne"));
             userlist.add(p);
        
            }  else
                        {
                            
                                 
            Utilisateur p=new Utilisateur();
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
           p.setNom_utilisateur(rst.getString("nom_utilisateur"));
             p.setMot_de_passe(rst.getString("mot_de_passe"));
           p.setNom(rst.getString("nom"));
           p.setPrénom(rst.getString("prénom"));
           p.setAge(rst.getInt("age"));
            p.setStatus(rst.getInt("status"));
           p.setEmail(rst.getString("email"));
           p.setRole(rst.getInt("role"));
               userlist.add(p);
          
                        }
           
            
                
            }
            
            
            
        
        return userlist;
        }
    
    
    
}
