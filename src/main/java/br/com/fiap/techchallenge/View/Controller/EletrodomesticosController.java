package br.com.fiap.techchallenge.View.Controller;

import br.com.fiap.techchallenge.Aplicacao.GerenciarEletrodomesticos;
import br.com.fiap.techchallenge.View.Controller.DTO.AdicionarUsuarioAoEletrodomesticoDTO;
import br.com.fiap.techchallenge.View.Controller.DTO.ConsumoEnergeticoDTO;
import br.com.fiap.techchallenge.View.Controller.DTO.EletrodomesticoDTO;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

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

    @GetMapping(params = "nome")
    ResponseEntity<List<EletrodomesticoDTO>> pesquisarPorNome(@RequestParam(name = "nome") String nome) {
        var eletrodomesticos = this.gerenciarEletrodomesticos.pesquisarPorNome(nome);
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticos);
    }

    @GetMapping(params = "modelo")
    ResponseEntity<List<EletrodomesticoDTO>> pesquisarPorPotencia(@RequestParam(name = "modelo") String modelo) {
        var eletrodomesticos = this.gerenciarEletrodomesticos.pesquisarPorModelo(modelo);
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticos);
    }

    @GetMapping(value = "/potencia", params = {"de", "ate"})
    ResponseEntity<List<EletrodomesticoDTO>> pesquisarPorPotencia(
      @RequestParam(name = "de") BigDecimal potenciaApartirDe,
      @RequestParam(name = "ate") BigDecimal potenciaDeAte
      )  {
        var eletrodomesticos = this.gerenciarEletrodomesticos.pesquisarPorPotencia(potenciaApartirDe, potenciaDeAte);
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticos);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<EletrodomesticoDTO> editar(@PathVariable("id") UUID id, @RequestBody @Valid EletrodomesticoDTO eletrodomesticoDTO) {
        this.gerenciarEletrodomesticos.editarEletrodomestico(eletrodomesticoDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticoDTO);
    }

    @PostMapping(value = "/{id}/usuario")
    ResponseEntity<EletrodomesticoDTO> adicionarNovoUsuarioAoEletrodomestico(
      @PathVariable("id") UUID id,
      @Valid @RequestBody AdicionarUsuarioAoEletrodomesticoDTO eledomesticoUsuarioDTO) {
        var novoUsuario = this.gerenciarEletrodomesticos.adicionarUsuarioAoEletrodomestico(eledomesticoUsuarioDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PutMapping(value = "/{eletrodomesticoID}/consumo")
    ResponseEntity<ConsumoEnergeticoDTO> calcularConsumoEnergeticoPorAparelho(
      @RequestBody @Valid ConsumoEnergeticoDTO consumoEnergeticoDTO,
      @PathVariable("eletrodomesticoID") UUID eletrodomesticoID
    ) {
        var consumo = this.gerenciarEletrodomesticos
          .calcularConsumoEnergeticoPorAparelho(eletrodomesticoID, consumoEnergeticoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(consumo);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> removerEletrodomesticos(@PathVariable("id") UUID eletrodomesticoID) {
        this.gerenciarEletrodomesticos.removerEletrodomestico(eletrodomesticoID);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
