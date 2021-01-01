package frame.modle.panel;

import javax.swing.*;
import java.awt.*;

public class TranslucenceJTextArea extends JTextArea {
    private float transparency;

    public TranslucenceJTextArea(){

    }



    /**这个方法用来设置JPanel的透明度
     *
     * @param transparency:透明度
     *
     * @return void
     */
    public void setTransparent(float transparency) {
        this.transparency = transparency;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D graphics2d = (Graphics2D) g.create();

        graphics2d.setComposite(AlphaComposite.SrcOver.derive(transparency));


        graphics2d.setColor(getBackground());
        graphics2d.fillRect(0, 0, getWidth(), getHeight());

//			graphics2d.drawImage(background, 0, 0, getWidth(), getHeight(), 46, 114, 315, 521, this);

        graphics2d.dispose();
    }
}
