package intf;

import com.cxf.dubbo.entities.Book;

/**
 * Created by cxf on 2018/11/5.
 */

public interface Notify {
   void onreturn(Book book, Integer id);
   void onthrow(Throwable ex, Integer id);
   void oninvoke(Integer id);
}
