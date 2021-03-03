/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Interface_service;

import java.sql.SQLException;
import java.util.List;
import projet.entity.Cours;
import projet.entity.Utilisateur;

/**
 *
 * @author shado
 */
public interface Interface_utilisateur {
 
     void add (Utilisateur t) throws SQLException;
    List<Cours> read() throws SQLException;
    void update(Utilisateur t) throws SQLException;
    void delete(Utilisateur t) throws SQLException;
    List<Integer> get_id() throws SQLException;
    boolean login(Utilisateur t);
   public List<Utilisateur> getUtilisateur() throws SQLException;

    
}
