package emlakburada.dto;

import java.math.BigDecimal;
import java.sql.Date;

import emlakburada.model.Address;
import emlakburada.model.User;
import lombok.Data;

@Data
public class AdvertRequest {

	private String baslik;
	private BigDecimal fiyat;
	private int suresi;
	private User user;
	private Date createdDate;
	private boolean oneCikarilsinMi = false;
	private boolean incelendiMi = false;
	private boolean aktifMi;
	private Address address;
}
