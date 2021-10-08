package com.cours.tpmiagespring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cours.tpmiagespring.entities.Serveur;

@Repository
public interface IServeur extends JpaRepository<Serveur, Long> {

	@Query("SELECT s FROM Serveur s WHERE s.id =:id")
	public Serveur findServeurById(@Param("id")long id);
}
