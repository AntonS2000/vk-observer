package me.weldnor.repository;

import me.weldnor.entity.TrackedUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackedUserRepository extends JpaRepository<TrackedUser, Long> {
    Optional<TrackedUser> findByUsername(String username);
}
