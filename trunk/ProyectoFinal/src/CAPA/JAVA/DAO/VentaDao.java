/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAPA.JAVA.DAO;

/**
 *
 * @author MLFCR
 */
public class VentaDao {
    
//    //Atributos
//    public ArrayList<Venta> aVenta;
//    public String archivo;
//
//    // Constructor
//    public VentaController(String archivo) {
//        this.archivo = archivo;
//        aVenta = new ArrayList<>();
//        cargar();
//    }
//
//    // Carga Ventas del archivo
//    private void cargar() {
//        try {
//            int numero, cliente;                    
//            String fecha,tcomprobante, linea;
//            double tventa;
//            BufferedReader br;
//            StringTokenizer st;
//            br = new BufferedReader(new FileReader("C:\\minimarket\\Ventas.txt"));
//
//            while ((linea = br.readLine()) != null) {
//                st = new StringTokenizer(linea, ",");
//                numero = Integer.parseInt(st.nextToken().trim());
//                fecha = st.nextToken().trim();
//                tcomprobante = st.nextToken().trim();
//                cliente=Integer.parseInt(st.nextToken().trim());
//                tventa = Double.parseDouble(st.nextToken().trim());
//  
//                // Para metodo mostrar agregar: JOptionPane.showMessageDialog(null, st);
//                aVenta.add(new Venta(numero, fecha, tcomprobante, cliente, tventa));
//            }
//            br.close();
//        } catch (IOException | NumberFormatException x) {
//            System.out.println(x.toString());
//        }
//    }
//
//    // Guarda los Ventas al archivo
//    public void guardar() {
//        try {
//            PrintWriter pw;
//            pw = new PrintWriter(new FileWriter("C:\\minimarket\\Ventas.txt"));
//
//            //	Recorrido del ArrayList
//            for (Venta aux : aVenta) {
//                pw.println(aux.getNumero() + ","
//                        + aux.getFecha() + ","
//                        + aux.getTcomprobante() + ","
//                        + aux.getCliente() + ","
//                        + aux.getTventa());
//            }
//            pw.close();
//        } catch (Exception x) {
//            System.out.println(x.toString());
//        }
//    }
//
//    // Busca un Venta
//    public Venta buscarVenta(int numero) {
//        for (int i = 0; i < aVenta.size(); i++) {
//            Venta ven = (Venta) aVenta.get(i);
//            if (numero == ven.getNumero()) {
//                return ven;
//            }
//        }
//        return null;
//    }
//    
//    public int buscarVenta(Venta ven){
//        return aVenta.indexOf(ven);
//    }
//    
//    // Inserta un Venta
//    public void adicionarVenta(Venta ven) {
//        aVenta.add(ven);
//    }
//    
//    //Modifica un Venta
//    public void modificarVenta(int numVen, String fecVen, String tcomprobante, int cliente, Double totalVen) {
//        Venta VentaAmodificar=buscarVenta(numVen);
//        VentaAmodificar.setFecha(fecVen);
//        VentaAmodificar.setTcomprobante(tcomprobante);
//        VentaAmodificar.setCliente(cliente);
//        VentaAmodificar.setTventa(totalVen);
//    }
//   
//    // Elimina un Venta
//    public void eliminarVenta(Venta ven) {
//        aVenta.remove(ven);
//    }
//    
//    // Retorna el Venta de la posición dada
//    public Venta obtenerVenta(int indice) {
//        return (Venta) aVenta.get(indice);
//    }
//    
//    // Retorna la cantidad de Ventas
//    public int numeroVentas() {
//        return aVenta.size();
//    }
//
//    // Genera un nuevo código
//    public int nuevoCodigo() {
//        if (!aVenta.isEmpty())
//            return aVenta.get(aVenta.size()-1).getNumero()+1;
//        else
//            return 1;
//    }
}
