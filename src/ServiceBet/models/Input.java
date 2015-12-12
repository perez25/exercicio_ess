/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.models;


import java.io.IOException;
import static java.lang.System.out;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sérgio
 */
public class Input {
    Scanner reader;

    public Input() {
        reader = new Scanner(System.in);
    }
  
    public String lerString() {
        String r = reader.nextLine();
        return r;
    }

    public int readInt() {

        boolean sucesso = true;
        int res = 0;

        do {
            try {

                res = reader.nextInt();
                sucesso = true;

            } catch (InputMismatchException e) {
                System.err.println("ERRO: Introduza um dígito (" + e + ")");
                reader = new Scanner(System.in);
                sucesso = false;
            } catch (Exception e) {
                System.err.println(e.toString());
            }

        } while (!sucesso);
        reader.nextLine();
        return res;
    }

    public double readDouble() {
        boolean ok = false;
        double d = 0.0;
        while (!ok) {
            try {
                d = reader.nextDouble();
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Valor real Inválido");
                out.print("Novo valor: ");
                reader.nextLine();
            }
        }
        return d;
    }

    public float readFloat() {
        boolean ok = false;
        float f = 0.0f;
        while (!ok) {
            try {
                f = reader.nextFloat();
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Valor real Inválido");
                out.print("Novo valor: ");
                reader.nextLine();
            }
        }
        return f;
    }

    public  boolean readBoolean() {
        boolean ok = false;
        boolean b = false;
        while (!ok) {
            try {
                b = reader.nextBoolean();
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Booleano Inválido");
                out.print("Novo valor: ");
                reader.nextLine();
            }
        }
        return b;
    }

    public short readShort() {
        boolean ok = false;
        short s = 0;
        while (!ok) {
            try {
                s = reader.nextShort();
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Short Inválido");
                out.print("Novo valor: ");
                reader.nextLine();
            }
        }
        return s;
    }

    public  char readChar() throws IOException {
        char c = (char) System.in.read();
        return c;
    }

    public int readTwoIntegers(int a, int b) {

        int res;

        do {
            res = readInt();
        } while (!(res >= a && res <= b));

        return res;
    }
    
   
    
    
}

