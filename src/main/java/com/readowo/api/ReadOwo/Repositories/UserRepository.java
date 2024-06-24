package com.readowo.api.ReadOwo.Repositories;

import com.readowo.api.ReadOwo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
