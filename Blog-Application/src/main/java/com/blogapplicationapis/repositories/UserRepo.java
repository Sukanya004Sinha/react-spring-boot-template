package com.blogapplicationapis.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.blogapplicationapis.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
