package com.example.application.views.generos;

import java.util.ArrayList;

import com.example.application.views.MainLayout;
import com.modelos.Genero;
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

@PageTitle("Generos")
@Route(value = "Generos", layout = MainLayout.class)
public class GenerosView extends VerticalLayout {

    private TextField cNombre = new TextField("Nombre del Genero");
    private TextField cDescripcion = new TextField("Descripcion");
     
    private ArrayList<Genero> generos = new ArrayList<>();
    private Grid<Genero> gridGeneros = new Grid<>();
    private Button bAgregar = new Button("Guardar");
    
    public GenerosView() {
        add(gridGeneros);
        //gridGeneros.addColumn(Genero::getIdCine);
        gridGeneros.addColumn(Genero::getNombre);
        gridGeneros.addColumn(Genero::getDescripcion);
        actualizar();

        HorizontalLayout layoutCampos= new HorizontalLayout();
        add(layoutCampos);
        layoutCampos.add(cNombre, cDescripcion, bAgregar);
        bAgregar.addClickListener(event -> agregarGenero(cNombre.getValue(), cDescripcion.getValue()));
    }

    private void actualizar(){
        gridGeneros.setItems(generos);
    }

    private void agregarGenero(String nombre, String descripcion){
        generos.add(new Genero(nombre, descripcion));
        actualizar();
        cNombre.setValue("");
        cDescripcion.setValue("");
    }

}
