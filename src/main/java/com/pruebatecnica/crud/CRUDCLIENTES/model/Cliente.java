package com.pruebatecnica.crud.CRUDCLIENTES.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonEncoding;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cliente;

	@NotBlank(message = "Es requerido el valor del nombre")
	private String nombre_cliente;

	@NotBlank(message = "Es requerido el valor de apellido")
	private String apellido_cliente;

	private String correo_electronico;

	@NotNull(message = "El campo edad es requerido")
	@Min(value = 1, message = "Verifique el valor minimo de la edad")
	@Max(value = 105, message = "Verigfique el valor maximo de la edad")
	private Integer edad;

	@NotBlank(message = "Es requerido el genero")
	@Pattern(regexp = "M|F", message = "Valores Requeridos M masculino o F para Femenino")
	private String genero;

	private String direccion;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@CreationTimestamp
	@Column(updatable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date fecha_registro;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private OffsetDateTime ultima_modificacion;

	public Cliente() {

	}

	public Cliente(String nombre_cliente, String apellido_cliente, String correo_electronico, Integer edad,
			String genero, String direccion, Date fecha_registro, OffsetDateTime ultima_modificacion) {
		this.nombre_cliente = nombre_cliente;
		this.apellido_cliente = apellido_cliente;
		this.correo_electronico = correo_electronico;
		this.edad = edad;
		this.genero = genero;
		this.direccion = direccion;
		this.fecha_registro = fecha_registro;
		this.ultima_modificacion = ultima_modificacion;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellido_cliente() {
		return apellido_cliente;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public OffsetDateTime getUltima_modificacion() {
		return ultima_modificacion;
	}

	public void setUltima_modificacion(OffsetDateTime ultima_modificacion) {
		this.ultima_modificacion = ultima_modificacion;
	}

}
