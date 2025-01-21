package br.com.service;

import br.com.dao.UserDAO;

/**
 *
 * @author ronaldo neto
 */
public class LoginService {
    
     private final UserDAO userDAO = new UserDAO();
     
     public boolean authenticate(String username, String password){
         return userDAO.validateUser(username, password);
     } 
    
}
