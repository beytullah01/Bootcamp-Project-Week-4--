package emlakburada.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlakburada.model.Advert;
import emlakburada.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	

}
