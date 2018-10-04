import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.regex.PatternSyntaxException;
import java.io.InputStreamReader;

public class picking{

    public String readSite(String url){
        String retorno = "";
        try{
            URL ulrobj = new URL(url);
            BufferedReader bs = new BufferedReader(new InputStreamReader(ulrobj.openStream()));
            String txt;
            while ((txt = bs.readLine()) != null){
                retorno += txt;
            }
        }catch(MalformedURLException ex){

        }catch(Exception ex){

        }
        return retorno;
    }

    public boolean testConnection(String url){
        boolean retorno = false;
        try{
            URL call = new URL(url);
            HttpURLConnection con = (HttpURLConnection) call.openConnection();
            con.setRequestMethod("POST");
            System.out.print("[POST] ");
            retorno =  con.getResponseCode() == 200;
            if(!retorno){
                con = (HttpURLConnection) call.openConnection();
                con.setRequestMethod("GET");
                System.out.print("[GET] ");
                retorno =  con.getResponseCode() == 200;
            }else{
                System.out.print("----- ");
            }
        }catch(Exception e){
            System.out.print("[ERR] ");
            retorno = false;
        }
        return retorno;
    }

    public List<String> getSites(String sitio){
        List<String> sitios = new ArrayList<>();
        try{
            Pattern patron = Pattern.compile("http://(\\w+\\.)*(\\w+)");
            Matcher match = patron.matcher(sitio);
            while(match.find()){
                if(!sitios.contains(match.group())){
                    sitios.add(match.group());
                }
            }
            patron = Pattern.compile("https://(\\w+\\.)*(\\w+)");
            match = patron.matcher(sitio);
            while(match.find()){
                if(!sitios.contains(match.group())){
                    sitios.add(match.group());
                }
            }
        }catch(Exception ex){

        }
        return sitios;
    }
}