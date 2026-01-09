package org.cedacri.spring.cedintlibra.utils;

import org.mindrot.jbcrypt.BCrypt;

public final class PasswordUtil {

    public static String hash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(5));
    }

    public static boolean verify(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }
}
