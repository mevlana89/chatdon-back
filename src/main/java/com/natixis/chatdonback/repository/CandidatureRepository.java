package com.natixis.chatdonback.repository;
import com.natixis.chatdonback.entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature,Long> {
    List<Candidature> findAllByChatId(int id);
}
