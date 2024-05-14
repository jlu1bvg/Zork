// package minizorks.whodunit.Parallel.src.zork.commands;

// import minizorks.whodunit.Parallel.src.zork.Game;
// import minizorks.whodunit.Parallel.src.zork.Constants.ArgumentCount;
// import minizorks.whodunit.Parallel.src.zork.proto.Player;
// import minizorks.whodunit.Parallel.src.zork.proto.Room;
// import minizorks.whodunit.Parallel.src.zork.proto.Command;
// import minizorks.whodunit.Parallel.src.zork.proto.Exit;
// import minizorks.whodunit.Parallel.src.zork.proto.Item;

// public class Unlock extends Command{

//     public Unlock() { super("Unlock", "Unlocks a room, if you have the key, of course", ArgumentCount.INFINITE); }

//     @Override
//     public void runCommand(String... args) {
//         Player player = Game.player;

//         String name = args[0];

//         if (name == null) {
//             System.out.printf("Room [%s] does not exist\n", name);
//             return;
//         }

//         for (Item item : player.getInventory().getContents()) {
//             if (item.getId().equalsIgnoreCase(name+"Key")) { 

//                 for (Room room : Game.roomMap.values()) {
//                     for (Exit e : room.getExits()) {
//                         if (e.)
//                     }
//                 }

//                 e.setLocked(false); 

//                 try {
//                     player.setCurrentRoom(e.getAdjacentRoom());
//                     Game.print("/bYou have just unlocked "+player.getCurrentRoom().getRoomName()+"!");
//                     System.out.printf("You just travelled to [%s]!\n\n", player.getCurrentRoom().getRoomName());
//                     System.out.println(player.getCurrentRoom().longDescription());
//                 } catch (Exception ex) {
//                     ex.printStackTrace();
//                 }
//                 return;
//             }
//         }
//     }
    
// }
