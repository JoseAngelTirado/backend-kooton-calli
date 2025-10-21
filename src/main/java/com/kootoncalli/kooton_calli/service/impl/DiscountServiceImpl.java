package com.kootoncalli.kooton_calli.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kootoncalli.kooton_calli.dto.DiscountDto;
import com.kootoncalli.kooton_calli.model.Discount;
import com.kootoncalli.kooton_calli.repository.DiscountRepository;
import com.kootoncalli.kooton_calli.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    
    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public DiscountDto save(DiscountDto discountDto) {
        discountDto.setId(null);
        Discount discountToSave = discountDtoToDiscount(discountDto);
        Discount createdDiscount = discountRepository.save(discountToSave);
        return discountToDiscountDto(createdDiscount);
    }

    private Discount discountDtoToDiscount(DiscountDto discountDto){
        Discount discount = new Discount();
        discount.setId(discountDto.getId());
        discount.setDiscountName(discountDto.getDiscountName());
        discount.setDiscountAmount(discountDto.getDiscountAmount());
        discount.setDiscountStartDate(discountDto.getDiscountStartDate());
        discount.setDiscountEndDate(discountDto.getDiscountEndDate());
        return discount;
    }

    private DiscountDto discountToDiscountDto(Discount discount){
        DiscountDto discountDto = new DiscountDto(
            discount.getId(),
            discount.getDiscountName(),
            discount.getDiscountAmount(),
            discount.getDiscountStartDate(),
            discount.getDiscountEndDate()
        );
        return discountDto;
    }

    @Override
    public DiscountDto findById(Integer id) {
        Optional<Discount> discountOptional = discountRepository.findById(id);
        if(discountOptional.isEmpty()){
            throw new IllegalStateException("Discount does not exist id: "+ id);
            }
            Discount existingDiscount = discountOptional.get();
            return discountToDiscountDto(existingDiscount);
        }

    @Override
    public Iterable<DiscountDto> findAll() {
        List<DiscountDto> discountsDto = new ArrayList<>();
        Iterable<Discount> discounts = discountRepository.findAll();
        for(Discount discount: discounts){
            DiscountDto discountDto = new DiscountDto(discount.getId(), discount.getDiscountName(), discount.getDiscountAmount(), discount.getDiscountStartDate(), discount.getDiscountEndDate());
            discountsDto.add(discountDto);
        }
        return discountsDto;
    }

    @Override
    public DiscountDto update(Integer id, DiscountDto discountDto) {
       Optional<Discount> discountOptional = discountRepository.findById(id);
       if(discountOptional.isEmpty()){
        throw new IllegalStateException("Discount does not exist with id " + id);
       }
       Discount existingDiscount = discountOptional.get();
       Discount newDiscount = discountDtoToDiscount(discountDto);

       existingDiscount.setDiscountName(newDiscount.getDiscountName());
       existingDiscount.setDiscountAmount(newDiscount.getDiscountAmount());
       existingDiscount.setDiscountStartDate(newDiscount.getDiscountStartDate());
       existingDiscount.setDiscountEndDate(newDiscount.getDiscountEndDate());

       return discountToDiscountDto(discountRepository.save(existingDiscount));
    }

    @Override
    public void deleteByID(Integer id) {
        Optional<Discount> discountOptional = discountRepository.findById(id);
        if(discountOptional.isEmpty()){
            throw new IllegalStateException("Discount does not exist with id"+ id);
        }
        Discount existingDiscount = discountOptional.get();
        discountRepository.delete(existingDiscount);
    }

}
