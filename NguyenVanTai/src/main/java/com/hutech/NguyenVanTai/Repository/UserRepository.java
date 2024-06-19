package com.hutech.NguyenVanTai.Repository;

import com.hutech.NguyenVanTai.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}