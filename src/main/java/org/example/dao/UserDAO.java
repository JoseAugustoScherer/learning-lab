package org.example.dao;

import org.example.dataBase.DataSource;
import org.example.entitie.User;
import org.example.entitie.enums.Gender;
import org.example.entitie.enums.MaritalStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file UserDAO
 * @since 29/09/2025 - 23:31
 * --------------------
 * This class implements the methods used to crate, update, find and delete any existing user in Database.
 * --------------------
 */

public class UserDAO {

    public User createUser( User user ) {
        String sql_query =  "INSERT INTO user" +
                                "( name, gender_code, marital_code, gmail, login, password )" +
                            "VALUES" +
                                "( ?, ?, ?, ?, ?, ? );";

        try ( Connection conn = DataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement( sql_query )){

                stmt.setString( 1, user.getName() );
                stmt.setInt   ( 2, user.getGender().getCode() );
                stmt.setInt   ( 3, user.getMaritalStatus().getCode() );
                stmt.setString( 4, user.getGmail() );
                stmt.setString( 5, user.getLogin() );
                stmt.setString( 6, user.getPassword() );

                stmt.executeUpdate();
                System.out.println( user.getName() + " has been created" );

            } catch ( SQLException e ) {
            throw new RuntimeException( "Error creating user:" + e );
        }
        return user;
    }

    public User updateUser( User user ) {
        String sql_query = "UPDATE user SET name = ?, gender_code = ?, marital_code = ?, gmail = ?, login = ?, password = ? WHERE id = ?";

        try ( Connection conn = DataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement( sql_query )) {

            stmt.setString( 1, user.getName() );
            stmt.setInt   ( 2, user.getGender().getCode() );
            stmt.setInt   ( 3, user.getMaritalStatus().getCode() );
            stmt.setString( 4, user.getGmail() );
            stmt.setString( 5, user.getLogin() );
            stmt.setString( 6, user.getPassword() );
            stmt.setInt   ( 7, user.getId() );

            int affectedRows = stmt.executeUpdate();
            if ( affectedRows > 0 ) {
                System.out.println( "User with ID " + user.getId() + " updated successfully!" );
            } else {
                System.err.println( "No user with ID " + user.getId() );
            }

            stmt.executeUpdate();

        } catch ( SQLException e ) {
            throw new RuntimeException( "Error updating user: " + e );
        }
        return user;
    }

    public void deleteUser( User user ) {
        String sql_query = "DELETE FROM user WHERE id = ?";

        try ( Connection conn = DataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement( sql_query )){

            stmt.setInt ( 1, user.getId() );

            int affectedRows = stmt.executeUpdate();
            if ( affectedRows > 0 ) {
                System.out.println( "User with ID " + user.getId() + " deleted successfully!" );
            } else {
                System.err.println( "No user with ID " + user.getId() );
            }

        } catch ( SQLException e ) {
            throw new RuntimeException( "Error deleting user: " + e );
        }
    }

    public List<User> getAllUsers() {
        String sql_query = "SELECT * FROM user";
        List<User> users = new ArrayList<>();

        try ( Connection conn = DataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement( sql_query ) ) {

            try ( ResultSet rs = stmt.executeQuery() ) {
                while ( rs.next() ) {
                    users.add( mapResultSetToUser( rs ) );
                }
            }

        } catch ( SQLException e ) {
            throw new RuntimeException( "Error getting users: " + e );
        }
        return users;
    }

    // FIND METHODS
    public User findById( int id ) throws SQLException {
        String sql_query = "SELECT * FROM user WHERE id = ?";
        User user = null;

        try ( Connection conn = DataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement( sql_query ) ) {

            stmt.setInt( 1, id );

            try (ResultSet rs = stmt.executeQuery() ) {
                while( rs.next() ) {
                    user = mapResultSetToUser( rs );
                }
            }
        } catch( SQLException e ) {
            throw new RuntimeException( "Error fetching user by ID: " + e );
        }
        if( user == null ) {
            throw new RuntimeException( "No user with ID: " + id + " found" );
        } else {
            return user;
        }

    }

    public User findUserByLogin( String login ) throws SQLException {
        String sql_query = "SELECT * FROM user WHERE login = ?";
        User user = null;

        try ( Connection conn = DataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement( sql_query ) ) {

            stmt.setString( 1, login );
            try ( ResultSet rs = stmt.executeQuery() ) {
                while (rs.next()) {
                    user = mapResultSetToUser(rs);
                }
            }
        } catch ( SQLException e ){
            throw new RuntimeException( "Error fetching user by Login: " + login, e );
        }
        return user;
    }

    private User mapResultSetToUser( ResultSet rs ) throws SQLException {
        return new User(
                rs.getInt   ( "id" ),
                rs.getString( "name" ),
                Gender.getGender( rs.getInt( "gender_code" ) ),
                MaritalStatus.getMaritalStatus( rs.getInt( "marital_code" ) ),
                rs.getString( "gmail" ),
                rs.getString( "login" ),
                rs.getString( "password" )

        );
    }
}
