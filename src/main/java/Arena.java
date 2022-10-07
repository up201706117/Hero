import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.swing.*;
import java.io.IOException;

public class Arena {
    private int width;
    private int height;

    public Arena( int width, int height){
        this.width =  width;
        this.height = height;
    }
    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#4e6263"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width,height), ' ');


    }
    public void processkey(KeyStroke key) throws IOException{
        System.out.println(key);

    }
    public int getWidth() {
        return width;
    }
    public  int getHeight(){return height; }
}
