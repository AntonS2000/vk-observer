package me.weldnor.repository;

import me.weldnor.entity.Revision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionRepository extends JpaRepository<Revision, Long> {
}
