package client.frame.modle.panel;

import java.io.IOException;

public class Lked {

    public static void main(String []args){
        Runtime runt=Runtime.getRuntime();
        Process p=null;
        try {
            p=runt.exec("calc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
