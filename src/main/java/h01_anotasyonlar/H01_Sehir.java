package h01_anotasyonlar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Transient;

//================================================================
// HIBERNATE ICIN TABLO TANIMLAMASININ YAPILMASI 
//tablo oluşturabilmek için içerik hazırlama )alttakiler)
//POJO: Plain Old Java Object									
//1) Private degiskenler tanimlanir.
//2) constructor olusturulur.
//3) Getter ve Setter metotlar tanimlanir.
//4) toString() metodu ile nesne yazdirilabilir hale getirilir.
//================================================================

/*
	Bir Class Hibernate ile tablo olusturmada kullanilacaksa degiskenlerin
	"final" veya "static" tanimlanMAMAsi gerekir. 
*/


// - @Entity anotasyonu bu class'ın bir tabloya donusturulmesi
//   gerektigini Hibernate'e gosterir.(sql ortamına mapping yapıo uyarlıo,translate) Her bir degisken bir sutun olacaktir.

// - @Table annotasyonu tablo adinin degistirlmesini saglar.javada ve sql deki isimler aynı olmak zorunda değiliz

// - @Id anotasyonu tablo icerisinde primary key olusturur.

// - @Transient anotasyonu bir degiskenin (sutun) tabloda yer almayacagini gosterir.

@Entity //Entity import edilmeli fakat, private bilgileri girmeden entity import edilmiyor
@Table(name="sehir_tablosu")//sql de gözüken ismi, bunu yazmazsak alttaki H1_Sehir ismiyle gözükür
public class H01_Sehir {
	
	@Id //bu sütun primary key demek oluyor (not null ve unique)
	@Column(name="sehir_plaka")	
	private int sehirPlaka;
	
	@Column(name="sehir_ad")	
	private String sehirAd;
	
	
	private int sehirNufus;
	
//	@Transient => bu değişkeni sütun yapma demiş oluyoruz, burada görüp hesap yapıp tabloda görmek istemiyorum
//	private String adres;
	
	public H01_Sehir() {
		
	}//parametresiz cons şart değil
	
	
	public H01_Sehir(int sehirPlaka, String sehirAd, int sehirNufus) {
	this.sehirPlaka = sehirPlaka;
	this.sehirAd = sehirAd;
	this.sehirNufus = sehirNufus;
}


	public int getSehirPlaka() {
		return sehirPlaka;
	}


	public void setSehirId(int sehirPlaka) {
		this.sehirPlaka = sehirPlaka;
	}


	public String getSehirAd() {
		return sehirAd;
	}


	public void setSehirAd(String sehirAd) {
		this.sehirAd = sehirAd;
	}


	public int getSehirNufus() {
		return sehirNufus;
	}


	public void setSehirNufus(int sehirNufus) {
		this.sehirNufus = sehirNufus;
	}


	@Override
	public String toString() {
		return "Sehir:Plaka=" + sehirPlaka + ", Ad=" + sehirAd + ", Nufus=" + sehirNufus ;
	}


	//setter larla bilgi eklemeye uğraşmak yerine parametreli constructor. SOURCE DAN ÇIKIYOR GETTER-SETTER VS

	 //çektiğiniz veriyi console a yazdırmak için
	
}