package net.samron.samloginsignupmvp.main;

/**
 * Created by samansadeghyan on 5/16/2017 AD.
 */

public interface MainContract {

    interface Presenter{

        void onTakeView(MainFragment mainFragment);

        void start();

        void checkUserLoginCredentials(String userName, String userPass);

        void checkUserSignupCredentials(String userName, String userPass);

        void goToLogin();

        void goToSignup();

    }


    interface View{

        void showProgress();

        void hideProgress();

        void showLogin();

        void hideLogin();

        void showSignup();

        void hideSignup();

        void showLoginSuccess();

        void showLoginFailure();

        void showSignupSuccess();

        void showSignupFailure();


    }


}