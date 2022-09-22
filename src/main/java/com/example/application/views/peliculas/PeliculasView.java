package com.example.application.views.peliculas;

import java.util.ArrayList;

import com.example.application.views.MainLayout;
import com.modelos.Pelicula;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Peliculas")
@Route(value = "Peliculas", layout = MainLayout.class)
public class PeliculasView extends VerticalLayout {

    private TextField cNombre = new TextField("Nombre de la Pelicula");
    private TextField cSinopsis = new TextField("Sinopsis");
    private TextField cCreditosReparto = new TextField("Creditos y Reparto");
    private TextField cFkIdGenero = new TextField("Fk Id Genero");
    
    private ArrayList<Pelicula> peliculas = new ArrayList<>();
    private Grid<Pelicula> gridPeliculas = new Grid<>();
    private Button bAgregar = new Button("Guardar");

    public PeliculasView() {
        add(gridPeliculas);
        //gridPeliculas.addColumn(Cine::getIdCine);
        gridPeliculas.addColumn(Pelicula::getNombre);
        gridPeliculas.addColumn(Pelicula::getSinopsis);
        gridPeliculas.addColumn(Pelicula::getCreditosReparto);
        gridPeliculas.addColumn(Pelicula::getFkIdGenero);
        actualizar();

        HorizontalLayout layoutCampos= new HorizontalLayout();
        add(layoutCampos);
        layoutCampos.add(cNombre, cSinopsis, cCreditosReparto, cFkIdGenero, bAgregar);
        bAgregar.addClickListener(event -> agregarPelicula(cNombre.getValue(), cSinopsis.getValue(), cCreditosReparto.getValue(), Integer.parseInt(cFkIdGenero.getValue())));
    }

    private void agregarPelicula(String nombre, String sinopsis, String creditosReparto, int fkIdGenero){
        peliculas.add(new Pelicula(nombre, sinopsis, creditosReparto, fkIdGenero));
        actualizar();
        cNombre.setValue("");
        cSinopsis.setValue("");
        cCreditosReparto.setValue("");
        cFkIdGenero.setValue("0");
    }

    private void actualizar(){
        gridPeliculas.setItems(peliculas);
    }
}
