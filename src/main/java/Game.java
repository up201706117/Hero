import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;

    public Game() throws IOException {
        arena =  new Arena (70, 50);
        screen = generateTerminal();
        run();

    }
    public void draw() throws IOException {
        while (true){
            screen.clear();
            arena.draw(screen.newTextGraphics());
        }
        /*try{
            screen.refresh();
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }*/
    }
    private Screen generateTerminal() throws IOException{
        TerminalSize terminalSize = new TerminalSize(arena.getWidth(), arena.getHeight());
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    public void run() throws IOException {
        draw();

        /*while(true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyEventType() == KeyType.EOF) break;
        }*/
    }
   /* private void processKey(KeyStroke key) throws IOException {
        if (key.getKeyEventType() == KeyType.Character)
            if(key.getKeyChar() == 'q')
                screen.close();

        arena.processKey(key);
    }*/
}
