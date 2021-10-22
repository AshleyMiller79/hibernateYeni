package h3_oneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="kisiler")
public class H1_Kisi {
	
	@Id
	private int kisiId;
	
	private String kisiAd;
	
	private int kisiYas;

	
	@OneToOne(mappedBy = "kisi")
	private H2_Gunluk gunluk;
	
	public H1_Kisi() {};
	public H1_Kisi(int kisiId, String kisiAd, int kisiYas) {
	
		this.kisiId = kisiId;
		this.kisiAd = kisiAd;
		this.kisiYas = kisiYas;
	}
	public int getKisiId() {
		return kisiId;
	}
	public void setKisiId(int kisiId) {
		this.kisiId = kisiId;
	}
	public String getKisiAd() {
		return kisiAd;
	}
	public void setKisiAd(String kisiAd) {
		this.kisiAd = kisiAd;
	}
	public int getKisiYas() {
		return kisiYas;
	}
	public void setKisiYas(int kisiYas) {
		this.kisiYas = kisiYas;
	}
	@Override
	public String toString() {
		return "H1_Kisi [kisiId=" + kisiId + ", kisiAd=" + kisiAd + ", kisiYas=" + kisiYas + "]";
	}
	
	
	
	
	

}
