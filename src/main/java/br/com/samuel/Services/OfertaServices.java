package br.com.samuel.Services;

import br.com.samuel.Models.Carro;
import br.com.samuel.Models.Oferta;
import br.com.samuel.Models.Vendedor;
import br.com.samuel.Repositories.OfertaRepository;
import br.com.samuel.Repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfertaServices {
    @Autowired
    OfertaRepository ofertaRepository;
    @Autowired
    VendedorRepository vendedorRepository;

    public List<Oferta> findAll(){
        return ofertaRepository.findAll();
    }

    public void save(Carro carro, Vendedor vendedor) {
        if(vendedorRepository.existsById(vendedor.getId())) {
            Vendedor dbVendedor = vendedorRepository.findById(vendedor.getId()).orElse(vendedor);
            Oferta oferta = new Oferta(dbVendedor, carro);
            dbVendedor.adicionaOferta(oferta);
            vendedorRepository.save(dbVendedor);
            ofertaRepository.save(oferta);
        }
        else {
            Oferta oferta = new Oferta(vendedor, carro);
            vendedor.adicionaOferta(oferta);
            vendedorRepository.save(vendedor);
            ofertaRepository.save(oferta);
        }
    }
}
