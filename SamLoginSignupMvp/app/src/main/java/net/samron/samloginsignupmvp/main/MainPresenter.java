package net.samron.samloginsignupmvp.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by samansadeghyan on 5/16/2017 AD.
 */

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;

    private int STATE;
    private final int PROGRESS = 0;
    private final int LOGIN = 1;
    private final int SIGNUP = 2;

    private SharedPreferences mSharedPreferences;

    public MainPresenter(Context context){
        mSharedPreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE);
    }

    @Override
    public void onTakeView(MainFragment mainFragment) {
        view = mainFragment;
        STATE = LOGIN;
    }

    @Override
    public void start() {
        Log.e("presenter starts iiiiin", STATE +":");

        switch (STATE){
            case PROGRESS:
                view.showProgress();
//                view.hideStuff();
//                view.hideNoConnect();

                break;

            case LOGIN:
                view.hideProgress();
                view.showLogin();
                break;

            case SIGNUP:
                view.hideProgress();
                view.showSignup();
                break;
        }

    }

    @Override
    public void checkUserLoginCredentials(String userName, String userPass) {
        this.STATE = PROGRESS;

        if (userName.equals("") || userPass.equals("")){
            view.showLoginFailure();
        }else {
//            if (userName.equals("saman") && userPass.equals("123")){
//                view.showLoginSuccess();
//            }
            String user = mSharedPreferences.getString("userName", "");
            String pass = mSharedPreferences.getString("userPass", "");

            if (userName.equals(user) && userPass.equals(pass)){
                view.showLoginSuccess();
            }else {
                view.showLoginFailure();
            }

        }
    }

    @Override
    public void checkUserSignupCredentials(String userName, String userPass) {
        Log.e("hellooo", "hellooo");
        this.STATE = PROGRESS;

        if (userName.equals("") || userPass.equals("")){
            view.showSignupFailure();
        }else {
            SharedPreferences.Editor editor = mSharedPreferences.edit();
            editor.putString("userName", userName);
            editor.putString("userPass", userPass);

            editor.commit();

            view.showSignupSuccess();

        }
    }

    @Override
    public void goToLogin() {
        this.STATE = LOGIN;
        view.hideProgress();
        view.showLogin();
    }

    @Override
    public void goToSignup() {
        this.STATE = SIGNUP;
        view.hideProgress();
        view.showSignup();
    }


}
