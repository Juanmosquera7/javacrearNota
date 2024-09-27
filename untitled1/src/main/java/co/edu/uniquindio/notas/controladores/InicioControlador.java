package co.edu.uniquindio.notas.controladores;
import co.edu.uniquindio.notas.modelo.Nota;
import co.edu.uniquindio.notas.modelo.NotaPrincipal;
import com.sun.javafx.charts.Legend;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.beans.property.SimpleStringProperty;

import java.net.URL;
import java.util.ResourceBundle;


public class InicioControlador implements Initializable {
    @FXML
    private TextField txtTitulo;



    @FXML
    private ComboBox<String> cmbCategoria; // ComboBox para la categoría


    @FXML
    private TextArea txtNota;

    private final NotaPrincipal notaPrincipal;

    @FXML
    private TableView<Nota> tablaNotas;


    @FXML
    private TableColumn<Nota, String> colTitulo;


    @FXML
    private TableColumn<Nota, String> colCategoria;


    @FXML
    private TableColumn<Nota, String> colTexto;


    @FXML
    private TableColumn<Nota, String> colFecha;
    @FXML
    private TableColumn<Nota, Integer> colId;
    private Legend.LegendItem txtId;


    public InicioControlador() {
        notaPrincipal = new NotaPrincipal();
    }
    public void initialize() {
        // Definir las opciones del ComboBox en el método initialize
        cmbCategoria.setItems(FXCollections.observableArrayList("Trabajo", "Personal", "Estudio", "Otros"));
    }
    @FXML
    public void crearNota(ActionEvent e) {
        try {
            String titulo = txtTitulo.getText();
            String descripcion = txtNota.getText();
            String categoria = cmbCategoria.getValue();

            // Comprobación de campos vacíos
            if (titulo.isEmpty() || descripcion.isEmpty() || categoria == null) {
                throw new Exception("Todos los campos deben estar llenos.");
            }

            // Agregar la nota
            notaPrincipal.agregarNota(titulo, descripcion, categoria);
            mostrarAlerta("Nota creada correctamente", Alert.AlertType.INFORMATION);

            // Limpiar campos
            txtTitulo.clear();
            txtNota.clear();
            cmbCategoria.getSelectionModel().clearSelection();

            // Actualizar la tabla
            actualizarTabla();

        } catch (Exception ex) {
            mostrarAlerta(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){


        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        colTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        colCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        colTexto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaCreacion().toString()));

        actualizarTabla();
        // Agregar datos a la tabla
        //tablaNotas.setItems(FXCollections.observableArrayList(notaPrincipal.listarNotas()));


    }
    private void actualizarTabla() {
        tablaNotas.setItems(FXCollections.observableArrayList(notaPrincipal.listarNotas()));
    }
    @FXML
    public void eliminarNota(ActionEvent event) {
        try {
            // Verificar que el TextField no esté vacío
            if (txtId.getText().isEmpty()) {
                mostrarAlerta("Por favor, ingrese un ID válido.", Alert.AlertType.ERROR);
                return; // Salir del método si el ID está vacío
            }

            // Obtener el ID del TextField
            int id = Integer.parseInt(txtId.getText()); // Esto lanzará una excepción si no es un número válido
            notaPrincipal.eliminarNota(id);
            mostrarAlerta("Nota eliminada correctamente", Alert.AlertType.INFORMATION);
            actualizarTabla();

        } catch (NumberFormatException e) {
            mostrarAlerta("El ID debe ser un número entero.", Alert.AlertType.ERROR);
        } catch (Exception ex) {
            mostrarAlerta(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }








}
