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
import projet.Interface_service.Interface_concours;
import projet.entity.Concours;
import projet.utils.Database;

/**
 *
 * @author shado
 */
public class Service_concours implements Interface_concours{

  Connection cnx ;
    public Service_concours() {
         cnx = Database.getInstance().getConn();
       
    }
    @Override
    public void add(Concours t) throws SQLException {
          Statement st = cnx.createStatement();
    //    String req = "insert into personne values ("+p.getId()+" , " +p.getNom()+ ", " +p.getPrenom() +")";
          String req =" insert into concours ( nom_concours,id_class,prix,date_debut,date_fin ) values ( '"+t.getNom_concours()+"','"+t.getId_class()+"','"+t.getPrix()+"','"+t.getDate_debut()+"','"+t.getDate_fin()+"' )"; 
    st.executeUpdate(req);       
    }
    @Override
    public List<Concours> read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Concours t) throws SQLException {
         PreparedStatement st = cnx.prepareStatement("update concours set nom_concours = ? , prix = ? , date_debut = ? , date_fin = ?  where id_concours = ? ");
      st.setString(1,t.getNom_concours());
      st.setInt(2,t.getPrix());
      st.setString(3,String.valueOf(t.getDate_debut()));
      st.setString(4,String.valueOf(t.getDate_fin()));
      st.setInt(5,t.getId_concours());
   
        st.executeUpdate();
    }

    @Override
    public void delete(Concours t) throws SQLException {
             PreparedStatement pt = cnx.prepareStatement("delete from concours where id_concours = ?");
        pt.setInt(1,t.getId_concours());
        pt.executeUpdate();
    }

    @Override
    public List<Integer> get_id() throws SQLException {
                    Statement st = cnx.createStatement();
        
       int i=0;
        String query = "SELECT id_concours FROM  `concours` ";
         ResultSet rst = st.executeQuery(query);
      ArrayList<Integer> T=new ArrayList<>();
       while (rst.next())
       {
           T.add(rst.getInt("id_concours"));
         
       }
      return T; 
    }

    @Override
    public List<Concours> getConcours() throws SQLException {
                       Statement st = cnx.createStatement();
        
       
        String query = "SELECT * FROM  `concours` ";
        ResultSet rst = st.executeQuery(query);
        List<Concours> co = new ArrayList<>();
        while (rst.next()) {
           
             Concours c = new Concours();
             c.setId_concours(rst.getInt("id_concours"));
             c.setNom_concours(rst.getString("nom_concours"));
             c.setId_class(rst.getInt("id_class"));
             c.setDate_debut(LocalDate.parse(rst.getString("date_debut")));
           c.setDate_fin(LocalDate.parse(rst.getString("date_fin")));
           System.out.println(c);
            co.add(c);
            
        }
        return co;
    }
        public List<Concours> SearchConcours(String id) throws SQLException {
                       Statement st = cnx.createStatement();
        
       
        String query = "SELECT * FROM  `concours` where nom_concours like '%"+id+"%' ";
        ResultSet rst = st.executeQuery(query);
        List<Concours> co = new ArrayList<>();
        while (rst.next()) {
           
             Concours c = new Concours();
             c.setId_concours(rst.getInt("id_concours"));
             c.setNom_concours(rst.getString("nom_concours"));
             c.setId_class(rst.getInt("id_class"));
             c.setDate_debut(LocalDate.parse(rst.getString("date_debut")));
           c.setDate_fin(LocalDate.parse(rst.getString("date_fin")));
           System.out.println(c);
            co.add(c);
            
        }
        return co;
    }
    
    
    
    
    
    

    @Override
    public List<Concours> getConcours2() throws SQLException {
                             Statement st = cnx.createStatement();
        
       
        String query = "SELECT * FROM  `concours` ";
        ResultSet rst = st.executeQuery(query);
        List<Concours> co = new ArrayList<>();
        while (rst.next()) {
           
             Concours c = new Concours();
             c.setNom_concours(rst.getString("nom_concours"));
             c.setId_class(rst.getInt("id_class"));
             c.setDate_debut(LocalDate.parse(rst.getString("date_debut")));
           c.setDate_fin(LocalDate.parse(rst.getString("date_fin")));
           System.out.println(c);
            co.add(c);
            
        }
        return co;
    }

  @Override
    public ArrayList<String> get_nom() throws SQLException {
                    Statement st = cnx.createStatement();
        
       int i=0;
        String query = "SELECT nom_concours FROM  `concours` ";
         ResultSet rst = st.executeQuery(query);
      ArrayList<String> T=new ArrayList<>();
       while (rst.next())
       {
           T.add(rst.getString("nom_concours"));
         
       }
      return T; 
    }
    
}
