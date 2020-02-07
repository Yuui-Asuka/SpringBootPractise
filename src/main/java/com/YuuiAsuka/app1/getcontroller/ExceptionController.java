package com.YuuiAsuka.app1.getcontroller;

import com.YuuiAsuka.app1.domain.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @RequestMapping("api/v1/exc")
    public Object myExc(){
        throw new MyException("499", "error!");
    }
}
