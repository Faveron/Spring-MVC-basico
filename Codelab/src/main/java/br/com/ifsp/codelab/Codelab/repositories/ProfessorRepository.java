package br.com.ifsp.codelab.Codelab.repositories;

import br.com.ifsp.codelab.Codelab.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> { }