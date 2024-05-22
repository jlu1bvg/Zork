package minizorks.undertale.TextAdventure.src.zork;

import java.util.ArrayList;
import java.util.HashMap;

public class ActOptions {
    public static HashMap<String, ArrayList<Action>> actOptions = new HashMap<>();

    static {
        Action t;
        ArrayList<Action> actions = new ArrayList<>();
        t = new Action("CHECK", "Life is difficult for this enemy. FROGGIT: \"Ribbit, ribbit \"");
        actions.add(t);
        t = new Action("COMPLIMENT",
                "Froggit didn't understand what you said, but was flattered anyway. FROGGIT: \"(Blushes deeply) Ribbit..",
                true);
        actions.add(t);
        t = new Action("THREAT",
                "Froggit didn't understand what you said, but was scared anyways. FROGGIT: \"Shiver, shiver\"");
        actions.add(t);

        actOptions.put("froggit", actions);

        ArrayList<Action> actions1 = new ArrayList<>();

        t = new Action("CHECK",
                "Serving Size: 1 Monster Not monitored by the USDA. VEGETOID: \"Farmed locally, very locally\"");
        actions1.add(t);
        t = new Action("TALK", "Plants can't talk dummy. VEGETOID: \"Plants can't talk dummy!\"");
        actions1.add(t);
        t = new Action("DINNER", "You pat your stomach. Vegatoid offers a healthy meal. VEGETOID: \"Eat Your Greens\"",
                true);
        actions1.add(t);
        t = new Action("DEVOUR", "You took a bite out of Vegatoid.");
        actions1.add(t);

        actOptions.put("vegetoid", actions1);

        ArrayList<Action> actions2 = new ArrayList<>();

        t = new Action("CHECK", "This monster is too sensitive to fight... WHUMSUN: \"I'm sorry...\"");
        actions2.add(t);
        t = new Action("CONSOLE",
                "Halfway through your first word, whimsun bursts into tears. WHIMSUN: \"*sniff, sniff\"", true);
        actions2.add(t);
        t = new Action("TERRORIZE",
                "You raise your arms and wiggle your fingers. Whimsun freaks out!. WHIMSUN: \"I can't handle this...\"");
        actions2.add(t);

        actOptions.put("whimsun", actions2);

        ArrayList<Action> actions3 = new ArrayList<>();

        t = new Action("CHECK", "Don't pick on him. Family name: Eyewalker. LOOX: \"Please don't pick on me\"");
        actions3.add(t);
        t = new Action("DON'T PICK ON", "LOOX: Finally someone gets it.");
        actions3.add(t);
        t = new Action("PICK ON", "LOOX: You litle rude snipe", true);
        actions3.add(t);

        actOptions.put("loox", actions3);

        ArrayList<Action> actions4 = new ArrayList<>();

        t = new Action("CHECK", "Greater Dog");
        actions4.add(t);
        t = new Action("BECKON", "You call the greater dog. It bounds towards you, flecking slobber into your face.");
        actions4.add(t);
        t = new Action("IGNORE", "Greater dog inches closer");
        actions4.add(t);
        t = new Action("PET",
                "Greater dog curls up in your lap as it is pet by you. It gets so comfortable it falls asleep... zzzzzz THen it wakes up! It's so excited!",
                true);
        actions4.add(t);
        t = new Action("PLAY",
                "You make a snowball and throw it for the dog to fetch. It splats on the ground, Greater dog picks up all the snow in the area and brings it to you. Now dog is very tired... It rests its head on you");
        actions4.add(t);

        actOptions.put("greaterdog", actions4);

        ArrayList<Action> actions5 = new ArrayList<>();

        t = new Action("CHECK",
                " This teens comedian fights to keep a captive audience. SNOWDRAKE: \" M.. m.. macaroni and \"freeze\" \"");
        actions5.add(t);
        t = new Action("HECKLE", "You boo the snowdrake. SNOWDRAKE: \"THIS won't be dunny either!\"");
        actions5.add(t);
        t = new Action("LAUGH", "You laugh at Snowdrake's pun. SNOWDRAKE: \"See!? Laughs@ Dad was wrong!\"", true);
        actions5.add(t);
        t = new Action("JOKE", "Snowdrake is pleased. SNOWDRAKE: \"Is that s'posed to be funny?\"");
        actions5.add(t);

        actOptions.put("snowdrake", actions5);

        ArrayList<Action> actions6 = new ArrayList<>();

        t = new Action("CHECK",
                " This teen wonders why it isn't named 'Ice Hat'. ICECAP: \"Your head looks so.. NAKED!\"");
        actions6.add(t);
        t = new Action("IGNORE",
                "You manage to tear your eyes away from Ice Cap's hat. ICECAP: \" HELLO??? My Hat's up here\"");
        actions6.add(t);
        t = new Action("STEAL",
                "You tried to steal Ice Cap's hat.... and succeeded! (It melts in your hands...). ICECAP: \"I... i...\"");
        actions6.add(t);
        t = new Action("COMPLIMENT", "ICECAP: ENVIOUS? TOO BAD! ");
        actions6.add(t);

        actOptions.put("icecap", actions6);

        ArrayList<Action> actions7 = new ArrayList<>();

        t = new Action("CHECK",
                "MOLDSMAL - Stereotypical: curvaceously attractive, but no brains.. MOLDSMAL: \"Sexy wiggle\"");
        actions7.add(t);
        t = new Action("FLIRT",
                "You wiggle your hips. Moldsmal wiggles back. What a meaningful conversation!  MOLDSMAL: \"Burble burb...\"");
        actions7.add(t);
        t = new Action("IMITATE",
                "You lie immobile with Moldsmal. You feel like you understand ther world a little better... MOLDSMAL: \"Slime Sounds*\"");
        actions7.add(t);

        actOptions.put("moldsmal", actions7);

        ArrayList<Action> actions8 = new ArrayList<>();

        t = new Action("CHECk", "This seahorse has a lot of HP (horsepower). AARON: \"CHECK all you want ; )\"");
        actions8.add(t);
        t = new Action("FLEX",
                "You flex. Aaron flexes twice as hard. ATTACK increases for you too. AARON: \"Flexing contest? OK. Flex more ;\"");
        actions8.add(t);
        t = new Action("SHOO", "You tell Aaron to go away. AARON: \"Wow! Spunky! Love it;\"");
        actions8.add(t);

        actOptions.put("aaron", actions8);

        ArrayList<Action> actions9 = new ArrayList<>();

        t = new Action("CHECK", "This humble germophobe seeks to cleanse the whole world. WOSHUA: \"Wosh face\"");
        actions9.add(t);
        t = new Action("TOUCH", "You reach out. Woshua recoils from your touch. WOSHUA: \"Yuck!\"");
        actions9.add(t);
        t = new Action("CLEAN", "You ask Woshua to clean you. It hops around excitidely. \"Green means clean\"");
        actions9.add(t);
        t = new Action("JOKE",
                "You tell a joke about a kid who ate a pie with their bare hands. Woshua's power neutralized. \"NO. THAT JOKE'S TOO... DIRTY\"");
        actions9.add(t);

        actOptions.put("woshua", actions9);

        ArrayList<Action> actions10= new ArrayList<>();

        t = new Action("CHECK", "It's future looks brighter and brighter. FINALFROGGIT: \"Skip, Jump\"");
        actions10.add(t);
        t = new Action("THREATEN",
                "You threaten the Final froggit. It understood you perfectly. Its DEFENCE dropped. FINALFROGGIT: \"Shudder shudder\"");
        actions10.add(t);
        t = new Action("COMPLIMENT",
                "You compliment final froggit. It understood you perfefctly. Its ATTACK dropped. FINALFROGGIT: \"Nod, nod\"");
        actions10.add(t);
        t = new Action("MYSTIFY",
                "You did something mysterious. Final Froggit recognizes it has more to learn from this world. \"(Thoughful croak)\"");
        actions10.add(t);

        actOptions.put("finalfroggit", actions10);

        ArrayList<Action> actions11 = new ArrayList<>();

        t = new Action("CHECK", "This megaton mercenary wields the good morningstar. KNIGHTKNIGHT: \"Adieu\"");
        actions11.add(t);
        t = new Action("SING",
                "You sing shyren's song. Knight Knight starts to look sleepy... KNIGHTKNIGHT: \"Close your eyes\"");
        actions11.add(t);
        t = new Action("TALK", "You ask Knight Knight about her day. There's no response. \"...\"");
        actions11.add(t);

        actOptions.put("knightknight", actions11);

        ArrayList<Action> actions12 = new ArrayList<>();

        t = new Action("CHECK", "If she invites you to her parlor, excuse yourself. \"Don't look so blue, my deary\"");
        actions12.add(t);
        t = new Action("STRUGGLE",
                "You struggle to escape the web. Muffet covers her mouth and giggles at you. \"Why so pale, you should be proud\"");
        actions12.add(t);

        actOptions.put("muffet", actions12);

        ArrayList<Action> actions13 = new ArrayList<>();

        t = new Action("CHECK", "He likes to say: \"Nyeh heh heh!\"");
        actions13.add(t);
        t = new Action("INSULT", "You INSULT, but to no avail. Seems ACTing won't escalate this battle...");
        actions13.add(t);
        t = new Action("FLIRT",
                "   PAPYRUS: \"What! Fl-Flirting! So you finally reveal your ultimate feelings. w-well! im a skelton with very high standards!\"");
        actions13.add(t);

        actOptions.put("papyrus", actions13);

        ArrayList<Action> actions14 = new ArrayList<>();

        t = new Action("CHECK", "");

        actions14.add(t);

        actOptions.put("asgore", actions14);
    }
}
