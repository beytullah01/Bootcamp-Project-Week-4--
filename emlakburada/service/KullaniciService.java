package emlakburada.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import emlakburada.model.Advert;
import emlakburada.model.User;
import emlakburada.repository.DbConnectionRepository;
import emlakburada.repository.IlanRepository;
import emlakburada.repository.UserRepository;

@Service
public class KullaniciService {

	@Autowired
	private UserRepository userRepository;
	
	

	public List<User> getAllUsers() {
	 
		return userRepository.findAll();
	}
	
	public User saveUser(User user) {
		
		Advert ilan=new Advert();
		
		ilan.setAdvertNo(11);
		ilan.setBaslik("favorı eklenen ılanlar");
		
		//Set<Advert> favoriIlanlar = new HashSet<>();
		//favoriIlanlar.add(ilan);
		
		//user.setFavoriIlanlar(favoriIlanlar);
		
		return userRepository.save(user);
		
	}
	
	public User findByIdUser(Integer id) {
		
		return userRepository.getById(id);
		
	}
	
	public User updateUser(User user) {
		
		
		return userRepository.saveAndFlush(user);
	}

	
	public String deleteUser(int id) {
		
		
		userRepository.deleteById(id);
		return "Verilen id'li kisi silinmistir";
	}
}
