/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Interface_service;

import java.sql.SQLException;
import java.util.List;
import projet.entity.Concours;

/**
 *
 * @author shado
 */
public interface Interface_concours {

     void add (Concours t) throws SQLException;
    List<Concours> read() throws SQLException;
    void update() throws SQLException;
    void delete(Concours t) throws SQLException;
    List<Integer> get_id() throws SQLException;
   public List<Concours> getConcours() throws SQLException;
   public List<Concours> getConcours2() throws SQLException;
    List<String> get_nom() throws SQLException;
    
}
