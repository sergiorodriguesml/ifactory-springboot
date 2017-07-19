package br.ufc.quixada.publisher;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.ufc.quixada.pub.Pub;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nome;
	
	private String email;
	
	@OneToMany(mappedBy="publisher")
	@JsonIgnore
	private Collection<Pub> publications;
	

	// public Publisher() {}
	//
	// public Publisher(Integer id, String nome) {
	// this.id = id;
	// this.nome = nome;
	// }
	//
	// public Integer getId() {
	// return id;
	// }
	//
	// public void setId(Integer id) {
	// this.id = id;
	// }
	//
	// public String getNome() {
	// return nome;
	// }
	//
	// public void setNome(String nome) {
	// this.nome = nome;
	// }

}
