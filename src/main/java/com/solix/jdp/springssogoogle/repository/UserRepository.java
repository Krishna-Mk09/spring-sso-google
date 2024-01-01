package com.solix.jdp.springssogoogle.repository;

import com.solix.jdp.springssogoogle.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
