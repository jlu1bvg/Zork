package zork;

import java.io.File;

import horseracers.multihorserace.HorseRacingAssignment.src.horseracing.HorseRacingHelper;
import zork.utils.Audio;

public class Elevator extends Room {
    private int currentFloor;
    
    // private Audio doorOpen=new Audio("doorOpen","src"+File.separator+"zork"+File.separator+"data"+File.separator+"audio"+File.separator+"Elevator"+File.separator+"dooropen.wav");
    // private Audio doorClose=new Audio("doorClose", "src"+File.separator+"zork"+File.separator+"data"+File.separator+"audio"+File.separator+"Elevator"+File.separator+"doorclose.wav");
    // private Audio buttonClick=new Audio("buttonClick", "src"+File.separator+"zork"+File.separator+"data"+File.separator+"audio"+File.separator+"Elevator"+File.separator+"buttonclick.wav");
    // private Audio upDing=new Audio("upDing", "src"+File.separator+"zork"+File.separator+"data"+File.separator+"audio"+File.separator+"Elevator"+File.separator+"upding.wav");
    // private Audio downDing=new Audio("downDing", "src"+File.separator+"zork"+File.separator+"data"+File.separator+"audio"+File.separator+"Elevator"+File.separator+"downding.wav");
    // private Audio floorBeep=new Audio("floorBeep", "src"+File.separator+"zork"+File.separator+"data"+File.separator+"audio"+File.separator+"Elevator"+File.separator+"elevatorbeep.wav");
    // private Audio moveStart=new Audio("moveStart", "src"+File.separator+"zork"+File.separator+"data"+File.separator+"audio"+File.separator+"Elevator"+File.separator+"movestart.wav");
    // private Audio moveEnd=new Audio("moveEnd", "src"+File.separator+"zork"+File.separator+"data"+File.separator+"audio"+File.separator+"Elevator"+File.separator+"movestop.wav");

    public Elevator(){
        currentFloor=1;
    }

    private void moveFloor(int floor) throws InterruptedException{
        int moveFloor=Math.abs(currentFloor-floor);

        for(int i=0;i<moveFloor;i++){
            // moveStart.play();
            HorseRacingHelper.playBackgroundMusic("src\\zork\\data\\audio\\Elevator\\movestart (online-audio-converter.com).wav", true);
            Thread.sleep(7000);
            // floorBeep.play();
            HorseRacingHelper.playBackgroundMusicAndWait("src\\zork\\data\\audio\\Elevator\\elevatorbeep (online-audio-converter.com).wav");
            // Thread.sleep(1000);
            // floorBeep.stop();
            Thread.sleep(5000);
            // moveStart.stop();
        }

        HorseRacingHelper.stopMusic();
        HorseRacingHelper.playBackgroundMusicAndWait("src\\zork\\data\\audio\\Elevator\\movestop (online-audio-converter.com).wav");
        // moveEnd.play();
        // moveStart.stop();
        // Thread.sleep(500);
        // moveEnd.stop();
    }

    public void callElevator(int floor){

    }

    public void ride(int floor) throws InterruptedException{
        Thread.sleep(2000);
        doorClose();

        Thread.sleep(750);

        moveFloor(floor);

        doorOpen();

        if(currentFloor<floor){
            // upDing.play();
            // Thread.sleep(2500);
            // upDing.stop();
            HorseRacingHelper.playBackgroundMusicAndWait("src\\zork\\data\\audio\\Elevator\\upding (online-audio-converter.com).wav");
        }
        else if(currentFloor>floor){
            // downDing.play();
            // Thread.sleep(2500);
            // downDing.stop();
            HorseRacingHelper.playBackgroundMusicAndWait("src\\zork\\data\\audio\\Elevator\\downding (online-audio-converter.com).wav");
        }
    }

    private void doorOpen() throws InterruptedException{
        // doorOpen.play();
        // Thread.sleep(3500);
        // doorOpen.stop();
        HorseRacingHelper.playBackgroundMusicAndWait("src\\zork\\data\\audio\\Elevator\\dooropen (online-audio-converter.com).wav");
    }

    private void doorClose() throws InterruptedException{
        // doorClose.play();
        // Thread.sleep(3500);
        // doorClose.stop();
        HorseRacingHelper.playBackgroundMusicAndWait("src\\zork\\data\\audio\\Elevator\\doorclose (online-audio-converter.com).wav");
    }
}
