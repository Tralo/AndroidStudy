package taotao.mvp_demo.presenter;

import android.os.Handler;

import taotao.mvp_demo.bean.User;
import taotao.mvp_demo.biz.IUserBiz;
import taotao.mvp_demo.biz.OnLoginListener;
import taotao.mvp_demo.biz.UserBiz;
import taotao.mvp_demo.view.IUserLoginView;

/**
 * Created by taotao on 16-5-12.
 */
public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();


    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login(){
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear(){
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
