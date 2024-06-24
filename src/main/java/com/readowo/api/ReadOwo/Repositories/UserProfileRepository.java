package com.readowo.api.ReadOwo.Repositories;

import com.readowo.api.ReadOwo.Models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
}
