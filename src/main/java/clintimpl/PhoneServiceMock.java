package clintimpl;

import com.cxf.dubbo.entities.Phone;
import com.cxf.dubbo.service.PhoneService;

/**
 * Created by cxf on 2018/11/6.
 */
public class PhoneServiceMock implements PhoneService{
    @Override
    public Phone getPhoneById(Integer id) {
        System.out.println("===============>"+id);
        return  new Phone("huawei",2000);
    }
}
