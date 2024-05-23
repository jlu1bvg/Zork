package minizorks.primequest.src.zork.zork.commands;

import java.io.File;
import java.io.IOException;

import minizorks.primequest.src.zork.zork.Command;
import minizorks.primequest.src.zork.zork.Graphics;

public class Help extends Command {

    public Help(String name) {
        super(name);
        addAlias("h");
    }

    @Override
    public String runCommand(String... args){
        final Graphics renderer = new Graphics();
        try {
            renderer.showCutScene(1100, ""+File.separator+"src"+File.separator+"minizorks"+File.separator+"primequest"+File.separator+"bin"+File.separator+"zork"+File.separator+"data"+File.separator+"help.txt", 15);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
}

