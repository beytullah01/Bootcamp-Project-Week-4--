package emlakburada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlakburada.model.Advert;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Integer> {

}
