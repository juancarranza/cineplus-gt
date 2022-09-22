package com.example.application.views.funciones;

import java.util.ArrayList;

import com.example.application.views.MainLayout;
import com.modelos.Funcion;
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

@PageTitle("Funciones")
@Route(value = "Funciones", layout = MainLayout.class)
public class FuncionesView extends VerticalLayout {

    private TextField cFechaHora = new TextField("Fecha y Hora");
    private TextField cFkIdSala = new TextField("Fk Id Sala");
    private TextField cFkIdPelicula = new TextField("Fk Id Pelicula");
    
    private ArrayList<Funcion> funciones = new ArrayList<>();
    private Grid<Funcion> gridFunciones = new Grid<>();
    private Button bAgregar = new Button("Guardar");

    public FuncionesView() {
        add(gridFunciones);
        //gridFunciones.addColumn(Cine::getIdCine);
        gridFunciones.addColumn(Funcion::getFechahora);
        gridFunciones.addColumn(Funcion::getIdSala);
        gridFunciones.addColumn(Funcion::getIdPelicula);
       
        actualizar();

        HorizontalLayout layoutCampos= new HorizontalLayout();
        add(layoutCampos);
        layoutCampos.add(cFechaHora, cFkIdSala, cFkIdPelicula, bAgregar);
        bAgregar.addClickListener(event -> agregarFuncion(cFechaHora.getValue(), Integer.parseInt(cFkIdSala.getValue()), Integer.parseInt(cFkIdPelicula.getValue())));
    }

    private void agregarFuncion(String fechaHora, int fkIdSala, int fkIdPelicula) {
        funciones.add(new Funcion(fechaHora, fkIdSala, fkIdPelicula));
        actualizar();
        cFechaHora.setValue("");
        cFkIdPelicula.setValue("0");
        cFkIdSala.setValue("0");
    }

    private void actualizar() {
        gridFunciones.setItems(funciones);
    }

}
