package org.example.entitie;

import org.example.entitie.enums.Gender;
import org.example.entitie.enums.MaritalStatus;

import java.util.Objects;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file User
 * @since 29/09/2025 - 23:16
 * --------------------
 * [ BRIEF DESCRIPTION OF THE CLASS PURPOSE GOES HERE ]
 * --------------------
 * --------------------
 * Reference documentation:
 * - [ Link to documentation, if any ]
 * --------------------
 */
public class User extends Person{

    private String gmail;
    private String login;
    private String password;

    public User() {
        super();
    }

    //Without ID
    public User(String name, Gender gender, MaritalStatus maritalStatus, String gmail, String login, String password) {
        super(name, gender, maritalStatus);
        this.gmail = gmail;
        this.login = login;
        this.password = password;
    }

    public User(Integer id, String name, Gender gender, MaritalStatus maritalStatus, String gmail, String login, String password) {
        super(id, name, gender, maritalStatus);
        this.gmail = gmail;
        this.login = login;
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(gmail, user.gmail) && Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gmail, login);
    }

    @Override
    public String toString() {
        return getName();
    }
}
