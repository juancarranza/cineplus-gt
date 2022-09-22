package com.modelos;

public class Sala {

    private int idSala;
    private String nombre; 
    private int capacidad;
    private String tipoExperiencia;
    private int fkIdCine;

    public Sala(String nombre, int capacidad, String tipoExperiencia, int fkIdCine) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipoExperiencia = tipoExperiencia;
        this.fkIdCine = fkIdCine;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoExperiencia() {
        return tipoExperiencia;
    }

    public void setTipoExperiencia(String tipoExperiencia) {
        this.tipoExperiencia = tipoExperiencia;
    }

    public int getFkIdCine() {
        return fkIdCine;
    }

    public void setFkIdCine(int fkIdCine) {
        this.fkIdCine = fkIdCine;
    }
}
