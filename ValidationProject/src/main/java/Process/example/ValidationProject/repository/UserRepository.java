package Process.example.ValidationProject.repository;

import Process.example.ValidationProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
