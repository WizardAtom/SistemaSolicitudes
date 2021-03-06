
package sistemasolicitudes;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteMatrimonio {
Connection conn=null;
public ReporteMatrimonio()
{
try
{
Class.forName("com.mysql.jdbc.Driver"); //se carga el driver
conn= DriverManager.getConnection("jdbc:mysql://192.168.1.100/recepcion","usuario","archivo123");
//JOptionPane.showMessageDialog(null,"Conexión establecida");
}
catch (Exception ex)
{
    System.out.println(ex);
}
}
public void ejecutarReporte(String solicitud){

    try
    {
        File f = new File (""); // Creamos un objeto file
	//JOptionPane.showMessageDialog(null,f.getAbsolutePath()); // Llamamos al método que devuelve la ruta absoluta
        String archivo = f.getAbsolutePath() + "\\report\\reportPartidas.jasper";
        //JOptionPane.showMessageDialog(null, archivo);
        //String archivo = System.getProperty("user.dir") + "/dist/report/reportPartidas.jasper";
        //String archivo = "C:/SistemaSolicitudes/src/sistemasolicitudes/reportPartidas.jasper";
        //String archivo = "/home/edgar/NetBeansProjects/SistemaSolicitudes/src/sistemasolicitudes/reportPartidas.jasper";

        System.out.println("Cargando desde: " + archivo);
        if(archivo == null){
            System.out.println("No se encuentra el archivo.");
            System.exit(2);
       }
    JasperReport masterReport= null;
    try
    {
        masterReport= (JasperReport) JRLoader.loadObject(archivo);
    }
    catch (JRException e) {
        System.out.println("Error cargando el reporte maestro: " + e.getMessage());
        System.exit(3);
    }
    //este es el parámetro, se pueden agregar más parámetros
    //basta con poner mas parametro.put
    Map parametro= new HashMap();
    parametro.put("solicitud", solicitud);
    //Reporte diseñado y complidado en iReport
    JasperPrint jasperPrint= JasperFillManager.fillReport(masterReport,parametro,conn);
    //Se lanza el View del Jasper, no termina ejecucion delñ Jasper al salir de la aplicacion
    JasperViewer jviewer = new JasperViewer(jasperPrint, false);
    jviewer.setTitle(solicitud);
    jviewer.setVisible(true);
    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }
}
public void cerrar(){
    try {
        conn.close();
    } catch (SQLException ex)
    {
        System.out.println(ex);
    }
}
}
