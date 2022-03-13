package emlakburada.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import emlakburada.client.BannerClientOpenFeign;

import emlakburada.dto.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.model.Advert;
import emlakburada.model.EmailMessage;
import emlakburada.model.RealEstate;
import emlakburada.model.User;
import emlakburada.queue.QueueService;
import emlakburada.repository.AdvertRepository;
import emlakburada.repository.DbConnectionRepository;
import emlakburada.repository.IlanRepository;

@Service
public class AdvertService {

	@Autowired
	private AdvertRepository advertRepository;

	@Autowired
	@Qualifier(value = "jdbcConnectionRepository")
	private DbConnectionRepository dbConn;

	@Autowired
	private KullaniciService kullaniciService;

	@Autowired
	private BannerClientOpenFeign bannerClientOpenFeign;

	@Autowired
	private BannerClientService bannerBannerClientService;

	private static int advertNo = 38164784;

	@Autowired
	QueueService queueService;

	public List<AdvertResponse> getAllAdverts() {

		List<AdvertResponse> advertList = new ArrayList<>();
		for (Advert advert : advertRepository.findAll()) {
			advertList.add(convertToAdvertResponse(advert));
		}
		return advertList;
	}

	public AdvertResponse saveAdvert(AdvertRequest request) {
		Advert savedAdvert = advertRepository.save(convertToAdvert(request));
		final EmailMessage emailMessage = new EmailMessage();
		emailMessage.setEmail(savedAdvert.getUser().getEmail());

		 bannerClientOpenFeign.saveBanner(bannerBannerClientService.prepareBanner());

		queueService.sendMessage(emailMessage.getEmail().toString());
		return convertToAdvertResponse(savedAdvert);
	}

	private AdvertResponse convertToAdvertResponse(Advert savedAdvert) {
		AdvertResponse response = new AdvertResponse();
		response.setBaslik(savedAdvert.getBaslik());
		response.setFiyat(savedAdvert.getFiyat());
		response.setAdvertNo(savedAdvert.getAdvertNo());
		response.setUser(savedAdvert.getUser());
		response.setSuresi(savedAdvert.getSuresi());
		response.setOlusturulmaTarihi(savedAdvert.getOlusturulmaTarihi());

		return response;
	}

	private Advert convertToAdvert(AdvertRequest request) {
		Advert advert = new Advert();
		advertNo++;

		advert.setAdvertNo(advertNo);
		advert.setBaslik(request.getBaslik());
		advert.setFiyat(request.getFiyat());
		advert.setUser(kullaniciService.findByIdUser(request.getUser().getId()));
		advert.setSuresi(request.getSuresi());
		advert.setOlusturulmaTarihi(request.getCreatedDate());

		return advert;
	}

	public AdvertResponse getAdvertByAdvertId(int advertId) {
		Advert advert = advertRepository.getById(advertId);
		return convertToAdvertResponse(advert);
	}

}
