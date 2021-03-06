package ph.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import ph.model.toRm.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	// public Optional<Student> findById(String id);

}
