package h7_crudIslemleri;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CrudMetodlar {
	
	//SQL komutları gözükmesin cfg.xml de sql i false yap ancache yi false yap, max size hatası almamak için
	//pool u kapat. burada çok veri göndereceğimizden korkup exception fırlatır yoksa
	
	
	private static SessionFactory factory;//burada yazdıkki bütün metodlarda kullanabilelim. bunu her işlemde çalıştırıyorduk,
	//metod olunca ancak class levelda olursa kullanabiliriz, diğer günlerde metod yoktu
	//rahat rahat session kullandık 
	
	public void sessionFactoryOlustur() {
	
		try {//aşagıdaki komutlar dıştan gelen, o yüzden ya oluşturamazsam diye try catch yaparız
			Configuration con = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Personel.class);
				
			//SessionFactory factory=con.buildSessionFactory(); normalde böyle ama heryerde kullanabilelim
			//diye global 13. satırda oluşturduk, factory ismiyle her yerde kullanabiliriz..static yaptık ki main de kullanılsın
			factory = con.buildSessionFactory();
			
		}catch(Throwable e){
			System.err.println("Session grubu olusturulurken hata olustu "+ e);
			throw new ExceptionInInitializerError(e);//istersek bunu yazarız başlatma hatası
		}
	}
	
	// Veritabanına bir personel ekleyen metot (Create).büyük harfle Long=>null atayabilmek için nonprimitive
	public void personelEkle(String ad, String soyad, int maas){
		
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); 
			Personel personel = new Personel(ad,soyad,maas);
			
			session.save(personel);
			tx.commit();
			System.out.println("oldu");
		
		}catch(HibernateException e){
			//yapilan islemde bir hata oldu ise, veri gönderilince tx boşalır, gönderilemezse içinde veri olur=null değil
			if(tx != null) {
				tx.rollback(); // islemi geri al
			}
			e.printStackTrace();//exception olan tam satırı göster
		} finally {//herhalukarda çalış demek finally
			session.close();
		}
	//	return personelId;
	}
	
	
	
	
	
	// Veritabanindan bir personeli silen metot(Delete)
	public void  personelSil(long personelId) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Personel personel = session.get(Personel.class, personelId);
			if(personel == null) {
				System.out.println(personelId + " nolu kisinin kaydi bulunamamistir.");
			}else {
				session.delete(personel);
				tx.commit(); //önce silinmeyi kaydet sonra syso ile göster
				System.out.println(personelId + " nolu kisinin kaydi silinmistir.");
				System.out.println("Silinen:" + personel);
			}
			
		}catch(HibernateException e) {
			//yapilan islemde bir hata oldu ise 
			if(tx != null) {
				tx.rollback(); // islemi geri al
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//Veritabanindaki tum kayitlari listeleyen metot (READ)
	public void tumPersoneliListele() {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			//bütün kişilerin listesini almak jpa da uzun, o yüzden HQL ile yazdık
			
//			System.out.println(session.createQuery("FROM Personel").getResultList());
			//	üstteki gibi yazdırırsak tek sıra yazıyor, liste olsun diye alttaki gibi
			List<Personel> personeller = session.createQuery("FROM Personel").getResultList();
			System.out.println("************* TUM PERSONELIN LISTESI *****************");
	     	personeller.stream().forEach((p)-> System.out.println(p));
				
			tx.commit();
		}catch(HibernateException e) {
			//yapilan islemde bir hata oldu ise 
			if(tx != null) {
				tx.rollback(); // islemi geri al
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	
	
	//id ile bir kaydin maas bilgisini guncelleyen metot (UPDATE)
		public void maasGuncelle(long personelId, int maas) {
			Session session = factory.openSession();
			Transaction tx = null;
				
			try {
				tx = session.beginTransaction();
				Personel personel = session.get(Personel.class, personelId);
				System.out.println("******** "+ personelId + " ID'li Personelin Maas Guncellemesi ***********");
				if(personel == null) {
					System.out.println(personelId + " nolu kisinin kaydi bulunamamistir.");
				}else {
					personel.setMaas(maas);//set le tablodaki veriyi güncelleyebiliyoruz
					tx.commit();
					System.out.println(personelId + " nolu personelin yeni maasi : "+ maas);
				}
			}catch(HibernateException e) {
				//yapilan islemde bir hata oldu ise 
				if(tx != null) {
					tx.rollback(); // islemi geri al
				}
				e.printStackTrace();
			}finally {
				session.close();
			}
		}
		
	

}