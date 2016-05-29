package taotao.mvp_demo.view;

import taotao.mvp_demo.bean.User;

/**
 * Created by taotao on 16-5-12.
 */
public interface IUserLoginView {

    String getUserName();
    String getPassword();

    void clearUserName();
    void clearPassword();

    void showLoading();
    void hideLoading();

    void toMainActivity(User user);
    void showFailedError();
}
