package mbrdi.cars.loginform.repository;

import mbrdi.cars.loginform.model.Usermodel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usermodel, Integer> {

    Optional<Usermodel> findByLoginAndPassword(String username, String password);
}
