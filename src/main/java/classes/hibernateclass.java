package classes;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class hibernateclass {

	 public static void addAeroport(Aeroport r){
		 org.hibernate.Session
		 session=HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 session.save(r);
		 session.getTransaction().commit();
		 }
	 public static void addAvion(Avion r){
		 org.hibernate.Session
		 session=HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 session.save(r);
		 session.getTransaction().commit();
		 }
	 public static void addVol(Vol r){
		 org.hibernate.Session
		 session=HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 session.save(r);
		 session.getTransaction().commit();
		 }
	 
	 public static void main(String[] args) {
		 List<Integer> distances=new ArrayList<>();
	        Point point=new Point();
	        List<Avion> avions1=new ArrayList<>();
	       
		 
		 Aeroport AéroportA =new Aeroport(1,"AeroportA", "6301 Silver Dart Dr, Mississauga, ON L5P 1B2, Canada", 
			        5, 8, 20, 10, 12, 20,
			         12, 10);
		 Aeroport AéroportB =new Aeroport(2,"AeroportB", "Rte de Trégastel, 22300 Lannion, France", 
			        9, 9, 20, 10, 12, 20,
			         12, 10);

			         Aeroport AéroportC =new Aeroport(3,"AeroportC", "Victoria, Araucania, Chili", 
			        7, 16, 20, 10, 12, 20,
			         12, 10);

			         Aeroport AéroportD =new Aeroport(4,"AeroportD", "23737 Ciudad Constitución, Baja California Sur, Mexique", 
			        16, 6, 20, 10, 12, 20,
			         12, 10);

			         Aeroport AéroportE =new Aeroport(5,"AeroportE", "386 Yeosun-ro, Yulchon-myeon, Yeosu-si, Jeollanam-do, Corée du Sud", 
			        18, 13, 20, 10, 12, 20,
			         12, 10);

			         Aeroport AéroportF =new Aeroport(6,"AeroportF", "Muş Merkez/Muş, Turquie", 
			        3, 15, 20, 10, 12, 20,
			         12, 10);
		 
		 
		 
		 
		  hibernateclass hib=new hibernateclass();
	       hib.addAeroport(AéroportA);
	       hib.addAeroport(AéroportB);
	       hib.addAeroport(AéroportC);
	       hib.addAeroport(AéroportD);
	       hib.addAeroport(AéroportE);
	       hib.addAeroport(AéroportF);
	       
	       
	   
	       
	       
	       
	       
	       
	       
	       
	       Avion avion1=new Avion(1,"short",15,40,AéroportA);
	       hib.addAvion(avion1);
	       Avion avion2=new Avion(2,"long",16,50,AéroportA);
	       hib.addAvion(avion2);
	         Avion avion12=new Avion(3,"middle",12,60,AéroportB);
	         hib.addAvion(avion12);
	         Avion avion122=new Avion(4,"long",15,60,AéroportB);
	         hib.addAvion(avion122);
	         Avion avion13=new Avion(5,"short",26,70,AéroportC);
	         hib.addAvion(avion13);
	         Avion avion133=new Avion(6,"long",15,40,AéroportC);
	         hib.addAvion(avion133);
	         Avion avion14=new Avion(7,"middle",15,60,AéroportD);
	         hib.addAvion(avion14);
	         Avion avion144=new Avion(8,"short",15,90,AéroportD);
	         hib.addAvion(avion144);
	         Avion avion15=new Avion(9,"long",12,100,AéroportE);
	         hib.addAvion(avion15);
	         Avion avion155=new Avion(10,"middle",10,120,AéroportE);
	         hib.addAvion(avion155);
	         Avion avion16=new Avion(11,"long",16,40,AéroportF);
	         hib.addAvion(avion16);
	         Avion avion166=new Avion(12,"short",19,50,AéroportF);
	         hib.addAvion(avion166);
	       
	       
			// avions1.add(avion1);
	         
	      
	         
	        
	         List<Avion> avions2=new ArrayList<>();
	         List<Avion> avions3=new ArrayList<>();
	         List<Avion> avions4=new ArrayList<>();
	         List<Avion> avions5=new ArrayList<>();
	         List<Avion> avions6=new ArrayList<>();
	         
	         
	         avions1.add(avion1);
	         avions1.add(avion2);
	         AéroportA.setAvions(avions1);
	         
	         avions2.add(avion12);
	         avions2.add(avion122);
	         AéroportB.setAvions(avions2);
	         
	         avions3.add(avion13);
	         avions3.add(avion133);
	         AéroportC.setAvions(avions3);
	         
	         avions4.add(avion14);
	         avions4.add(avion144);
	         AéroportD.setAvions(avions4);
	         
	         avions5.add(avion15);
	         avions5.add(avion155);
	         AéroportE.setAvions(avions5);
	         
	         avions6.add(avion16);
	         avions6.add(avion166);  
	         AéroportF.setAvions(avions6);
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       Vol vol1=new Vol(1,AéroportB.getIdaeroport(),AéroportD.getIdaeroport(),50,2,4,AéroportB.getAvions().get(0));
           
	       hib.addVol(vol1);
	       Vol vol2=new Vol(2,AéroportC.getIdaeroport(),AéroportE.getIdaeroport(),70,5,6,AéroportC.getAvions().get(0));
	       hib.addVol(vol2);
	       Vol vol3=new Vol(3,AéroportF.getIdaeroport(),AéroportB.getIdaeroport(),120,6,7,AéroportF.getAvions().get(0));
	       hib.addVol(vol3);
	       
	       Vol vol4=new Vol(4,AéroportA.getIdaeroport(),AéroportE.getIdaeroport(),150,9,10,AéroportA.getAvions().get(0));
	       hib.addVol(vol4);
	       
	       Vol vol5=new Vol(5,AéroportD.getIdaeroport(),AéroportF.getIdaeroport(),140,3,8,AéroportD.getAvions().get(0));
	       hib.addVol(vol5);
	      
	     
	 }
	 
}





