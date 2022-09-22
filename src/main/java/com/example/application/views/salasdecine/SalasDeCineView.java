package com.example.application.views.salasdecine;

import java.util.ArrayList;

import com.example.application.views.MainLayout;
import com.modelos.Sala;
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

@PageTitle("Salas De Cine")
@Route(value = "Salas-de-Cine", layout = MainLayout.class)
public class SalasDeCineView extends VerticalLayout {

    private TextField cNombre = new TextField("Nombre de la Sala");
    private TextField cCapacidad = new TextField("Capacidad");
    private TextField cTipoExperiencia = new TextField("Tipo de Experiencia");
    private TextField cFkIdCine = new TextField("Fk Id Cine");
    
    private ArrayList<Sala> salas = new ArrayList<>();
    private Grid<Sala> gridSalas = new Grid<>();
    private Button bAgregar = new Button("Guardar");

    public SalasDeCineView() {
        add(gridSalas);
        //gridSalas.addColumn(Cine::getIdCine);
        gridSalas.addColumn(Sala::getNombre);
        gridSalas.addColumn(Sala::getCapacidad);
        gridSalas.addColumn(Sala::getTipoExperiencia);
        gridSalas.addColumn(Sala::getFkIdCine);
        actualizar();

        HorizontalLayout layoutCampos= new HorizontalLayout();
        add(layoutCampos);
        layoutCampos.add(cNombre, cCapacidad, cTipoExperiencia, cFkIdCine, bAgregar);
        bAgregar.addClickListener(event -> agregarSala(cNombre.getValue(), Integer.parseInt(cCapacidad.getValue()), cTipoExperiencia.getValue(), Integer.parseInt(cFkIdCine.getValue())));
    }

    private void agregarSala(String nombre, int capacidad, String tipoExperiencia, int fkIdCine){
        salas.add(new Sala(nombre, capacidad, tipoExperiencia, fkIdCine));
        actualizar();
        cNombre.setValue("");
        cCapacidad.setValue("0");
        cTipoExperiencia.setValue("");
        cFkIdCine.setValue("0");
    }

    private void actualizar(){
        gridSalas.setItems(salas);
    }

}
