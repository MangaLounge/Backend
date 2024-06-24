package com.readowo.api.publishing.Repositories;

import com.readowo.api.publishing.Models.Chapters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaptersRepository extends JpaRepository<Chapters, Long> {
}
