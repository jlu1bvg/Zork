package zork.commands;

import zork.commands.objective;
import zork.utils.Ascii;
import java.util.concurrent.TimeUnit;
import zork.Game;

public class interact {
    static String[] frames = {
            """
                        ____       
                  ____ |  _ \\      
                 /   /_| | | |     
                 |__/__|_|_|_|__   
                     /_ _  _ _\\    
                     /_ _  _ _\\    
                    (____________) 
            """,
            """
                                     ____       
                                ____ |  _ \\      
                               /   /_| | | |     
                               |__/__|_|_|_|__   
                                   /_ _  _ _\\    
                                   /_ _  _ _\\    
                                  (____________) 
            """,
            """
                                          ____       
                                     ____ |  _ \\      
                                    /   /_| | | |     
                                    |__/__|_|_|_|__   
                                        /_ _  _ _\\    
                                        /_ _  _ _\\    
                                       (____________) 
            """,
            """
                                                ____       
                                           ____ |  _ \\      
                                          /   /_| | | |     
                                          |__/__|_|_|_|__   
                                              /_ _  _ _\\    
                                              /_ _  _ _\\    
                                             (____________) 
            """,
            """
                                                     ____       
                                                ____ |  _ \\      
                                               /   /_| | | |     
                                               |__/__|_|_|_|__   
                                                   /_ _  _ _\\    
                                                   /_ _  _ _\\    
                                                  (____________) 
            """,
            """
                                                          ____       
                                                     ____ |  _ \\      
                                                    /   /_| | | |     
                                                    |__/__|_|_|_|__   
                                                        /_ _  _ _\\    
                                                        /_ _  _ _\\    
                                                       (____________) 
            """,
            """
                                                               ____       
                                                          ____ |  _ \\      
                                                         /   /_| | | |     
                                                         |__/__|_|_|_|__   
                                                             /_ _  _ _\\    
                                                             /_ _  _ _\\    
                                                            (____________) 
            """,
    };
    public static void interactWithItem(String item) {
        if(item.equalsIgnoreCase("snowcat")){
            if(objective.getCarPartsFound() == 5 && Game.getRoom().getRoomName().equalsIgnoreCase("garage")){
                for (String frame : frames) {
                    Ascii.clearScreen();
                    Ascii.printAsciiArtWithAnimation(frame);
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("You have escaped... for now");
            }
        }
        else{
            System.out.println("You can't interact with that item.");
        }
    }
}
