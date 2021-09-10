package com.natixis.chatdonback.repository;

import com.natixis.chatdonback.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long>
{
}
