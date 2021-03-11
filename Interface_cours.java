/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Interface_service;


import java.sql.SQLException;
import java.util.List;
import projet.entity.Cours;

/**
 *
 * @author shado
 */
public interface Interface_cours {
     void add (Cours t) throws SQLException;
    List<Cours> read() throws SQLException;
    void update(Cours t) throws SQLException;
    void delete(Cours t) throws SQLException;
    List<Integer> get_id() throws SQLException;
   public List<Cours> getCours() throws SQLException;
}
