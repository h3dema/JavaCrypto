/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.h3dema;

/**
 *
 * @author programador
 */
public class Conversoes {
    
    // precisamos criar uma forma de convertar uma string com hexa
    // para um array de bytes
    public static byte[] converteHexStringToByteArray(String s) {
        int tamanho = s.length() / 2; // tamanho do array de bytes, considerando que cada 2 caracteres da string representam um byte em hexa
        byte[] array = new byte[tamanho];
        for(int i=0; i<tamanho; i++){
            String chr = s.substring(i*2, i*2+2); // para podermos pegar de 2 em 2 caracteres
            Integer valor = Integer.parseInt(chr, 16);
            array[i] = valor.byteValue(); // coloca o byte convertido
        }
        return array;
    }

    public static String converteByteArrayToHexString(byte[] a) {
        char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuffer buf = new StringBuffer();
        for (int j = 0; j < a.length; j++) {
            buf.append(hexDigit[(a[j] >> 4) & 0x0f]);
            buf.append(hexDigit[a[j] & 0x0f]);
        }
        return buf.toString();
    }
    
    /*
     * os blocos a serem encriptados precisam ser multiplos de 16
     * acrescentamos um pad que contem o número de caracteres que foram inseridos
     * para garantir que não teremos problemas, temos que colocar 16 se a string
     * for multipla de 16
     */
    public static byte[] converteAsciiParaArray(String s, boolean padding) {
        int tamanho;
        if (padding) {
            // quanto vai sobrar
            tamanho = s.length() % 16;
            if (tamanho == 0) {tamanho = 16;}
        } else {
            tamanho = 0; // sem padding
        }
            
        byte[] array = new byte[s.length()+tamanho];
        for(int i=0; i < s.length(); i++) {
          array[i] = (byte) s.charAt(i);
        }
        byte pad = (byte) (tamanho);
        for(int i=s.length(); i < s.length()+tamanho; i++) {
            array[i] = pad;
        }
        
        return array;
    }
        
}
