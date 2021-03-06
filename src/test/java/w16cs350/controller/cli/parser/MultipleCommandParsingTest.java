package w16cs350.controller.cli.parser;

import org.junit.Test;
import w16cs350.controller.ActionProcessor;
import w16cs350.controller.Controller;
import w16cs350.controller.cli.CommandLineInterface;
import w16cs350.controller.command.structural.CommandStructuralCommit;

/**
 * Created by Josh on 2/27/2016.
 */
public class MultipleCommandParsingTest {

    //@Test
    public void test_PatternMatch() throws Exception {

        MyParserHelper help = ParserFactory.buildHelper();

        CommandParser P = new CommandParser(help, "USE r1 AS REFERENCE 46*40'58\"/117*19'21\" ;" +
                "CREATE TRACK BRIDGE\t\t\ttrack13\tREFERENCE $r1 DELTA START 50:0 END 80:0 ;" +
                "CREATE TRACK SWITCH TURNOUT track15 REFERENCE $r1 STRAIGHT DELTA START -50:0 END 0:0 CURVE DELTA START 0:0 END -20:20 DISTANCE ORIGIN 20 ;" +
                "CREATE TRACK SWITCH TURNOUT track16 REFERENCE $r1 STRAIGHT DELTA START -20:0 END -20:60 CURVE DELTA START -20:20 END -10:35 DISTANCE ORIGIN 15 ;" +
                "CREATE TRACK END\t\t\ttrack20\tREFERENCE $r1 DELTA START -10:35 END 40:62 ;" +
                "CREATE TRACK STRAIGHT\t\ttrack2 \tREFERENCE $r1 DELTA START 80:0 END 120:0 ;" +
                "CREATE TRACK BRIDGE DRAW\t\t\ttrack14\tREFERENCE $r1 DELTA START 120:0 END 150:0 ANGLE 45 ;" +
                "CREATE TRACK SWITCH TURNOUT \t\ttrack3\tREFERENCE $r1 STRAIGHT DELTA START 150:0 END 200:0 CURVE DELTA START 150:0 END 200:-30 DISTANCE ORIGIN 50 ;" +
                "CREATE TRACK STRAIGHT \t\ttrack4\tREFERENCE $r1 DELTA START 200:0 END 220:0 ;" +
                "CREATE TRACK STRAIGHT \t\ttrack5\tREFERENCE $r1 DELTA START 200:-30 END 220:-70 ;" +
                "CREATE TRACK CROSSING\t\ttrack6\tREFERENCE $r1 DELTA START 200:-30 END 220:-70 ;" +
                "CREATE TRACK STRAIGHT \t\ttrack11\tREFERENCE $r1 DELTA START 240:0 END 280:0 ;" +
                "CREATE TRACK BRIDGE \t\ttrack7\tREFERENCE $r1 DELTA START 220:-70 END 230:-90 ;" +
                "CREATE TRACK CURVE\t\t\ttrack8\tREFERENCE $r1 DELTA START 300:-30 END 230:-90 ORIGIN 271:-67 ;" +
                "CREATE TRACK CURVE\t\t\ttrack9\tREFERENCE $r1 DELTA START 300:-30 END 290:-10 ORIGIN 329.4:-2.8 ;" +
                "CREATE TRACK CROSSOVER\t\ttrack10 REFERENCE $r1 DELTA START 280:0 END 300:0 START 290:-10 END 290:10 ;" +
                "CREATE TRACK CURVE \t\t\ttrack12\tREFERENCE $r1 DELTA START 290:10 END 300:0 DISTANCE ORIGIN -10 ;" +
                "CREATE TRACK SWITCH WYE\t\ttrack18\tREFERENCE $r1 DELTA START -50:0 END -80:20 DISTANCE ORIGIN 35 DELTA START -80:-20 END -50:0 DISTANCE ORIGIN 35 ;" +
                "CREATE TRACK CURVE\t\t\ttrack19\tREFERENCE $r1 DELTA START -80:-20 END -80:+20 DISTANCE ORIGIN -45 ;" +
                "CREATE TRACK LAYOUT \t\tmylayout WITH TRACKS track18 track15 track16 track17 track1 track13 track2 track14 track3 track4 track5 track6 track11 track7 track8 track9 track10 track12 track19 track20 ;" +
                "CREATE TRACK SWITCH TURNOUT track15 REFERENCE $r1 STRAIGHT DELTA START -50:0 END 0:0 CURVE DELTA START 0:0 END -20:20 DISTANCE ORIGIN 20 ;" +
                "CREATE TRACK SWITCH TURNOUT track16 REFERENCE $r1 STRAIGHT DELTA START -20:0 END -20:60 CURVE DELTA START -20:20 END -10:35 DISTANCE ORIGIN 15 ;" +
                "CREATE TRACK END\t\t\ttrack20\tREFERENCE $r1 DELTA START -10:35 END 40:62 ;" +
                "CREATE TRACK ROUNDHOUSE\t\ttrack17\tREFERENCE $r1 DELTA ORIGIN -20:100 ANGLE ENTRY 180 START 270 END 90 WITH 6 SPURS LENGTH 20 TURNTABLE LENGTH 40 ;" +
                "CREATE TRACK STRAIGHT\t\ttrack1\tREFERENCE $r1 DELTA START 0:0 END 50:0 ;" +
                "CREATE TRACK LAYOUT \t\tmylayout WITH TRACKS track18 track15 track16 track17 track1 track13 track2 track14 track3 track4 track5 track6 track11 track7 track8 track9 track10 track12 track19 track20\n");
        P.parse();
        //P.getHelper().getActionProcessor().commit();
        P = new CommandParser(help, "OPEN VIEW myview1 ORIGIN $r1 WORLD WIDTH 1000 SCREEN WIDTH 800 HEIGHT 600");
        P.parse();


    }

    @Test
    public void test2() {
        MyParserHelper help = new MyParserHelper(new ActionProcessor(new CommandLineInterface(new Controller())));

        CommandParser P = new CommandParser(help, "USE r1 AS REFERENCE 46*40'58\"/117*19'21\"");
        P.parse();
        P = new CommandParser(help, "CREATE TRACK BRIDGE\t\t\ttrack13\tREFERENCE $r1 DELTA START 50:0 END 80:0 ;" +
                "CREATE TRACK SWITCH TURNOUT track15 REFERENCE $r1 STRAIGHT DELTA START -50:0 END 0:0 CURVE DELTA START 0:0 END -20:20 DISTANCE ORIGIN 20 ;" +
                "CREATE TRACK SWITCH TURNOUT track16 REFERENCE $r1 STRAIGHT DELTA START -20:0 END -20:60 CURVE DELTA START -20:20 END -10:35 DISTANCE ORIGIN 15 ;" +
                "CREATE TRACK END\t\t\ttrack20\tREFERENCE $r1 DELTA START -10:35 END 40:62 ;" +
                "CREATE TRACK STRAIGHT\t\ttrack2 \tREFERENCE $r1 DELTA START 80:0 END 120:0 ;" +
                "CREATE TRACK BRIDGE DRAW\t\t\ttrack14\tREFERENCE $r1 DELTA START 120:0 END 150:0 ANGLE 45 ;" +
                "CREATE TRACK SWITCH TURNOUT \t\ttrack3\tREFERENCE $r1 STRAIGHT DELTA START 150:0 END 200:0 CURVE DELTA START 150:0 END 200:-30 DISTANCE ORIGIN 50 ;" +
                "CREATE TRACK STRAIGHT \t\ttrack4\tREFERENCE $r1 DELTA START 200:0 END 220:0 ;" +
                "CREATE TRACK STRAIGHT \t\ttrack5\tREFERENCE $r1 DELTA START 200:-30 END 220:-70 ;" +
                "CREATE TRACK CROSSING\t\ttrack6\tREFERENCE $r1 DELTA START 200:-30 END 220:-70 ;" +
                "CREATE TRACK STRAIGHT \t\ttrack11\tREFERENCE $r1 DELTA START 240:0 END 280:0 ;" +
                "CREATE TRACK BRIDGE \t\ttrack7\tREFERENCE $r1 DELTA START 220:-70 END 230:-90 ");
        P.parse();
        P.getHelper().getActionProcessor().schedule(new CommandStructuralCommit());
        P = new CommandParser(help, "OPEN VIEW myview1 ORIGIN $r1 WORLD WIDTH 1000 SCREEN WIDTH 800 HEIGHT 600");
        P.parse();
    }
}