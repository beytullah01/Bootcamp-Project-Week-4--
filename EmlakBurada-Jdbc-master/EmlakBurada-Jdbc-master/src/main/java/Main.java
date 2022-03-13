import java.math.BigDecimal;
import java.util.List;

import com.emlakburada.dao.AdvertRepository;
import com.emlakburada.dao.UserRepository;
import com.emlakburada.entity.Advert;
import com.emlakburada.entity.User;

public class Main {

	public static void main(String[] args) {

	

		
		AdvertRepository advertRepository=new AdvertRepository();
		
		advertRepository.saveAdvert(advertPrepare(1, 123, "3+1"));
		advertRepository.saveAdvert(advertPrepare(2, 1243, "2+1"));
		
		
		System.out.println("--find all advert--");

		List<Advert> advert = advertRepository.findAll();

		advert.stream().forEach(user -> System.out.println(user.toString()));

		System.out.println("--find advert--");

		Advert advertFind = advertRepository.findOne(2);

		System.out.println(advertFind.toString());

	}



		private static Advert advertPrepare(int id, int advertNo, String baslik) {
		
		Advert advert = new Advert();

		advert.id = id;
		advert.advertNo = advertNo;
		advert.baslik = baslik;
		

		return advert;
	
}
}