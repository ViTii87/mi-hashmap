
/**
 * Write a description of class MiHashMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiHashMap
{
    // Dos arrays para simular el hashmap
    private String[] claves;
    private int[] valores;

    /**
     * Constructor for objects of class MiHashMap
     */
    public MiHashMap()
    {
        this.claves = new String[0];
        this.valores = new int[0]; 
    }

    /**
     * Asocia el valor especificado con la clave especificada. Si la clave existía, entonces 
     * sobreescribe su valor y devuelve el valor antiguo. Si no existía devuelve -1.
     */   
    public int put(String clave, int valor){
        boolean encontrado = false;
        int antiguoValor = -1;
        int i = 0;
        while(i < claves.length && !encontrado){
            if(claves[i].equals(clave)){
                antiguoValor = valores[i];
                valores[i] = valor;
                encontrado = true;
            }
            i++;
        }
        if(!encontrado){
            String[] auxClav = new String[claves.length + 1];
            int[] auxVal = new int[valores.length + 1];
            for(int x = 0; x < claves.length; x++){
                auxClav[x] = claves[x];
                auxVal[x] = valores[x];
            }
            claves = auxClav;
            valores = auxVal;
            claves[claves.length-1] = clave;
            valores[valores.length-1] = valor;
        }
        return antiguoValor;    
    }
    
    /**
     * Devuelve el valor asociado con la clave especificada o -1 en caso de que la clave no exista.
     */
    public int get(String clave){
        int valor = -1;
        boolean encontrado = false;
        int i = 0;
        while(i < claves.length && !encontrado){
            if(claves[i].equals(clave)){
                valor = valores[i];
                encontrado = true;
            }
            i++;
        }
        return valor;
    }
}
