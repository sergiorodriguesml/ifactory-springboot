package br.ufc.quixada.pub;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.ufc.quixada.author.*;
import br.ufc.quixada.publisher.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pub {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	private Author author;

	@ManyToOne
	private Publisher publisher;

	private PubTipo tipo;

	// public Pub() {
	// }
	//
	// public Pub(Integer id, Author author, Publisher publisher, Tipo tipo) {
	// this.id = id;
	// this.author = author;
	// this.publisher = publisher;
	// this.setTipo(tipo);
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
	// public Author getAuthor() {
	// return author;
	// }
	//
	// public void setAuthor(Author author) {
	// this.author = author;
	// }
	//
	// public Publisher getPublisher() {
	// return publisher;
	// }
	//
	// public void setPublisher(Publisher publisher) {
	// this.publisher = publisher;
	// }
	//
	// public Tipo getTipo() {
	// return tipo;
	// }
	//
	// public void setTipo(Tipo tipo) {
	// this.tipo = tipo;
	// }

}
