/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Interface_service;

import java.sql.SQLException;
import java.util.List;
import projet.entity.Classe;
import projet.entity.Utilisateur;

/**
 *
 * @author Espace Info
 */
public interface Interface_class {
       void add (Classe t) throws SQLException;
          public List<Classe> getclasse() throws SQLException;
          public List<Integer> getTeacher() throws SQLException;
     
}
