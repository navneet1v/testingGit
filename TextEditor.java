import java.applet.Applet;
import java.awt.*;

public class TextEditor extends Applet {
    
    private TextArea area;
    
    public void init(){
        this.setSize(400, 200);
        this.setBackground(Color.gray);
        
        area = new TextArea("hello");        
        add(area);
        area.setBounds(20, 20, 300, 300);
    }
    
    public void paint(Graphics g){
    }
}
