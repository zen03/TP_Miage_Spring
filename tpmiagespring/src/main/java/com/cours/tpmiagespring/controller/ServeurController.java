package com.cours.tpmiagespring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cours.tpmiagespring.dao.IServeur;
import com.cours.tpmiagespring.entities.Serveur;

@Controller
public class ServeurController {

	@Autowired
	private IServeur serveurdao;
	
	@RequestMapping(value="/Serveur/liste")
	public ModelAndView liste() {
		List<Serveur> serveurs = serveurdao.findAll();
		
		return new ModelAndView("serveur/liste", "liste_serveurs", serveurs);
	}
	
	@RequestMapping(value="/Serveur/Fadd")
	public String add() {
		return "serveur/add";//pour le chargement du formulaire d'ajout : add.html
	}
	
	@RequestMapping(value="/Serveur/add")
	public String add(String nomServ, String adripServ) {
		//insertion dans la base des données venant du formulaire
		Serveur serveur = new Serveur();
		serveur.setNomServ(nomServ);
		serveur.setAdripServ(adripServ);
		serveurdao.save(serveur);
		//Redirection vers la page d'affichage : liste.html
		return "redirect:/Serveur/liste";
	}
	
	
	@RequestMapping(value="/Serveur/delete", method=RequestMethod.GET)
	public String delete(int id){
		try {
			Serveur serveur = serveurdao.findServeurById((long)id);
			serveurdao.delete(serveur);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "redirect:/Serveur/liste";
	}
	@RequestMapping(value="/Serveur/edit", method=RequestMethod.GET)
	public ModelAndView edit(int id){
		Serveur serveur = null;
		try {
			serveur = serveurdao.findServeurById((long)id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("serveur/edit", "serveur", serveur);
	}
}
