package rmiclient;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;
import java.util.Scanner;
import rmii.RMII;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hubert
 */
public class RMIClient {

    public static void main(String args[]) {
        RMIClient client = new RMIClient();
        client.connectServer();
    }

    private void connectServer() {
        try {
            Registry reg = LocateRegistry.getRegistry("192.168.0.100", 5099);
            RMII rmi = (RMII) reg.lookup("server");
            System.out.println("Connected to server");

            String tmp = "", tmp1 = "", tmp2 = "";
            int ilosc = 3;
            Scanner odczyt = new Scanner(System.in);
            System.out.println("Podaj ilosc: ");
            tmp2 = odczyt.nextLine();

            try {
                ilosc = Integer.parseInt(tmp2);
            } catch (Exception e) {
                System.out.println("Podano niepoprawne dane!!!");

            }
            String[] tab = new String[ilosc];
            System.out.println("Podaj wysokość rolet: ");
            tmp1 = odczyt.nextLine();
            for (int i = 0; i < ilosc; i++) {
                System.out.println("Podaj szerokość: ");
                tmp = odczyt.nextLine();
                tab[i] = tmp;

            }
            String p;
            System.out.println(rmi.obliczenia(rmi.zapisDanych(ilosc, tab, tmp1)));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
