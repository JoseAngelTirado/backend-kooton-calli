package com.kootoncalli.kooton_calli.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kootoncalli.kooton_calli.dto.SaleProductDto;
import com.kootoncalli.kooton_calli.dto.SalesTicketDto;
import com.kootoncalli.kooton_calli.model.SaleProduct;
import com.kootoncalli.kooton_calli.model.SaleProductId;
import com.kootoncalli.kooton_calli.repository.SaleProductRepository;
import com.kootoncalli.kooton_calli.service.SaleProductService;

@Service
public class SaleProductServiceImpl implements SaleProductService{




    //inyeccion de dependecias 
    private final SaleProductRepository saleProductRepository;


    public SaleProductServiceImpl(SaleProductRepository saleProductRepository) {
        this.saleProductRepository = saleProductRepository;
    }

    @Override
    public SaleProductDto save(SaleProductDto saleProductDto) {
        saleProductDto.setIdProduct(null);
        saleProductDto.setIdTicket(null);
        SaleProduct saleProductToSave = saleProductDtoToSaleProduct(saleProductDto);
        SaleProduct createdSaleProduct = saleProductRepository.save(saleProductToSave);
        return saleProductToSaleProductDto(createdSaleProduct);
    }

    private SaleProduct saleProductDtoToSaleProduct(SaleProductDto saleProductDto ){
        SaleProduct saleProduct = new SaleProduct();

        //Se construye el ID compuesto apartir de los dos Ids en en la entidad SaleProductDto
        SaleProductId id = new SaleProductId(saleProductDto.getIdTicket(), saleProductDto.getIdProduct());
        saleProduct.setId(id);

        saleProduct.setProductsAmount(saleProductDto.getProductsAmount());
        saleProduct.setUnitPrice(saleProduct.getUnitPrice());
        saleProduct.setSubtotal(saleProduct.getSubtotal());
        return saleProduct;
    }

    private SaleProductDto saleProductToSaleProductDto(SaleProduct saleProduct){
        SaleProductDto saleProductDto = new SaleProductDto(
        saleProduct.getId().getIdProduct(),
        saleProduct.getId().getIdTicket(),
        saleProduct.getProductsAmount(),
        saleProduct.getUnitPrice(),
        saleProduct.getSubtotal()
        );
        return saleProductDto;
    }

    @Override
    public SaleProductDto findById(SaleProductDto saleProductDto) {
        Optional<SaleProduct> saleProductOptional = saleProductRepository.findById();
        
    }

    @Override
    public Iterable<SaleProductDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public SaleProductDto update(Integer idSaleProduct, SaleProductDto saleProduct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteByID(Integer idSaleProduct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByID'");
    }

    @Override
    public SaleProductDto getSaleProductById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSaleProductById'");
    }



}
