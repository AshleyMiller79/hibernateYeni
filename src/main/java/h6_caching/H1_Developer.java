package h6_caching;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="devler")
@Cacheable
@Cache(region="H1_Developer", usage=CacheConcurrencyStrategy.READ_WRITE)
public class H1_Developer {
	
	
	@Id
	private int devId;
	
	private String devAd;
	
	private int devYas;
	
	@OneToMany(mappedBy = "developers")
	private List <H2_Hesap> bankaListe = new ArrayList<>();
	
	
	public H1_Developer() {};
	
	public H1_Developer(int devId, String devAd, int devYas) {
	
		this.devId = devId;
		this.devAd = devAd;
		this.devYas = devYas;
	}

	public int getDevId() {
		return devId;
	}

	public void setDevId(int devId) {
		this.devId = devId;
	}

	public String getDevAd() {
		return devAd;
	}

	public void setDevAd(String devAd) {
		this.devAd = devAd;
	}

	public int getDevYas() {
		return devYas;
	}

	public void setDevYas(int devYas) {
		this.devYas = devYas;
	}

	public List<H2_Hesap> getBankaListe() {
		return bankaListe;
	}

	public void setBankaListe(List<H2_Hesap> bankaListe) {
		this.bankaListe = bankaListe;
	}

//	@Override
//	public String toString() {
//		return "H1_Developer [devId=" + devId + ", devAd=" + devAd + ", devYas=" + devYas + ", bankaListe=" + bankaListe
//				+ "]";
//	}

	@Override
	public String toString() {
		return "H1_Developer [devId=" + devId + ", devAd=" + devAd + ", devYas=" + devYas
				+ "]";
	}
	
	
	
	
	
	
	

}
