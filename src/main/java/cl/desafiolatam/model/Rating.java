package cl.desafiolatam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="rating")
	private Integer ratings;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private User idUsuario;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_pelicula")
	private Show idPelicula;
}
