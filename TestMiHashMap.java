/**
 * Testea la clase MiHashMap.
 * 
 * @author Miguel Bayón 
 * @version 1.0
 */
public class TestMiHashMap
{
    private int numeroTestsFallados;

    /**
     * Constructor for objects of class TestArrayListInt
     */
    public TestMiHashMap()
    {   
        numeroTestsFallados = 0;    
        
        //size y isEmpty
        System.out.println("Creando hashmap vacio...");
        MiHashMap hashmap = new MiHashMap();  
        numeroTestsFallados += testea(0, hashmap.size(), "size()");
        numeroTestsFallados += testea(true, hashmap.isEmpty(), "isEmpty()");
        
        //cointainsKey y containsValue
        numeroTestsFallados += testea(false, hashmap.containsKey("x"), "containsKey('x')");
        numeroTestsFallados += testea(false, hashmap.containsValue(5), "containsKey(5)");
        
        //clear
        System.out.println();
        System.out.println("Vaciando hashmap vacio...");
        hashmap.clear();
        numeroTestsFallados += testea(0, hashmap.size(), "clear()");
        
        //put
        System.out.println();
        System.out.println("Añadiendo 3 entradas...");
        numeroTestsFallados += testea(-1, hashmap.put("a", 0), "put('a', 100)");
        numeroTestsFallados += testea(-1, hashmap.put("b", 1), "put('b', 101)");
        numeroTestsFallados += testea(-1, hashmap.put("c", 2), "put('c', 102)");  
        
        //get
        System.out.println();
        System.out.println("Obteniendo las 3 entradas...");    
        numeroTestsFallados += testea(0, hashmap.get("a"), "get('a')");
        numeroTestsFallados += testea(1, hashmap.get("b"), "get('b')");
        numeroTestsFallados += testea(2, hashmap.get("c"), "get('c')"); 
        
        //get
        System.out.println();
        System.out.println("Obteniendo una entrada inexistente...");    
        numeroTestsFallados += testea(-1, hashmap.get("z"), "get('z')");        
        
        //cointainsKey y containsValue
        numeroTestsFallados += testea(true, hashmap.containsKey("a"), "containsKey('a')");
        numeroTestsFallados += testea(true, hashmap.containsKey("b"), "containsKey('b')");
        numeroTestsFallados += testea(true, hashmap.containsKey("c"), "containsKey('c')");    
        numeroTestsFallados += testea(false, hashmap.containsKey("z"), "containsKey('z')");         
        numeroTestsFallados += testea(true, hashmap.containsValue(0), "containsValue(0)");
        numeroTestsFallados += testea(true, hashmap.containsValue(1), "containsValue(1)");
        numeroTestsFallados += testea(true, hashmap.containsValue(2), "containsValue(2)");     
        numeroTestsFallados += testea(false, hashmap.containsValue(300), "containsValue(300)");          
                
        //put
        System.out.println();
        System.out.println("Sobreescribiendo todas las entradas...");
        numeroTestsFallados += testea(0, hashmap.put("a", 100), "put('a', 100)");
        numeroTestsFallados += testea(1, hashmap.put("b", 101), "put('b', 101)");
        numeroTestsFallados += testea(2, hashmap.put("c", 102), "put('c', 102)");         
        
        //get
        System.out.println();
        System.out.println("Obteniendo las 3 entradas nuevas...");
        numeroTestsFallados += testea(100, hashmap.get("a"), "get('a', 100)");
        numeroTestsFallados += testea(101, hashmap.get("b"), "get('b', 101)");
        numeroTestsFallados += testea(102, hashmap.get("c"), "get('c', 102)"); 
        
        //size y isEmpty    
        numeroTestsFallados += testea(3, hashmap.size(), "size()");    
        numeroTestsFallados += testea(false, hashmap.isEmpty(), "isEmpty()");
        
        //cointainsKey y containsValue
        numeroTestsFallados += testea(true, hashmap.containsKey("a"), "containsKey('a')");
        numeroTestsFallados += testea(true, hashmap.containsKey("b"), "containsKey('b')");
        numeroTestsFallados += testea(true, hashmap.containsKey("c"), "containsKey('c')");    
        numeroTestsFallados += testea(false, hashmap.containsKey("z"), "containsKey('z')");         
        numeroTestsFallados += testea(false, hashmap.containsValue(0), "containsValue(0)");
        numeroTestsFallados += testea(true, hashmap.containsValue(100), "containsValue(100)");
        numeroTestsFallados += testea(true, hashmap.containsValue(101), "containsValue(101)");
        numeroTestsFallados += testea(true, hashmap.containsValue(102), "containsValue(102)");        
        numeroTestsFallados += testea(false, hashmap.containsValue(300), "containsValue(300)");        
        
        //clear
        System.out.println();
        System.out.println("Vaciando hashmap con entradas...");
        hashmap.clear();
        numeroTestsFallados += testea(0, hashmap.size(), "clear()");        

        //put 
        System.out.println();
        System.out.println("Añadiendo 3 entradas...");
        numeroTestsFallados += testea(-1, hashmap.put("aa", 22), "put('aa', 22)");
        numeroTestsFallados += testea(-1, hashmap.put("bb", 23), "put('bb', 23)");
        numeroTestsFallados += testea(-1, hashmap.put("cc", 24), "put('cc', 24)");          

        //remove
        System.out.println();
        System.out.println("Borrando segunda entrada...")    ;   
        numeroTestsFallados += testea(23, hashmap.remove("bb"), "remove('bb')"); 
        
        //remove
        System.out.println();
        System.out.println("Borrando una entrada inexistente...");     
        numeroTestsFallados += testea(-1, hashmap.remove("zz"), "remove('zz')");       
        
        //remove
        System.out.println();
        System.out.println("Borrando resto de entradas...");       
        numeroTestsFallados += testea(22, hashmap.remove("aa"), "remove('aa')");         
        numeroTestsFallados += testea(24, hashmap.remove("cc"), "remove('cc')");         

        //remove
        System.out.println();
        System.out.println("Borrando una entrada inexistente de un hashmap vacio...") ;      
        numeroTestsFallados += testea(-1, hashmap.remove("zz"), "remove('zz')");  
        
        System.out.println();
        if (numeroTestsFallados == 0) {
            System.out.println("Todos los test se han pasado correctamente!!");
        }
        else {
            System.out.println("Han fallado " + numeroTestsFallados + " tests!!!");
        }
    }


    /**
     * Testea que el valorEsperado sea igual al valorObtenido; si no
     * son iguales devuelve 1 y muestra un mensaje por pantalla; si
     * son iuales devuelve 0 e informa por pantalla de que el test
     * indicado en nombreFuncion se ha pasado correctamente
     */
    public int testea(Object valorEsperado, Object valorObtenido, 
                          String nombreFuncion)
    {
        int valorDevuelto = 0;
        if (valorEsperado == valorObtenido) {
            System.out.println("OK: " + nombreFuncion);
        }
        else {
            System.out.println("ERROR!!!!! " + nombreFuncion);
            System.out.println("Valor obtenido: " + valorObtenido + 
                               " / Valor esperado: " + valorEsperado);
            valorDevuelto = 1;
        }
        return valorDevuelto;
    }

}