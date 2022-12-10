package br.com.samuel.DTO;

import br.com.samuel.Models.Carro;
import br.com.samuel.Models.Vendedor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.Getter;
import org.json.JSONObject;

import java.util.ArrayList;

@Getter
public class OfertaDTO {
    private Carro carro;
    private Vendedor vendedor;

    public OfertaDTO(JSONObject json){

        this.carro = new Carro();
        this.vendedor = json.get("vendedor");
    }
}
