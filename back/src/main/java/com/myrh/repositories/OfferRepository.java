package com.myrh.repositories;

import com.myrh.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findAllByCompanyId(Long id);

    @Modifying
    @Query("update Offer o set o.status = :status where o.id=:id")
    void updateOfferStatus(@Param("id") Long id, @Param("status") String status);
}
