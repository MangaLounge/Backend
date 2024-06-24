package com.readowo.api.publishing.Repositories;

import com.readowo.api.publishing.Models.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookGenreRepository extends JpaRepository<BookGenre,Long> {
}
