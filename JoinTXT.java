import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class JoinTXT{ 
	public static void main(String[] args) throws IOException{  
		
		String RutaImg = "C:/fotos_rtm/c.txt"; 
        String RutaVariables = "C:/fotos_rtm/w.txt";
        
        String img = ExtraerData(RutaImg);
        String var = ExtraerData(RutaVariables);
        
        CrearTXT(var + img);		
 
	}

	public static String ExtraerData(String ruta) throws FileNotFoundException, IOException{
        String cadena;
        String linea = null;
        FileReader f = new FileReader(ruta);
        BufferedReader b = new BufferedReader(f);
            while( (cadena = b.readLine()) != null){
                linea = cadena;
            }
        
        return linea;
    }
    
    public static void CrearTXT(String text) throws IOException{
        String ruta = "C:/fotos_rtm/final.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(text);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(text);
        }
        bw.close();
        }


}