package com.natixis.chatdonback.repository;
import com.natixis.chatdonback.entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature,Long> {}
