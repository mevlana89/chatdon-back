package com.natixis.chatdonback.repository;
import com.natixis.chatdonback.entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature,Integer> {
    List<Candidature> findCandidaturesByCandidat_Id(Long candidatId);
    List<Candidature> findCandidaturesByChat_Id(Integer ChatId);
        List<Candidature> findAllByChatId(int id);
}