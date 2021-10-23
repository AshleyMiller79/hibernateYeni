package h6_caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class H3_Save {

	public static void main(String[] args) {
	
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(H1_Developer.class)
				.addAnnotatedClass(H2_Hesap.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	Transaction tx = session.beginTransaction();

		
	H2_Hesap h1=new H2_Hesap(1234,"akbank");
	H2_Hesap h2=new H2_Hesap(1235,"vakıfbank");
	H2_Hesap h3=new H2_Hesap(1236,"garanti");
	H2_Hesap h4=new H2_Hesap(1237,"ziraat");
	
	H1_Developer d1= new H1_Developer(1,"sedef",19);
	H1_Developer d2= new H1_Developer(2,"sabah",29);
	H1_Developer d3= new H1_Developer(3,"kenan",35);
	
	
	h1.setDevelopers(d1);
	
	h2.setDevelopers(d1);
		
	h3.setDevelopers(d3);	

	h4.setDevelopers(d3);
	
	session.save(h1);
	session.save(h2);
	session.save(h3);
	session.save(h4);
	session.save(d1);
	session.save(d2);
	session.save(d3);
	
	
	
	
	
	
	tx.commit();
	}

}
