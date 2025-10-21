package com.kootoncalli.kooton_calli.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kootoncalli.kooton_calli.dto.SaleProductDto;
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
    public SaleProductDto findById(Integer idTicket, Integer idProduct , SaleProductDto saleProduct) {

        //Debemos construir la llave comupuesta con ambos Id's de SaleProductDto
        SaleProductId id = new SaleProductId(idTicket, idProduct);

        //Se busca el registro en el repositorio con la llave compuesta
        Optional<SaleProduct> saleProductOptional = saleProductRepository.findById(id);


        //En caso de que no existe la se lanza la excepcion
        if (saleProductOptional.isEmpty()) {
        throw new IllegalStateException("SaleProduct does not exist, idTicket=" 
            + idTicket + ", idProduct=" + idProduct);
        }

        //se obtiene la entidad
        SaleProduct existingProductSale = saleProductOptional.get();
        //Se convierte la entidad a DTO 
        return saleProductToSaleProductDto(existingProductSale);
    }

    @Override
    public Iterable<SaleProductDto> findAll() {
        List<SaleProductDto> saleProductsDto = new ArrayList<>();

        Iterable<SaleProduct> saleProducts = saleProductRepository.findAll();
        //Iteracion sobre cada entidad
        for(SaleProduct saleProduct: saleProducts){

            //Obtenecion de los campos para el ID compuesto
            Integer idTicket = saleProduct.getId().getIdTicket();
            Integer idProduct = saleProduct.getId().getIdProduct();


            SaleProductDto saleProductDto = new SaleProductDto(idTicket, idProduct, saleProduct.getProductsAmount(),
            saleProduct.getUnitPrice(),
            saleProduct.getSubtotal()
            );
            saleProductsDto.add(saleProductDto);
        }
        return saleProductsDto;
    }

    @Override
    public SaleProductDto update(Integer idTicket, Integer idProduct, SaleProductDto saleProduct) {
        //Debemos construir la llave comupuesta con ambos Id's de SaleProductDto
        SaleProductId id = new SaleProductId(idTicket, idProduct);

        //Se busca el registro en el repositorio con la llave compuesta
        Optional<SaleProduct> saleProductOptional = saleProductRepository.findById(id);

        //En caso de que no existe la se lanza la excepcion
        if (saleProductOptional.isEmpty()) {
        throw new IllegalStateException("SaleProduct does not exist, idTicket=" 
            + idTicket + ", idProduct=" + idProduct);
    }
        //se obtiene la entidad
        SaleProduct existingProductSale = saleProductOptional.get();

        //Actualizamos los atributos de SaleProduct
        existingProductSale.setProductsAmount(saleProduct.getProductsAmount());
        existingProductSale.setUnitPrice(saleProduct.getUnitPrice());
        existingProductSale.setSubtotal(saleProduct.getSubtotal());

        
        //Se convierte la entidad a DTO 
        return saleProductToSaleProductDto(existingProductSale);
    }

    @Override
    public void deleteByID(Integer idTicket, Integer idProduct) {

        //Se cosntruye el ID compuesto
        SaleProductId id = new SaleProductId(idTicket, idProduct);

        //Se vrifica si el registro existe
        Optional<SaleProduct> saleProductOptional = saleProductRepository.findById(id);
        
        //Condicional par verificar si existe
        if (saleProductOptional.isEmpty()) {
        throw new IllegalStateException("SaleProduct does not exist, idTicket=" 
            + idTicket + ", idProduct=" + idProduct);
        }

        //Se elimina el registro
        saleProductRepository.deleteById(id);

    }

    @Override
    public SaleProductDto getSaleProductById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSaleProductById'");
    }



}
