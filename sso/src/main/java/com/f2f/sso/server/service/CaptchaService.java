package com.f2f.sso.server.service;



import com.f2f.sso.server.config.CachesEnum;

public interface CaptchaService {
    boolean saveCaptcha(CachesEnum cachesEnum, String key, Object value);

    String getCaptcha(CachesEnum cachesEnum, String key);

    void removeCaptcha(CachesEnum cachesEnum, String key);

    boolean checkCaptchaTimes(CachesEnum cachesEnum, String key);
}
