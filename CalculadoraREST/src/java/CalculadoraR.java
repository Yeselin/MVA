
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author yese
 */
@Path("calcular")
public class CalculadoraR {

    public int cantidad = 0;
    public String vector[];
    public String result;
    public List<Integer> listaEnteros;

    @GET
    @Path("{operacion}/{datos:.*}")
    public Response calcular(@PathParam("operacion") String operar,
             @PathParam("datos") String datos) {

        vector = datos.split("/");
        cantidad = vector.length;
        result = operator(operar);

        return Response.status(200)
                .entity("Resultado: " + result)
                .build();
    }

    public String operator(String opera) {
           
        float resultado =0;
        resultado=Integer.valueOf(vector[0]);

        String msj = "";
        
        try {
            switch (opera) {
                case "add":
                    for (int a = 1; a < cantidad; a++) {
                        resultado = resultado + Integer.valueOf(vector[a]);
                    }
                    break;
                case "subs":
                    for (int a = 1; a < cantidad; a++) {
                        resultado = resultado - Integer.valueOf(vector[a]);
                    }
                    break;
                case "mult":
                    for (int a = 1; a < cantidad; a++) {
                        resultado = resultado * Integer.valueOf(vector[a]);
                    }
                    break;
                case "div":
                    try {
                        for (int a = 1; a < cantidad; a++) {
                            resultado = resultado / Integer.valueOf(vector[a]);
                        }
                    } catch (ArithmeticException x) {
                        resultado = 0;
                        msj = "No se permiten divisiones menor o iguales a 0";
                    }
                    break;
                default:
                    throw new AssertionError();
            }

            return String.valueOf(resultado)+ " " +msj;
            
        }catch(NumberFormatException x){
           
            msj="Error al realizar la operacion indicada, favor revisar e intentar nuevamente.";
            return msj;
        }
    }
}
