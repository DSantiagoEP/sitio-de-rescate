package centroRescate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Vista extends JFrame implements ActionListener{
    
    private JTextField campoNombre;
    private JTextField campoRaza;
    private JTextField campoColor;
    private JTextField campoEdad;
    private JTextField campoNivelEntrenamiento;
    private JTextField campoTexoplasmosis;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnRegistrar;
    private JButton btnConsultarLista;
    private JButton btnCanino;
    private JButton btnFelino;
    
    Hashtable<String,Mascota> tablaMascotas;
    
    public Vista(){
        initialize();
        setSize(420, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        tablaMascotas= new Hashtable<String, Mascota>();
    }
    
    private void initialize (){
        
        getContentPane().setLayout(null);
        
        JLabel lblRegistroDeMascota = new JLabel("REGISTRO DE LA MASCOTA");
        lblRegistroDeMascota.setBounds(10, 11, 200, 23);
        getContentPane().add(lblRegistroDeMascota);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 95, 79, 14);
        getContentPane().add(lblNombre);
        
        campoNombre = new JTextField();
        campoNombre.setBounds(85,92,86,20);
        getContentPane().add(campoNombre);
        campoNombre.setColumns(10);
        
        JLabel lblRaza = new JLabel("Raza");
        lblRaza.setBounds(198, 95, 50, 14);
        getContentPane().add(lblRaza);
        
        campoRaza = new JTextField();
        campoRaza.setBounds(232,92,86,20);
        getContentPane().add(campoRaza);
        campoRaza.setColumns(10);
        
        JLabel lblColor = new JLabel("Color");
        lblColor.setBounds(10, 124, 86, 14);
        getContentPane().add(lblColor);
        
        campoColor = new JTextField();
        campoColor.setBounds(85,121,233,20);
        getContentPane().add(campoColor);
        campoColor.setColumns(10);
        
        JLabel lblEdad = new JLabel("Edad");
        lblEdad.setBounds(10, 155, 86, 14);
        getContentPane().add(lblEdad);
        
        campoEdad = new JTextField();
        campoEdad.setBounds(85,152,233,20);
        getContentPane().add(campoEdad);
        campoEdad.setColumns(10);
        
        JLabel lblNivelEntrenamiento = new JLabel("Nivel de entrenamiento \n del can");
        lblNivelEntrenamiento.setBounds(10, 186, 200, 14);
        getContentPane().add(lblNivelEntrenamiento);
        
        campoNivelEntrenamiento = new JTextField();
        campoNivelEntrenamiento.setBounds(200,186,86,20);
        getContentPane().add(campoNivelEntrenamiento);
        campoNivelEntrenamiento.setColumns(10);
        
        JLabel lblTexoplasmosis = new JLabel("¿El felino tiene texoplasmosis?");
        lblTexoplasmosis.setBounds(10, 217, 200, 14);
        getContentPane().add(lblTexoplasmosis);
        
        campoTexoplasmosis = new JTextField();
        campoTexoplasmosis.setBounds(200,217,86,20);
        getContentPane().add(campoTexoplasmosis);
        campoTexoplasmosis.setColumns(10);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(219,248,99,23);
        getContentPane().add(btnEliminar);
        btnEliminar.addActionListener(this );
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(10,248,99,23);
        getContentPane().add(btnRegistrar);
        btnRegistrar.addActionListener(this );
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(119,248,89,23);
        getContentPane().add(btnBuscar);
        btnBuscar.addActionListener(this );
        
        btnConsultarLista = new JButton("Consultar en la lista");
        btnConsultarLista.setBounds(71,279,188,23);
        getContentPane().add(btnConsultarLista);
        btnConsultarLista.addActionListener(this );
        
        JLabel lblTipoMascota = new JLabel("Seleccione el tipo de mascota");
        lblTipoMascota.setBounds(10, 40, 200, 14);
        getContentPane().add(lblTipoMascota);
        
        btnCanino = new JButton("Canino");       
        btnCanino.setBounds(200,40 ,80,23);
        getContentPane().add(btnCanino);
        btnCanino.addActionListener(this );
        
        btnFelino = new JButton("Felino");
        btnFelino.setBounds(300,40,80,23);
        getContentPane().add(btnFelino);
        btnFelino.addActionListener(this );
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnRegistrar){
            registrarMascota(tablaMascotas);
            
        }
        if(e.getSource()==btnBuscar){
            consultarMascota(tablaMascotas);
            
        }
        if(e.getSource()==btnConsultarLista){
            VentanaConsulta ventanaConsulta= new VentanaConsulta (this, true, tablaMascotas);
            ventanaConsulta.setVisible(true);
            
        }
        if(e.getSource()==btnEliminar){
            eliminarMascota(tablaMascotas);
            
        }
    }
    
    private void eliminarMascota(Hashtable<String, Mascota> tablaMascotas) {
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre de la mascota a eliminar");
                if(tablaMascotas.containsKey(nombre)){
                    tablaMascotas.remove(nombre);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Ese nombre no existe!!","Error", JOptionPane.ERROR_MESSAGE);
                   
                }
        }
  

    private void registrarMascota(Hashtable<String, Mascota> tablaMascotas) {
        Mascota mascotita= new Mascota();
        mascotita.setNombre(campoNombre.getText());
        mascotita.setColor(campoColor.getText());
        mascotita.setEdad(Integer.parseInt(campoEdad.getText()));
        mascotita.setRaza(campoRaza.getText());
        mascotita.setNivel_de_entrenamiento(Integer.parseInt(campoNivelEntrenamiento.getText()));
        mascotita.setTexoplasmosis(campoTexoplasmosis.getText());
        
        if(tablaMascotas.containsKey(mascotita.getNombre())==false){
            tablaMascotas.put(mascotita.getNombre(), mascotita);
            System.out.println("Almacena");
            limpiarCampos();
        }else{
            JOptionPane.showMessageDialog(null, "Ese nombre ya lo tiene una mascota!!","Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
    }

    private void consultarMascota(Hashtable<String, Mascota> tablaMascotas) {
        String mensaje =" DATOS DE LA MASCOTA\n";
        String nombre= JOptionPane.showInputDialog("Ingrese el nombre de la mascota");
        if(tablaMascotas.containsKey(nombre)==true){
            Mascota mascota = tablaMascotas.get(nombre);
            mensaje+= "Nombre: "+mascota.getNombre()+"\n";
            mensaje+= "Color: "+mascota.getColor()+"\n";
            mensaje+= "Raza: "+mascota.getRaza()+"\n";
            mensaje+= "Edad: "+mascota.getEdad()+"\n";
            mensaje+= "Nivel de entrenamiento: "+mascota.getNivel_de_entrenamiento()+"\n";
            mensaje+= "Texoplasmosis: "+mascota.getTexoplasmosis()+"\n";
            
            JOptionPane.showMessageDialog(null, mensaje);
            
        }else{
            JOptionPane.showMessageDialog(null, "Ese nombre no existe!!","Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    private void limpiarCampos() {
        campoNombre.setText(""); campoRaza.setText("");
        campoColor.setText(""); campoEdad.setText("");
        campoNivelEntrenamiento.setText(""); campoTexoplasmosis.setText("");
   }
    
}
