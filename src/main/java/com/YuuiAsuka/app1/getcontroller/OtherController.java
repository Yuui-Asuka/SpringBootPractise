package com.YuuiAsuka.app1.getcontroller;

import com.YuuiAsuka.app1.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OtherController {
    private Map<String, Object> params = new HashMap<>();

    //测试postMapping
    //@params accessToken
    //@params id
    //return
    @PostMapping("/v1/login")
    public Object login(String id, String pwd){
        params.clear();
        params.put("id", id);
        params.put("pwd", pwd);
        return params;
    }
    @PutMapping("/v1/put")
    public Object put(String id){
        params.clear();
        params.put("id", id);
        return params;
    }


}
