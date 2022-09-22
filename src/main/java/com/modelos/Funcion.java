package com.modelos;

public class Funcion {
    private int idFuncion;
    private String fechahora; 
    private int idSala;
    private int idPelicula;

    public Funcion(String fechahora, int idSala, int idPelicula) {
        this.fechahora = fechahora;
        this.idSala = idSala;
        this.idPelicula = idPelicula;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    
    
}
