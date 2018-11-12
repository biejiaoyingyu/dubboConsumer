package entities;

import com.cxf.dubbo.entities.Book;
import intf.Notify;

/**
 * Created by cxf on 2018/11/5.
 */

/**
 * 回调函数
 */
public class NotifyImpl implements Notify {

    @Override
    public void onreturn(Book book,Integer id) {
        System.out.println("onreturn:" +id+"==============>" +book);
    }

    @Override
    public void onthrow(Throwable ex, Integer id) {
        System.out.println("onthrow:" + ex);
    }

    @Override
    public void oninvoke(Integer id) {
        System.out.println(id + "被调用");
    }

}
