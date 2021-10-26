package h5_manyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name="mirasyediler")
public class H1_Mirasyediler {
	
	@Id
	private int tc;
	
	private String isim;
	
	private int yas;
	
	
	@ManyToMany
	@JoinTable(
			name="H1_Mrsydlr_H2_Arslr",
			joinColumns = {@JoinColumn(name="m_id")},
			inverseJoinColumns= {@JoinColumn(name="a_id")}
			)
	
	private List<H2_Arsalar> arsaListesi=new ArrayList<>();


	
	public H1_Mirasyediler() {}
	public H1_Mirasyediler(int tc, String isim, int yas) {

		this.tc = tc;
		this.isim = isim;
		this.yas = yas;
	}
	public int getTc() {
		return tc;
	}
	public void setTc(int tc) {
		this.tc = tc;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public int getYas() {
		return yas;
	}
	public void setYas(int yas) {
		this.yas = yas;
	}
	public List<H2_Arsalar> getArsaListesi() {
		return arsaListesi;
	}
	public void setArsaListesi(List<H2_Arsalar> arsaListesi) {
		this.arsaListesi = arsaListesi;
	}
	@Override
	public String toString() {
		return "H1_Mirasyediler [tc=" + tc + ", isim=" + isim + ", yas=" + yas + ", arsaListesi=" + arsaListesi + "]";
	}
	
	
	
	
	
	

}
