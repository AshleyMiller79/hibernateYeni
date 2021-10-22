package h3_oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class H3_Save {
	
	public static void main(String[] args) {
		
		
		
		SessionFactory sf=	new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H2_Gunluk.class).
				addAnnotatedClass(H1_Kisi.class).buildSessionFactory();
			    Session session = sf.openSession();
               Transaction tx = session.beginTransaction();
		
		//günluklerin tanımlanması
               
               H2_Gunluk gunluk1=new H2_Gunluk(11,"Salih in günlüğü");
               
               H2_Gunluk gunluk2=new H2_Gunluk(12,"Hakan ın  günlüğü");
		
               H2_Gunluk gunluk3=new H2_Gunluk(13,"Mehmet in günlüğü");
               
       //kişilerin oluşturulması
               
               H1_Kisi kisi1 =new H1_Kisi(101,"Salih Bayram",32);
		       H1_Kisi kisi2 =new H1_Kisi(102,"Hakan Inal",41);
               H1_Kisi kisi3 =new H1_Kisi(103,"Mehmet Ozden",47);
               
               
               gunluk1.setKisi(kisi1);
               gunluk2.setKisi(kisi2);
               gunluk3.setKisi(kisi3);
               
               session.save(gunluk1);
               session.save(gunluk2); 
               session.save(gunluk3); 
               session.save(kisi1);
               session.save(kisi2); 
               session.save(kisi3);
               
               //fetch işlemi
         
   System.out.println( gunluk1.getKisi() +" "+ gunluk1.getYazilar()+" "+kisi2.getKisiYas()+" "+kisi2.getKisiAd());    
               
               
               
               
              tx.commit(); 
               
              sf.close();
              session.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
