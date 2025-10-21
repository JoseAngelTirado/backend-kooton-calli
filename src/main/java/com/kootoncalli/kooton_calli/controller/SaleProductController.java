package com.kootoncalli.kooton_calli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kootoncalli.kooton_calli.dto.SaleProductDto;
import com.kootoncalli.kooton_calli.service.SaleProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/saleproducts")
@CrossOrigin(origins = "*")
public class SaleProductController {

    //inyecion de dependencias
    private final SaleProductService saleProductService;

    public SaleProductController(SaleProductService saleProductService) {
        this.saleProductService = saleProductService;
    }

    //Obtener todos los registros
    @GetMapping //GetMapping responde a las peticiones GET
    ResponseEntity<Iterable<SaleProductDto>> getAllSaleProducts(){ //El metodo responde un lista de SaleProduct
        return ResponseEntity.ok(saleProductService.findAll());
    }

    //Crear un nuevo registro
    @PostMapping//PostMapping responde las peticiones POST
    ResponseEntity<SaleProductDto> createSaleProduct(@RequestBody SaleProductDto saleProductDto){ // el JSON en objeto DTO
        SaleProductDto createdSaleProduct = saleProductService.save(saleProductDto); //Con el Service guardamos la entidad
        return ResponseEntity.status(201).body(createdSaleProduct);
    }

    //Get - Busqueda por IDs compuestos
    @GetMapping("/{idTicket}/{idProduct}")
    ResponseEntity<SaleProductDto> getSaleProductBy(
        @PathVariable("idTicket") Integer idTicket, 
        @PathVariable("idProduct")Integer idProduct){ //PathVariable captura ese valor de la url y lo guarda en id
        SaleProductDto saleProductDto = saleProductService.findById(idTicket, idProduct); //llama al Serivce pasando el ID para buscar el registro en la base de datos
        return ResponseEntity.ok(saleProductDto);
    }

    //PUT - actualiza registro por IDs compuestos
    @PutMapping("/{idTicket}/{idProduct}") //Put Mapping este endpoint actualizara el un registro
    ResponseEntity<SaleProductDto> updateSaleProduct(
        @PathVariable("idTicket") Integer idTicket,
        @PathVariable("idProduct") Integer idProduct,//Obtiene el ID del registro a actualizar
        @RequestBody SaleProductDto saleProductDto //Toma los nuevos datos del cuerpo de la peticion
    ){
        SaleProductDto updateSaleProduct = saleProductService.update(idTicket, idProduct, saleProductDto); //Service busca el registro
        return ResponseEntity.ok(updateSaleProduct); //Devuelve el registro actualizado
    }
    
    @DeleteMapping("/{idticket}/{idProdcut}")
    ResponseEntity<Void> deleteSaleProduct(@PathVariable("id") Integer idTicket, @PathVariable("idProduct") Integer idProduct){
        saleProductService.deleteByID(idTicket, idProduct);
        return ResponseEntity.noContent().build();
    }
    
}
