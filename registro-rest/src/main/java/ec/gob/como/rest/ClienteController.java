package ec.gob.como.rest;

import java.util.List;

import ec.gob.como.domain.data.ClienteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



public interface ClienteController {
	@PostMapping("/cliente")
    ResponseEntity<Void> addCliente(@RequestBody ClienteDto clienteDto);

    @DeleteMapping("/cliente")
    ResponseEntity<String> removeCliente(@RequestBody ClienteDto clienteDto);

    @PutMapping("/cliente")
    ResponseEntity<String> updateCliente(@RequestBody ClienteDto clienteDto);

    @GetMapping("/cliente/{nombre}")
    ResponseEntity<ClienteDto> getClienteByNombre(@PathVariable String nombre);

    @GetMapping("/cliente")
    ResponseEntity<List<ClienteDto>> getCliente();

   

}
