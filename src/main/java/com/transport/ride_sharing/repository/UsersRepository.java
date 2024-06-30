package com.transport.ride_sharing.repository;

import com.transport.ride_sharing.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByName(String name);

    @Query("SELECT u.name, u.fuleSaved FROM Users u")
    List<Object[]> findAllNameAndFuleSaved();
}
