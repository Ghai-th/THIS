package client;

import client.conf.IndexConf;
import client.frame.Index;

public class Main implements IndexConf {

    public static void main(String[] args) {
        Index.startApplication();
    }
}
