package br.com.server.domain.format;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassFormatRepository extends JpaRepository<ClassFormat, Long> {

  Page<ClassFormat> findAllByUserId(Pageable pageable, Long user_id);
}
