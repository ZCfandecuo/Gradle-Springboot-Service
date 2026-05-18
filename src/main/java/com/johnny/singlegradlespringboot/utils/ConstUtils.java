package com.johnny.singlegradlespringboot.utils;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;


public class ConstUtils {
    public static final String PREFIX_LOGIN = "login_code:";

        //生成一个随机的AES密钥
        public static Key generateKey() throws Exception {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128); //指定密钥长度为128位
            return keyGenerator.generateKey();
        }
    public static int longestMountain(int[] arr) {
        if(arr.length<3) return 0;
        int left = 0, i = 1;
        int res = 0;
        while(i<arr.length){
            if(arr[i]>arr[i-1]){
                left++;
                i++;
            }
            else if(arr[i]==arr[i-1]){
                left = 0;
                i++;
            }else{
                if(left!=0){
                    int right = 1;
                    for(int j =i+1;j<arr.length;j++){
                        if(arr[j]<arr[j-1])
                            right++;
                        else{
                            break;
                        }
                    }
                    res = Math.max(left+right+1, res);
                    i+=right;
                    left=0;

                }else{
                    i++;
                }
            }
        }
        return res;
    }

    //生成一个随机的初始化向量
    public static byte[] generateIV() {
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[16]; //CFB模式下，IV长度必须等于分组长度，即16字节
        random.nextBytes(iv);
        return iv;
    }

    //使用AES/CFB/PKCS5Padding算法加密数据
    public static byte[] encrypt(byte[] data, Key key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        return cipher.doFinal(data);
    }

    //使用AES/CFB/PKCS5Padding算法解密数据
    public static byte[] decrypt(byte[] data, Key key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        return cipher.doFinal(data);
    }

    //将字节数组转换为Base32编码的字符串
    public static String encodeBase32(byte[] data) {
        return Base64.getUrlEncoder().encodeToString(data);
    }

    //将Base32编码的字符串转换为字节数组
    public static byte[] decodeBase32(String data) {
        return Base64.getUrlDecoder().decode(data);
    }

    public static void main(String[] args) throws Exception {
        //测试数据
        String originalString = "Hello, world!";
        System.out.println("original string: " + originalString);

        //生成密钥和初始化向量
        Key key = generateKey();
        byte[] iv = generateIV();

        System.gc();
        //加密数据
        byte[] encryptedData = encrypt(originalString.getBytes(), key, iv);
        String encryptedString = encodeBase32(encryptedData);
        System.out.println("encrypt string: " + encryptedString);

        //解密数据
        byte[] decryptedData = decrypt(decodeBase32(encryptedString), key, iv);
        String decryptedString = new String(decryptedData);
        System.out.println("decrypt string: " + decryptedString);
    }

}
