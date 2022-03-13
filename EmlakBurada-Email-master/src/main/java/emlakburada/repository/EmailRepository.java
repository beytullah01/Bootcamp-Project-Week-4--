package emlakburada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlakburada.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

	

}
