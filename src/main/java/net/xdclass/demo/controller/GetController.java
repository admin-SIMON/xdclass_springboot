package net.xdclass.demo.controller;

import net.xdclass.demo.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * HTTP协议的get请求
 * {@link RestController }注解为 @Controller 和 @ResponseBody 两个注解的结合
 */
@RestController
public class GetController {
    private Map<String, Object> params = new HashMap<>();

    /**
     * 功能描述：restful协议，从路径中获取字段
     *
     * @param city_id
     * @param userId
     * @return
     */
    @RequestMapping(path = "/{city_id}/{user_id}", method = RequestMethod.GET)
    public Object findUser(@PathVariable String city_id, @PathVariable("user_id") String userId) {
        params.clear();
        params.put("city_id", city_id);
        params.put("user_id", userId);
        return params;
    }

    /**
     * 功能描述：GetMapping注解get方式请求
     *
     * @param from
     * @param size
     * @return
     */
    @GetMapping(path = "/v1/page_user1")
    public Object pageUser(int from, int size) {
        params.clear();
        params.put("from", from);
        params.put("size", size);
        return params;
    }

    /**
     * 功能描述：默认值，是否必须的参数
     *
     * @param from
     * @param size
     * @return
     */
    @GetMapping(path = "/v2/page_user1")
    public Object pageUserV2(@RequestParam(defaultValue = "0", name = "page") int from, int size) {
        params.clear();
        params.put("from", from);
        params.put("size", size);
        return params;
    }

    /**
     * 功能描述：bean对象传参
     * 注意：
     * 1、需要指定HTTP头为 content-type为application/json
     * 2、使用body传输数据
     *
     * @param user
     * @return
     */
    @RequestMapping("/v1/save_user")
    public Object saveUser(User user) {
        params.clear();
        params.put("user", user);
        return params;
    }

    /**
     * 功能描述：获取HTTP头信息
     *
     * @param accessToken
     * @param id
     * @return
     */
    @RequestMapping("/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken, String id) {
        params.clear();
        params.put("access_token", accessToken);
        params.put("id", id);
        return params;
    }
}
