package minizorks.whodunit.Parallel.src.zork.commands;

import java.util.Scanner;

import minizorks.whodunit.Parallel.src.zork.Game;
import minizorks.whodunit.Parallel.src.zork.Constants.ArgumentCount;
import minizorks.whodunit.Parallel.src.zork.proto.Command;
import minizorks.whodunit.Parallel.src.zork.proto.Item;
import minizorks.whodunit.Parallel.src.zork.proto.Exit;
import minizorks.whodunit.Parallel.src.zork.utils.CharacterConstants;
import minizorks.whodunit.Parallel.src.zork.utils.Give;

public class Check extends Command {
    
    public Check() { super("Check", "Checks inside an item in the room", ArgumentCount.INFINITE); } 

    public void runCommand(String... args) {
        String itemName = Item.arrayToString(args);

        switch(Game.player.getCurrentRoom().getRoomName()) {
            case "Your Room":
                if(itemName.equalsIgnoreCase("nightstand")) {
                    if(CharacterConstants.CHECKED_NIGHSTAND_YOUR_ROOM) {
                        Game.print("/bYou already checked inside the nightstand.");
                        return;
                    }
                    Game.print("/bYou looked inside the nightstand.");
                    Game.print("/bYou found a letter addressed to you from your friend Brent.");
                    if(Give.giveItem(Game.itemList.get("letterAddressedToYou"), null))  {
                        Game.print("/bType /rInventory/b into the console to see your current items.");
                        CharacterConstants.CHECKED_NIGHSTAND_YOUR_ROOM = true;
                    }
                } else {
                    Game.print("/b" + itemName + " does not need to be checked.");
                }
                break;
            case "Your Bathroom":
                if(itemName.equalsIgnoreCase("Bathtub")) {
                    if(CharacterConstants.READ_LETTER_FROM_BRENT) {
                        if(CharacterConstants.CHECKED_BATHTUB_YOUR_BATHROOM) {
                            Game.print("/bYou already checked underneath the bathtub.");
                            return;
                        }
                        Game.print("/bYou felt the bathtub was the lake from the clue, so you checked underneath it.");
                        Game.print("/bThere appears to be a trapdoor underneath. Maybe you can get out this way.");
                        Game.print("/bTo enter the trapdoor, type /rGo Down/b in the console.");

                        Exit e = new Exit("Down", "cellar", false, null);
                        try {
                            Game.roomMap.get("userBathroom").addExit(e);
                            CharacterConstants.CHECKED_BATHTUB_YOUR_BATHROOM = true;
                        } catch(Exception ex) { Game.print("/rUnknown error has occured, please restart."); }
                    } else {
                        Game.print("/bWhat? It's just a normal bathtub.");
                    }
                } else {
                    Game.print("/b" + itemName + " does not need to be checked.");
                }
                break;

            case "Glenn's Room":
                if(itemName.equalsIgnoreCase("t-shirt")){
                    if(CharacterConstants.CHECKED_TSHIRT) {
                        Game.print("You already checked the t-shirt.");
                    }
                    Game.print("You picked up one of Glenn's t-shirts which was on the ground, and a piece of paper fell out of it.");
                    Game.print("You pick up the paper and stash it in your inventory.");
                    if(Give.giveItem(Game.itemList.get("glennPaper"), null))  {
                        CharacterConstants.CHECKED_TSHIRT = true;
                    }
                } else {
                    Game.print("/b" + itemName + " does not need to be checked.");
                }
                break;

            case "Cellar":
                if(itemName.equalsIgnoreCase("Crate")) {
                    if(CharacterConstants.CHECKED_CRATE_CELLAR) {
                        Game.print("/bYou already checked inside the crate.");
                        return;
                    }
                    Game.print("/bYou opened the lid of the crate and checked inside.");
                    Game.print("/bYou found a bullet at the bottom of the crate.");
                    if(Give.giveItem(Game.itemList.get("cellarBullet"), null)) {
                        Game.print("/bWhy would a bullet be inside this crate? What is this place?");
                        CharacterConstants.CHECKED_CRATE_CELLAR = true;
                    }
                } else if(itemName.equalsIgnoreCase("Battering Ram")) {
                    if(CharacterConstants.CHECKED_BATTERING_RAM_CELLAR) {
                        Game.print("/bYou already checked out the battering ram.");
                        Game.print("/bThere's a massive hole in the wall because of you.");
                        return;
                    }
                    Game.print("/bThe battering ram is being pointed at the wall.");
                    Game.print("/bWould you like to break down the wall?");
                    Scanner in = new Scanner(System.in);
                    System.out.print("(yes/no): ");
                    while(true) {
                        String answer = in.nextLine();
                        if(answer.equalsIgnoreCase("yes")) {
                            Game.print("/bYou brought the battering ram back as far as you could and thrust it forward.");
                            Game.print("/bIt broke a hole through the wall and revealed another hotel room /rthrough/b.");
                        
                            Exit e = new Exit("Through", "brentRoom", false, null);
                            try {
                                Game.roomMap.get("cellar").addExit(e);
                                CharacterConstants.CHECKED_BATTERING_RAM_CELLAR = true;
                            } catch(Exception ex) { Game.print("/rUnknown error has occured, please restart."); }
                            break;
                        } else if(answer.equalsIgnoreCase("no")) {
                            Game.print("/bYou decided to put down the battering ram.");
                            break;
                        } else {
                            Game.print("/bWhat does " + answer + " mean? Yes or no?");
                        }
                    }
                } else {
                    Game.print("/b" + itemName + " does not need to be checked.");
                }
                break;

            case "Brent's Room":
                if(itemName.equalsIgnoreCase("nightstand")) {
                    Game.print("/bYou looked inside the nightstand.");
                    Game.print("/bThere was nothing inside.");
                    CharacterConstants.CHECKED_NIGHSTAND_BRENT_ROOM = true;
                }
                else if(itemName.equalsIgnoreCase("bed")) {
                    if(CharacterConstants.CHECKED_BED_BRENT_ROOM) {
                        Game.print("/bYou already checked underneath the bed.");
                        return;
                    }
                    Game.print("/bYou looked underneath the bed and found a journal.");
                    Game.print("/bYou found Brent's diary!");
                    if(Give.giveItem(Game.itemList.get("diary"), null))
                        CharacterConstants.CHECKED_BED_BRENT_ROOM = true;
                } else {     
                    Game.print("/b" + itemName + " does not need to be checked.");
                }
                break;

            default:
                Game.print("/b" + itemName + " does not need to be checked.");
                break;

            case "Private Poker Table":
                 if(itemName.equalsIgnoreCase("coat")) {
                    if(CharacterConstants.CHECKED_COAT) {
                        Game.print("/bYou already checked inside the coat.");
                        return;
                    }
                    Game.print("/bYou checked inside the coat.");
                    Game.print("/bYou found a small piece of paper with a strange sequence.");
                    if(Give.giveItem(Game.itemList.get("morse"), null))  { CharacterConstants.CHECKED_COAT = true; }
            } else {
                Game.print("/b" + itemName + " does not need to be checked.");
            }
            break;

            case "Stands":
                if(itemName.equalsIgnoreCase("Lebron's Bag")) {
                    if(CharacterConstants.CHECKED_LEBRONS_BAG) {
                        Game.print("/bLebron's bag is empty. You already took his shoes.");
                        return;
                    }
                    Game.print("/bYou checked inside of Lebron's bag.");
                    Game.print("/bYou found the signed shoes he made for you.");
                    if(Give.giveItem(Game.itemList.get("signedShoes"), null))  { CharacterConstants.CHECKED_LEBRONS_BAG = true; }
                } else {     
                    Game.print("/b" + itemName + " does not need to be checked.");
                }
                break;

        }
    }
}
