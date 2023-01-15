package com.myrh.services;

import com.myrh.models.Offer;
import com.myrh.repositories.OfferRepository;
import com.myrh.utils.Enum;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Repository
@Transactional
public class OfferService {
    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> listAll(){
        return offerRepository.findAll();
    }

    public Offer getOfferById(Long id){
        Optional<Offer> offer = offerRepository.findById(id);
        return offer.orElse(null);
    }

    public List<Offer> listAllAcceptedOffers(){
        return offerRepository.findAll()
                .stream()
                .filter(offer -> Objects.equals(offer.getStatus(), Enum.status.Accepted.toString()))
                .collect(Collectors.toList());
    }

    public Offer getAcceptedOfferById(Long id){
        Optional<Offer> offer = offerRepository.findById(id);
        return offer.filter(o -> o.getStatus().equals(Enum.status.Accepted.toString())).orElse(null);
    }

    public Offer save(Offer offer){
        return offerRepository.save(offer);
    }

    public boolean updateOfferStatus(Long id, String status){
        if(getOfferById(id) != null) {
            offerRepository.updateOfferStatus(id, status);
            return true;
        }
        return false;
    }

    public boolean deleteOffer(Long id){
        if(getOfferById(id) != null){
            offerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Offer> getOffersByCompany(Long companyId){
        return offerRepository.findAllByCompanyId(companyId);
    }
}
