package emlakburada.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="adverts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Advert  {
	
	@Id
	@Column(name="advert_id")
	private int advertId;
	
	private int advertNo;
	//private RealEstate gayrimenkul;
	private String baslik;
	
	
	

	@ManyToOne
	@JoinColumn(name = "ua_fk")
	private User user; // hem bireysel & kurumsal
	//private String[] resimList = new String[5];
	private BigDecimal fiyat;
	private int suresi;
	private boolean oneCikarilsinMi = false;
	private boolean incelendiMi = false;
	private Date olusturulmaTarihi;
	private boolean aktifMi;
	



}
