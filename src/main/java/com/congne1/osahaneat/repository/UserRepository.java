package com.congne1.osahaneat.repository;

import com.congne1.osahaneat.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findByUserNameAndPassword(String username, String password);

    Users findByUserName(String userName);

}
