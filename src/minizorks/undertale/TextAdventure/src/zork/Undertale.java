package minizorks.undertale.TextAdventure.src.zork;

public class Undertale {
  public static void runUndertale(){
    KeyListener.keyListener.startListening();
    Game.game.play();
    KeyListener.keyListener.stopListening();
  }
}