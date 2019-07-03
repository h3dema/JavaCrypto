/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.h3dema;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author programador
 */
public class MyAES {

    private final String ALGORITMO = "AES/CTR/NoPadding";
    
    private Key chaveAES;
    private IvParameterSpec ivps;
    
    public MyAES(String key, String iv) {
        byte[] ivArray = Conversoes.converteAsciiParaArray(iv, false);
        ivps = new IvParameterSpec(ivArray);
        
        chaveAES = gerarChaveAES(key);
    }    
    
    // primeira coisa: precisamos gerar a chave 
    // java.security.Key
    public static Key gerarChaveAES(String key) {
        byte[] keyArray = Conversoes.converteHexStringToByteArray(key); //
        return new SecretKeySpec(keyArray, "AES");
    }
    
    /*
     * @param texto String em formato hexadecimal do texto a encriptar
     */
    public String encriptar(String texto) throws Exception {        
        Cipher c = Cipher.getInstance(ALGORITMO); // vamos precisar da mesma string para decriptar
        c.init(Cipher.ENCRYPT_MODE, chaveAES, ivps);
        byte[] textoArray = Conversoes.converteHexStringToByteArray(texto);
        byte [] msg = c.doFinal(textoArray);
        return Conversoes.converteByteArrayToHexString(msg);
    }
    
    /* aqui vamos fazer nossa rotina
     * @param textoCifrado String em formato hexadecimal do texto encriptado
     */
    public String desencriptar(String textoCifrado) throws Exception {
        Cipher c = Cipher.getInstance(ALGORITMO); // vamos precisar da mesma string para decriptar
        c.init(Cipher.DECRYPT_MODE, chaveAES, ivps);
        byte[] textoArray = Conversoes.converteHexStringToByteArray(textoCifrado);
        byte [] msg = c.doFinal(textoArray);
        return Conversoes.converteByteArrayToHexString(msg);
    }
    
    
}
