package client.frame.modle.panel; /**
 *
 * @Author: hyacinth
 * @Title: MusicPlayer.java
 * @Package com.xu.test
 * @Description: TODO:
 * @Date: 2019年8月25日 下午10:40:47
 * @Version V-1.0
 * @Copyright: 2019 hyacinth
 *
 */

import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

/**
 * @Author: hyacinth
 * @ClassName: MusicPlayer
 * @Description: TODO
 * @Date: 2019年8月25日 下午10:40:47
 * @Copyright: hyacinth
 */
public class Lked {

    public static void main(String[] args) throws Exception {
        File file=new File("src/main/resources/祖海 - 好运来.mp3");
        FileInputStream stream=new FileInputStream(file);
        Player player=new Player(stream);
        player.play();
    }

}

