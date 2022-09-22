package com.modelos;

public class Pelicula {

    private int idPelicula;
    private String nombre;
    private String sinopsis;
    private String creditosReparto;
    private int fkIdGenero;

    public Pelicula(String nombre, String sinopsis, String creditosReparto, int fkIdGenero) {
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.creditosReparto = creditosReparto;
        this.fkIdGenero = fkIdGenero;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getCreditosReparto() {
        return creditosReparto;
    }

    public void setCreditosReparto(String creditosReparto) {
        this.creditosReparto = creditosReparto;
    }

    public int getFkIdGenero() {
        return fkIdGenero;
    }

    public void setFkIdGenero(int fkIdGenero) {
        this.fkIdGenero = fkIdGenero;
    }
    
    
    
}
