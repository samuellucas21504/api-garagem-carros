package br.com.samuel.Controllers;

import br.com.samuel.DTO.OfertaDTO;
import br.com.samuel.Models.Carro;
import br.com.samuel.Models.Oferta;
import br.com.samuel.Models.Vendedor;
import br.com.samuel.Services.OfertaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfertaController {
    @Autowired
    private OfertaServices OfertaServices;

    @GetMapping("/ofertas")
    @ResponseStatus(HttpStatus.OK)
    public List<Oferta> findAll(){return OfertaServices.findAll();}

    @PostMapping("/ofertas")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOferta(
            @RequestBody OfertaDTO ofertaDTO
            ) {
        OfertaServices.save(ofertaDTO.getCarro(), ofertaDTO.getVendedor());
    }
}
