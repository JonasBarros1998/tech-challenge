package br.com.fiap.techchallenge.View.Controller;

import br.com.fiap.techchallenge.Aplicacao.GerenciarEletrodomesticos;
import br.com.fiap.techchallenge.Dominio.Entidades.Eletrodomestico;
import br.com.fiap.techchallenge.View.Controller.DTO.EletrodomesticoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/eletrodomesticos")
public class EletrodomesticosController {

    GerenciarEletrodomesticos gerenciarEletrodomesticos;

    @Autowired
    EletrodomesticosController(GerenciarEletrodomesticos gerenciarEletrodomesticos){
        this.gerenciarEletrodomesticos = gerenciarEletrodomesticos;
    }

    @PostMapping
    ResponseEntity<EletrodomesticoDTO> eletrodomesticos(@RequestBody @Valid EletrodomesticoDTO eletrodomesticoDTO) {
        this.gerenciarEletrodomesticos.salvar(eletrodomesticoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticoDTO);
    }

    /*
    @GetMapping(value = "/eletrodomesticos", params = "nome")
    ResponseEntity<List<EletrodomesticoDTO>> pesquisarPorNome(@RequestParam(name = "nome") String nome) {
        var eletrodomesticos = this.gerenciarEletrodomesticos.pesquisarPorNome(nome);
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticos);
    }

    @GetMapping(value = "/eletrodomesticos/potencia", params = {"de", "ate"})
    ResponseEntity<List<EletrodomesticoDTO>> pesquisarPorPotencia(
      @RequestParam(name = "apartirDe") BigDecimal potenciaApartirDe,
      @RequestParam(name = "ate") BigDecimal potenciaDeAte
      )  {
        var eletrodomesticos = this.gerenciarEletrodomesticos.pesquisarPorPotencia(potenciaApartirDe, potenciaDeAte);
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticos);
    }

    @GetMapping(value = "/eletrodomesticos", params = "modelo")
    ResponseEntity<List<EletrodomesticoDTO>> pesquisarPorPotencia(@RequestParam(name = "modelo") String modelo) {
        var eletrodomesticos = this.gerenciarEletrodomesticos.pesquisarPorModelo(modelo);
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticos);
    }*/




}
