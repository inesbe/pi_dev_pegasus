/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Interface_service;

import java.sql.SQLException;
import java.util.List;
import projet.entity.Classe;
import projet.entity.commentaire;

/**
 *
 * @author Espace Info
 */
public interface Interface_commentaire {
    void add (commentaire t) throws SQLException;
    public List<commentaire> getcommentaire() throws SQLException;
    public List<Integer> getId_commentaire() throws SQLException ;
    void delete(commentaire  t) throws SQLException;
    void update(commentaire t) throws SQLException;
    
}
