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
    
          String req =" insert into concours ( nom_concours,prix,date_debut,date_fin ) values ( '"+t.getNom_concours()+"','"+t.getPrix()+"','"+t.getDate_debut()+"','"+t.getDate_fin()+"' )"; 
    st.executeUpdate(req);       
    }
    @Override
    public List<Concours> read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() throws SQLException {
       PreparedStatement pt = cnx.prepareStatement("update concours set is_done=1 where is_done=0");
  
        pt.executeUpdate(); 
    }

    
        public void update2() throws SQLException {
       PreparedStatement pt = cnx.prepareStatement("update concours set is_done=2 where is_done=1");
  
        pt.executeUpdate(); 
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
     c.setPrix(rst.getInt("prix"));
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
    
   public int get_concours() throws SQLException
            
    {  
        int n=0;
        Statement st = cnx.createStatement();
      String query = "SELECT * FROM  `concours` where is_done=0 ";
         ResultSet rst = st.executeQuery(query);
        while (rst.next()) {
          n++;
      }
        return n;
    }
      public int get_concours_finish() throws SQLException
            
    {  
        int n=0;
        Statement st = cnx.createStatement();
      String query = "SELECT * FROM  `concours` where is_done=1 ";
         ResultSet rst = st.executeQuery(query);
        while (rst.next()) {
          n++;
      }
        return n;
    }
       public int get_concours_id() throws SQLException
            
    {  
        int n=0;
        Statement st = cnx.createStatement();
      String query = "SELECT * FROM  `concours` where is_done=0 ";
         ResultSet rst = st.executeQuery(query);
        while (rst.next()) {
         n=rst.getInt("id_concours");
      }
        return n;
    }
        public int get_concours_finish_id() throws SQLException
            
    {  
        int n=0;
        Statement st = cnx.createStatement();
      String query = "SELECT * FROM  `concours` where is_done=1 ";
         ResultSet rst = st.executeQuery(query);
        while (rst.next()) {
         n=rst.getInt("id_concours");
      }
        return n;
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
    public int date_is_valid() throws SQLException
    {        LocalDate d=LocalDate.now();
    int n=0;
              Statement st = cnx.createStatement();
        String query = "SELECT * FROM  `concours` where date_fin > '"+d+"' and is_done=0  ";
        ResultSet rst = st.executeQuery(query);    
        
        while(rst.next())
        {
         n++;   
        }
        return n;
    }
      public int ongoing_is_compt() throws SQLException
    {      int n=0;
  
              Statement st = cnx.createStatement();
        String query = "SELECT * FROM  `concours` where is_done=1 or is_done=0  ";
        ResultSet rst = st.executeQuery(query);    
        
        while(rst.next())
        {
         n++;   
        }
        return n;
    }
    
}
