package com.mti.web_jpa_security_mysql.repository;

import com.mti.web_jpa_security_mysql.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
