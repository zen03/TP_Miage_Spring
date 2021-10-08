package com.cours.tpmiagespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cours.tpmiagespring.dao.IServeur;
import com.cours.tpmiagespring.dao.IService;
import com.cours.tpmiagespring.entities.Serveur;

@SpringBootApplication
public class TpmiagespringApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TpmiagespringApplication.class, args);
		//Gestion de l'injection de dépendance par spring
		IServeur serveurdao = ctx.getBean(IServeur.class);
		IService servicedao = ctx.getBean(IService.class);
		//ajout
		Serveur s = new Serveur();
		s.setId((long)4);
		s.setNomServ("ISI 2");
		s.setAdripServ("192.72.10.15");
		serveurdao.save(s);
		//liste
		System.out.println("Liste des serveurs" + serveurdao.findAll().size());
	}
}
