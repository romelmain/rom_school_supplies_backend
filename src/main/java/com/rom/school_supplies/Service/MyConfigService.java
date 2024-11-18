package com.rom.school_supplies.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyConfigService {

    @Value("${user.message.notfound}")
    private String userMessageNotFound;

    public String getUserMessageNotFound() {
        return userMessageNotFound;
    }

}
