package h4_oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class H4_Fetch {

	public static void main(String[] args) {
		
		SessionFactory sf=	new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H2_Kitap.class).
				addAnnotatedClass(H1_Ogrenci.class).buildSessionFactory();
			    Session session = sf.openSession();
               Transaction tx = session.beginTransaction();
		
		//id=111 olan öğrencinin tüm kitaplarını listeleyin
               
  for (H2_Kitap w :  session.get(H1_Ogrenci.class, 111).getKitapListesi() ) {
	  System.out.println("kitaplar "+ w);
	  
	  
  }
		
		tx.commit();

	}

}
