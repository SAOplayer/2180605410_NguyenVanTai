package com.hutech.NguyenVanTai.Repository;

import com.hutech.NguyenVanTai.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,String>{
    Optional<User> findByUsername(String username);
}