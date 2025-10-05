package skillswap.skillswap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skillswap.skillswap.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // custom queries if needed
}
