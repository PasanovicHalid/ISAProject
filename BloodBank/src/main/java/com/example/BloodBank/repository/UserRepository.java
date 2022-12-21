package com.example.BloodBank.repository;

import com.example.BloodBank.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from users u where lower(u.firstName) like %?1% or lower(u.lastName) like %?1%")
    Page<User> findAllByFirstNameOrLastName(String searchTerm, Pageable pageable);

    @Query("select u from users u where lower(u.firstName) like %?1% or lower(u.lastName) like %?1%")
    List<User> findAllBySearch(String searchTerm);
    Optional<User> findByUsername(String username);
}
