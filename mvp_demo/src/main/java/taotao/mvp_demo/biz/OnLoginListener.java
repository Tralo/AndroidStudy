package taotao.mvp_demo.biz;

import taotao.mvp_demo.bean.User;

/**
 * Created by taotao on 16-5-12.
 */
public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
