package com.example.MyUsers.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
}
