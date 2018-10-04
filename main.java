import java.util.List;
import java.util.ArrayList;

public class main{
    public static void main(String args[]){
        List<String> sitios = new ArrayList<>();
        picking pick = new picking();
        String sitio = pick.readSite("https://programacion.net/articulo/expresiones_regulares_en_java_127");
        sitios = pick.getSites(sitio);
        for(String site: sitios){
            if(!pick.testConnection(site)){
                System.out.println("REMOVIDO - " + site);
            }else{
                System.out.println("APROBADO - " + site);
            }
        }
    }
}