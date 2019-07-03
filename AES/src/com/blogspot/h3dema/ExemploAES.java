/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.h3dema;

/**
 * vamos ver como utilizar java.security para criar um texto encriptado 
 * e para desencriptar utilizando AES
 * 
 * @author programador
 */
public class ExemploAES {
    
    public static void main(String[] args) throws Exception {
        
        String chave = "140b41b22a29beb4061bda66b6747e14";
        String iv = "1234567890123456";
        
        MyAES aes = new MyAES(chave, iv);
        
        // texto que vamos encriptar
        String texto = "aqui colocaremos o texto criptografado AES";//"Em Criptografia, o Advanced Encryption Standard (AES, ou Padrão de Criptografia Avançada, em português), também conhecido por Rijndael, é uma cifra de bloco adotada como padrão de criptografia pelo governo dos Estados Unidos. Espera-se que seja utilizado em todo o mundo e analisada extensivamente, assim como foi seu predecessor, o Data Encryption Standard (DES). O AES foi anunciado pelo NIST (Instituto Nacional de Padrões e Tecnologia dos EUA) como U.S. FIPS PUB (FIPS 197) em 26 de Novembro de 2001, depois de 5 anos de um processo de padronização. Tornou-se um padrão efetivo em 26 de Maio de 2002. Em 2006, o AES já é um dos algoritmos mais populares usados para criptografia de chave simétrica";
        String textoAEncriptar = Conversoes.converteByteArrayToHexString(Conversoes.converteAsciiParaArray(texto,true));
        // chave de criptografia
        System.out.println("Texto original:");
        System.out.println(texto);
        System.out.println("Texto (hexa):"+textoAEncriptar);
        String textoEncriptado = aes.encriptar(textoAEncriptar);
        System.out.println("Cipher:"+textoEncriptado);
        
        String textoDesencriptado = aes.desencriptar(textoEncriptado);
        System.out.println("Mensagem:"+textoDesencriptado);
        
        
    }
}
