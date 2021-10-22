package h01_anotasyonlar;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H02_Save {

	public static void main(String[] args) { 

		//İMPORTLARI HİBERNATE OLANDAN yap
		// Veritabani baglanti ayarlarini Hibernate'e gostermeliyiz.hibernate den import et
	//	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Sehir.class);
//		                          //üstteki url lere göre hibernate i (şifre isim vs) ayarla demek//üstteki class ı göz önüne al
//
//		// con objesinden bir oturum grubu oluşturduk.session açıyoruz işimiz bitince kapatıyoruz en altta
//		SessionFactory sf = con.buildSessionFactory();//tüm session ların anası, parent ı, bunun altına bir sürü session oluşturabiliriz,transaction lada açarız

		
	SessionFactory sf=	new Configuration().configure("hibernate.cfg.xml").
			addAnnotatedClass(H01_Sehir.class).buildSessionFactory();
		
		// Oturum grubundan bir oturumu başlattık.
		Session session = sf.openSession();

		// Acilan session icerisinde islemlere baslayabilmek icin Transaction aciyoruz.
		/*Transactionlar ile bir işlem yarıda kaldıysa  veya 
		 * tam olarak tamamlanadıysa tüm adımlar başa alınır
		 * veri ve işlem güvenliği için önemlidir.Kısacası ya hep 
		 * ya hiç prensibine göre çalışır
		 */
		Transaction tx = session.beginTransaction();
		
	
		// ilk burayı yaz,sonra üstleri
		// Tabloya eklenecek verileri (record, kayit) olusturmamız gerekiyor.her run ettiğimizde id ler değiştirilmeli çünkü önceki kalıcı kayıtlı
		H01_Sehir sehir1 = new H01_Sehir(34, "Istanbul", 10000000);

		
		
		//		H1_Sehir sehir2 = new H1_Sehir(38,"Izmir", 2500000);

		// Veritabanina kayitlarin eklenmesi.(kalıcı persistion) bu=> yaz demek, commit=>  yazmayı kesinleştiriyor
		session.save(sehir1);
		
		
		
		//session.save(new H1_Sehir(38, "Istanbul", 10000000));//insert into gibi
		session.save(new H01_Sehir(35,"Izmir", 2500000));

		// İslemlerin veritabanina aktarilmasi(yazmakta fayda var)
		tx.commit();

		// Oturumlarin kapatilmasi
		sf.close(); //bunu kapatınca parent kapamış olur, session açılamaz
		session.close();//kapattıktan sonra işlem yapılmaz, yapmak istersek tekrar session lar açmalıyız
	}

}
