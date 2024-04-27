package com.example.demo.coment.repository;

import com.example.demo.coment.entity.Coment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentRepository extends JpaRepository<Coment, Long> {
}
