package clintimpl;

import com.cxf.dubbo.entities.User;
import com.cxf.dubbo.service.UserService;

/**
 * Created by cxf on 2018/11/6.
 */
public class UserServiceStub implements UserService {

    //必须定义这个接口，以便接收dubbo在调用远程服务生成的服务代理类
    private UserService userLocalService ;

    //这个构造函数必须要提供，dubbo框架会在消费者这一方调用这个方法
    public UserServiceStub(UserService userLocalService ) {
        this.userLocalService = userLocalService  ;
    }
    @Override
    public User getUserById(Integer id) {
        User user = null;
        // 此代码在客户端执⾏, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
        try {
            if (id == 1) {
                user = this.userLocalService.getUserById(id);
            } else {
                user = new User();
                user.setName("系统用户");
            }
        }catch(Exception e){
            //容错处理
            user = new User();
            user.setName("异常用户");
        }
        return user;
    }
}
