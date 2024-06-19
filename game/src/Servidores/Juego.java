package Servidores;

/**
 *
 * @author Ander Monreal
 */
class Juego {
    private final char[][] tablero;
    String jugador1, jugador2;
    int puntuacion1, puntuacion2;

    public Juego(){
        // Creo el tablero al inicializar el objeto, creo 4 espacion tanto para filas como para columnas para evitar errores a la hora de comprobar si se ha formado OSO
        this.tablero = new char[14][14];
        for(int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                this.tablero[i][j] = ' '; // Asignar un espacio en blanco
            }
        }
        
        // Inicializo las variables de informacion
        this.jugador1 = " ";
        this.jugador2 = " ";
        this.puntuacion1 = 0;
        this.puntuacion2 = 0;
    }
    
    // Devuelvo un String para mandar con el movimiento entero 
    private String es_partida_terminada(char[][] tablero){
        for (int i = 2; i < 13; i++) {
            for (int j = 2; j < 13; j++) {
                if (tablero[i][j] == ' '){
                    return("NO");
                }
            }
        }
        return("SI");
    }
    
    public void realizar_movimiento(int fila, int col, char letra){
        this.tablero[fila][col] = letra;
    }   
    
    private boolean casilla_ocupada(char[][] tablero, int fila, int col){
        return(tablero[fila][col] == 'S' || tablero[fila][col] == 'O');
    }
    
    public void mostrar_tablero(){
        for(int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    synchronized public String nuevoOSO(String nombreJug, int fila, int col, char letra){
        if (" ".equals(this.jugador1)){
            this.jugador1 = nombreJug;
        }
        else if(!" ".equals(this.jugador1) && " ".equals(this.jugador2)){
            this.jugador2 = nombreJug;
        }
        
        // Es necesario para la comprobacion del tablero, de esta manera estoy dejando un marjen para que a la hora de comprobar si se ha formado oso, los extremos no nos de error
        int i = fila + 2;
        int j = col + 2;
        int puntuacion = 0;
        
        if(!casilla_ocupada(this.tablero,i,j)){ // Si la casilla no esta ocupada ...
            realizar_movimiento(i,j,letra);
            System.out.println(casilla_ocupada(this.tablero,i,j));
            System.out.println(i+", "+j);
            if(letra == 'O'){
                if(this.tablero[i-1][j] == 'S' || this.tablero[i-1][j-1] == 'S' || this.tablero[i-1][j+1] == 'S' || this.tablero[i][j-1] == 'S'|| this.tablero[i][j+1] == 'S' || this.tablero[i+1][j-1] == 'S' || this.tablero[i+1][j] == 'S' || this.tablero[i+1][j+1] == 'S'){
                    if(this.tablero[i-1][j] == 'S'){
                        if(this.tablero[i-2][j] == 'O'){
                            puntuacion++;
                        }   
                    }
                    if(this.tablero[i-1][j-1] == 'S'){
                        if(this.tablero[i-2][j-2] == 'O'){
                            puntuacion++;
                        }                    
                    }
                    if(this.tablero[i-1][j+1] == 'S'){
                        if(this.tablero[i-2][j+2] == 'O'){
                            puntuacion++;
                        }                    
                    }
                    if(this.tablero[i][j-1] == 'S'){
                        if(this.tablero[i][j-2] == 'O'){
                            puntuacion++;
                        }                   
                    }
                    if(this.tablero[i][j+1] == 'S'){
                        if(this.tablero[i][j+2] == 'O'){
                            puntuacion++;
                        }                   
                    }
                    if(this.tablero[i+1][j-1] == 'S'){
                        if(this.tablero[i+2][j-2] == 'O'){
                            puntuacion++;
                        }                  
                    }
                    if(this.tablero[i+1][j] == 'S'){
                        if(this.tablero[i+2][j] == 'O'){
                            puntuacion++;
                        }                  
                    }
                    if(this.tablero[i+1][j+1] == 'S'){
                        if(this.tablero[i+2][j+2] == 'O'){
                            puntuacion++;
                        }                   
                    }
                }
            }
            else if(letra == 'S'){
                if(this.tablero[i-1][j-1] == 'O' && this.tablero[i+1][j+1] == 'O'){
                    puntuacion++;
                }
                if(this.tablero[i-1][j+1] == 'O' && this.tablero[i+1][j-1] == 'O'){
                    puntuacion++;
                }
                if(this.tablero[i-1][j] == 'O' && this.tablero[i+1][j] == 'O'){
                    puntuacion++;
                }
                if(this.tablero[i][j-1] == 'O' && this.tablero[i][j+1] == 'O'){
                    puntuacion++;
                }    
            }
            
        }
        String mensaje = es_partida_terminada(this.tablero);
        System.out.println("Puntuaciones: " + this.puntuacion1+": "+this.puntuacion2+": "+puntuacion);
        if(this.jugador1.equals(nombreJug)){
            this.puntuacion1 = this.puntuacion1+puntuacion;
            return(this.jugador1+"-"+this.puntuacion1+"-"+this.jugador2+"-"+this.puntuacion2+"-"+fila+"-"+col+"-"+this.tablero[i][j]+"-"+mensaje);
        }else{
            this.puntuacion2 = this.puntuacion2+puntuacion;
            return(this.jugador2+"-"+this.puntuacion2+"-"+this.jugador1+"-"+this.puntuacion1+"-"+fila+"-"+col+"-"+this.tablero[i][j]+"-"+mensaje);
        } 
    }
}
