package br.ufc.quixada.pub;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.quixada.author.*;
import br.ufc.quixada.publisher.*;

@RestController
@RequestMapping("/pubs")
public class PubController {

	@Autowired
	private PubRepository pubRepository;

	@GetMapping()
	public List<Pub> queryPub() {
		return (List<Pub>) pubRepository.findAll();
	}

	@PostMapping()
	public ResponseEntity<Pub> createPub(@RequestBody Pub pub) throws MalformedURLException, URISyntaxException {
		pubRepository.save(pub);
		return ResponseEntity.ok(pub);
	}

	@DeleteMapping(value = "/{id}")
	public void deletePub(@PathVariable Integer id) throws MalformedURLException, URISyntaxException {
		pubRepository.delete(id);
	}

	@PutMapping()
	public void atualizaPub(@RequestBody Pub pub) {
		pubRepository.save(pub);
	}

	@GetMapping(value = "/{id}")
	public Pub getPub(@PathVariable Integer id) {
		return pubRepository.findOne(id);
	}

}
