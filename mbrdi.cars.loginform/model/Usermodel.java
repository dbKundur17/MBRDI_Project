package mbrdi.cars.loginform.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users-table")
public class Usermodel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String username;
    String password;
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usermodel usermodel = (Usermodel) o;
        return id == usermodel.id && Objects.equals(username, usermodel.username) && Objects.equals(password, usermodel.password) && Objects.equals(email, usermodel.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email);
    }

    @Override
    public String toString() {
        return "Usermodel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
