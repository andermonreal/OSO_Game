package Servidores;

/**
 *
 * @author Ander Monreal
 */

public class Servidores {
    
    public static void main(String[] args) {
        ServerChat serverChat = new ServerChat(12000);
        ServerGame serverGame = new ServerGame(12001);
        serverChat.start();
        serverGame.start();
    }    
}