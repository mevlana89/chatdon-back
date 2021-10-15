package com.natixis.chatdonback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natixis.chatdonback.entity.Adresse;
import com.natixis.chatdonback.entity.Donateur;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse,Long> {

}
