package sigevi.uti;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sigevi.bea.Cliente;
import sigevi.gui.FormCliente;
import sigevi.map.SqlMapConfig;

public class BusquedaService {
    
    public static List<String> listarClientes() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Cliente> clientes = new ArrayList<>();
        List<String> data = new ArrayList<>();
        try {
            clientes = sqlMapClient.queryForList("listCliente", null);
        } catch (SQLException ex) {
            Logger.getLogger(FormCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cli = clientes.get(i);
            data.add(cli.getNomCli());
        }
        return data;
    }
}
