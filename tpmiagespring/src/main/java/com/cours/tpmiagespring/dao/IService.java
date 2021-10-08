package com.cours.tpmiagespring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cours.tpmiagespring.entities.Service;

@Repository
public interface IService extends JpaRepository<Service, Long> {

}
