package sistemasolicitudes;

import java.sql.ResultSet;
import java.sql.SQLException;
public class notarios2 {
    conexion con = new conexion();

    public Object[][] getDatos(String valor){
        int registros = 0;
        try{
            con.conectar();
            ResultSet res = con.consulta("SELECT COUNT(*) AS total FROM notarios;");
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        Object[][] data = new String[registros][5];
        try{
            con.conectar();
            ResultSet res = con.consulta("SELECT cod_not, notario, provincia,fec_ini,fec_fin FROM new_view WHERE notario LIKE '%"+valor+"%';");
            int i=0;
            while(res.next()){
                String codigo = res.getString("cod_not");
                String notario = res.getString("notario");
                String provincia = res.getString("provincia");
                String fecini = res.getString("fec_ini");
                String fecfin = res.getString("fec_fin");
                data[i][0] = codigo;
                data[i][1] = notario;
                data[i][2] = provincia;
                data[i][3] = fecini;
                data[i][4] = fecfin;
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
}