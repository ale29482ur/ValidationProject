package Process.example.ValidationProject.repository;

import Process.example.ValidationProject.model.Process;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessRepository extends JpaRepository<Process, Long> {
}
