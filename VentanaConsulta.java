
package centroRescate;

import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaConsulta extends JDialog{
    
    private JScrollPane scrollArea;
    private JTextArea textArea;
    
    public VentanaConsulta(Vista vista, boolean modal, Hashtable<String, Mascota> tablaMascotas){
        super(vista, modal);
        initialice();
        setLocationRelativeTo(null);
        
        mostrarListaMascotas(tablaMascotas);
    }

   
    private void initialice(){
        setSize(300,208);
        getContentPane().setLayout(null);
        
        textArea = new JTextArea();
        textArea.setBounds(10,33,264,102);
        
        scrollArea = new  JScrollPane();
        scrollArea.setBounds(10,50,264,102);
        scrollArea.setViewportView(textArea);
        getContentPane().add(scrollArea);
        
        JLabel lblConsultaDeMascota = new JLabel("CONSULTA DE MASCOTA");
        lblConsultaDeMascota.setBounds(10,11,153,23);
        getContentPane().add(lblConsultaDeMascota);
    }
    
    private void mostrarListaMascotas(Hashtable<String, Mascota> tablaMascotas) {
        String mensaje="";
        
        Enumeration<Mascota> elemento=tablaMascotas.elements();
        while (elemento.hasMoreElements()) {
            Mascota mascota = elemento.nextElement();
            mensaje+="Nombre: "+mascota.getNombre()+"    Raza: "+mascota.getRaza()+"\n";
            mensaje+="Color: "+mascota.getColor()+"    Edad: "+mascota.getEdad()+"\n";
            mensaje+="Nivel de entrenamiento: "+mascota.getNivel_de_entrenamiento()+"    Texoplasmosis: "+mascota.getTexoplasmosis()+"\n\n";
            
        }
        textArea.setText(mensaje);
    }

}
