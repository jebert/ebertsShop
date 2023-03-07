package com.eberts.shop.repositories;

import com.eberts.shop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM User u WHERE u.userName =: userName")
    public User findByUserName (@Param("userName") String userName);


}
