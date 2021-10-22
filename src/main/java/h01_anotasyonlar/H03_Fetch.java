package h01_anotasyonlar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H03_Fetch {

	public static void main(String[] args) {
	
		SessionFactory sf=	new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(H01_Sehir.class).buildSessionFactory();
			    Session session = sf.openSession();
               Transaction tx = session.beginTransaction();
			
		
       System.out.println( session.get(H01_Sehir.class, 34));
       
       
  System.out.println(session.get(H01_Sehir.class, 35).getSehirAd());
               
 // System.out.println(session.get(H01_Sehir.class, "izmir")); id ile çağırabiliyoruz
		
  
  tx.commit();

	}

}
