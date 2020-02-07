package com.YuuiAsuka.app1.getcontroller;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import com.YuuiAsuka.app1.domain.ServerSetting;

@RestController
public class GetController {
    private Map<String, Object> params = new HashMap<>();

    /**
     * @param cityId
     * @param userId
     * @return
     */

//    @RequestMapping(path = "/{city_id}/{user_id}", method = RequestMethod.GET)
//    public Object findUser(@PathVariable("city_id") String cityId,
//                           @PathVariable("user_id") String userId){
//        params.clear();
//        params.put("CityId", cityId);
//        params.put("UserId", userId);
//        return params;
//    }

    @GetMapping(value = "/v1/get_user1")
    public Object getUser(int from, int size)
    {
    params.clear();
    params.put("from", String.valueOf(from));
    params.put("size", String.valueOf(size));
    return params;
    }

    @GetMapping(value = "v2/get_user2")
    //把from重命名为page，默认值设为0
    public Object getUser2(@RequestParam(defaultValue = "0", name="page") int from, int size){
        params.clear();
        params.put("from", String.valueOf(from));
        params.put("size", String.valueOf(size));
        return params;
    }

    /* Bean对象传参
     *http的请求头的content-type为json或application
     * 使用body传输数据
     */
    @RequestMapping(value = "v1/save_user")
    public Object saveUser(@RequestBody User user){
        params.clear();
        params.put("user", user);
        return params;
    }

    /*获取http头信息,通过请求头来验证请求是否合法
    * @param accessToken
    * @param id
    * return
    */
    @GetMapping("v1/get_header")
    public Object getHeader(@RequestHeader("accessToken") String accessToken, String id){
     params.clear();
     params.put("accessToken", accessToken);
     params.put("id", id);
     return params;
    }

    @GetMapping("test/request")
    public Object testRequest(HttpServletRequest request){
        params.clear();
        String id = request.getParameter("id");
        System.out.println("Servlet请求处理中");
        params.put("id", id);
        return params;
    }

    @Autowired
    private ServerSetting serverSetting;

    @GetMapping("test/properties")
    public Object testProperties(){
        return serverSetting;
    }

    @GetMapping(value = "api/v1/login")
    public Object account(){
        params.clear();
        params.put("money", 1000);
        return params;
    }
    //拦截测试
    @GetMapping(value = "api2/v1/login")
    public Object interception(){
        params.clear();
        params.put("money", 1000);
        return params;
    }

}
