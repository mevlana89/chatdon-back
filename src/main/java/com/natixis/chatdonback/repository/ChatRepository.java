package com.natixis.chatdonback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natixis.chatdonback.entity.Chat;

import java.util.Collection;
import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
    List<Chat> findAllByCategorieAgeContainingAndRaceContainingAndSexeContainingAndTailleContainingAndPelageContainingAndCaractereContainingAndSociableChatInAndSociableChienInAndSociableEnfantInAndZoneGeoContaining
            (String categorieAge, String race, String sexe, String taille, String pelage, String caractere, Collection<Boolean> sociableChat, Collection<Boolean> sociableChien, Collection<Boolean> sociableEnfant, String zoneGeo);

    List<Chat> findAllByCategorieAgeContainingAndRaceContainingAndSexeContainingAndTailleInAndPelageContainingAndCaractereInAndSociableChatInAndSociableChienInAndSociableEnfantInAndZoneGeoContaining
            (String categorieAge, String race, String sexe, Collection <String> taille, String pelage, Collection <String> caractere, Collection<Boolean> sociableChat, Collection<Boolean> sociableChien, Collection<Boolean> sociableEnfant, String zoneGeo);

}
