package org.cedacri.spring.cedintlibra.utils;

import org.jspecify.annotations.Nullable;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public final class PasswordUtil implements PasswordEncoder {
    @Override
    public String encode(@Nullable CharSequence rawPassword) {
        return BCrypt.hashpw(String.valueOf(rawPassword), BCrypt.gensalt(5));
    }

    @Override
    public boolean matches(@Nullable CharSequence rawPassword, @Nullable String encodedPassword) {
        return BCrypt.checkpw((String) rawPassword, encodedPassword);
    }

//    public static String hash(String password){
//     return BCrypt.hashpw(password, BCrypt.gensalt(5));
// }
//
// public static boolean verify(String password, String hash){
//     return BCrypt.checkpw(password, hash);
// }
}
