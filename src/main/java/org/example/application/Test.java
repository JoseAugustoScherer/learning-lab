package org.example.application;

import org.example.dao.UserDAO;
import org.example.entitie.User;
import org.example.entitie.enums.Gender;
import org.example.entitie.enums.MaritalStatus;

import java.sql.SQLException;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file Test
 * @since 30/09/2025 - 13:01
 * --------------------
 * This class is a sandbox, it's used to test the methods.
 * This class can be deleted after all tests have been performed.
 * The entry file, is defined in WEB.XML, as long as the program is running with tomcat.
 * --------------------
 */
public class Test {
    public static void main(String[] args) throws SQLException {

        //UserDAO userDAO = new UserDAO();

        //System.out.println(userDAO.findUserByLogin( "admin" ));

        /*
        * -> Creating USER
        **/
        //System.out.println(userDAO.createUser( new User("Test User 1", Gender.getGender(2), MaritalStatus.getMaritalStatus(6), "tst1@gmail.com", "teste1", "admin12345" )));

        /*
        * -> Listing all users (toString in User class return the name, only)
        **/
        //System.out.println( userDAO.getAllUsers() );

        /*
        * -> Deleting User
        * */
        //User userToDelete = new User();
        //userToDelete.setId( 6 );
        //userDAO.deleteUser(userToDelete);


        /*
        * -> Searching users by ID (toString in User class return the name, only)
        * */
        //System.out.println(userDAO.findById( 1 ));
        //System.out.println(userDAO.findById( 2 ));
    }
}
