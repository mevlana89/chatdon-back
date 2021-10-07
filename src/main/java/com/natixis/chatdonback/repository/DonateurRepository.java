package com.natixis.chatdonback.repository;

import org.springframework.stereotype.Repository;
import com.natixis.chatdonback.entity.Donateur;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DonateurRepository extends JpaRepository<Donateur,Long> {

    Donateur getDonateurByMail(String nom);
}
