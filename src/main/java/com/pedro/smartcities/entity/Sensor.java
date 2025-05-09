package com.pedro.smartcities.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tipo é obrigatório")
    private String tipo;

    @NotNull
    @Min(value = 0, message = "Valor deve ser maior ou igual a 0")
    private Integer valor;

    @NotBlank(message = "Localização é obrigatória")
    private String localizacao;

    @NotNull(message = "Horário é obrigatório")
    private Date horario = new Date();


    public Sensor(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Sensor(String tipo , int valor , String localizacao){

        this.tipo = tipo;
        this.valor = valor;
        this.localizacao = localizacao;
        this.horario = new Date();



    }
}
