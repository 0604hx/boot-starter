package org.nerve.boot.web.auth;
import jakarta.annotation.PostConstruct;
import org.nerve.boot.domain.AuthUser;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class UserLoaderImpl implements UserLoader {
    @Override
    public AuthUser from(String ua) throws Exception {
        if(ua == null)
            return null;
        String[] tmp = ua.split("-", 3);

        AuthUser user = new AuthUser();
        String name = URLDecoder.decode(tmp[1], StandardCharsets.UTF_8.name());
        user.setId(tmp[0]).setName(name).setIp(tmp[2]);

        return user;
    }
}
