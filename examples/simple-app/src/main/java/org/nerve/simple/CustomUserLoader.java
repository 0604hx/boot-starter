package org.nerve.simple;

import org.nerve.boot.domain.AuthUser;
import org.nerve.boot.web.auth.UserLoader;
import org.springframework.stereotype.Component;

@Component
public class CustomUserLoader implements UserLoader {
    @Override
    public AuthUser from(String text) throws Exception {
        return null;
    }
}
