package net.samron.samloginsignupmvp.main;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.samron.samloginsignupmvp.R;


/**
 * Created by samansadeghyan on 5/16/2017 AD.
 */

public class MainFragment extends Fragment implements MainContract.View {


    private MainPresenter presenter;

    private TextView textViewHeader;
    private EditText userNameIn;
    private EditText userPassIn;
    private Button actionNowBtn;
    private Button goToBtn;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }



    @Override
    public void onResume() {
        super.onResume();
        if (presenter==null) {
            Log.e("presenter","is null!");
            presenter = new MainPresenter(getContext());
            presenter.onTakeView(this);
        }
        presenter.start();
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
        } catch (ClassCastException e) {
            throw new ClassCastException( context.toString() + " must implement onSomeEventListener");
        }



    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.main_fragment, container, false);

        Log.e("onCreateView","onCreateView");

        textViewHeader = (TextView) view.findViewById(R.id.textview_header);
        userNameIn = (EditText) view.findViewById(R.id.username_in);
        userPassIn = (EditText) view.findViewById(R.id.userpass_in);
        actionNowBtn = (Button) view.findViewById(R.id.action_now_btn);
        goToBtn = (Button) view.findViewById(R.id.go_to_btn);



        return view;
    }







    ///////////////////////////////////////////////
    @Override
    public void showProgress() {
        Log.e("show","showProgress");

    }

    @Override
    public void hideProgress() {
        Log.e("hide","hideProgress");

    }

    @Override
    public void showLogin() {
        Log.e("show","showLogin");
        textViewHeader.setText("please login now :");
        actionNowBtn.setText("Login now");
        goToBtn.setText("Go to Register");
        setListenerForActionNowBtn(0);
        setListenerForGoToBtn(1);


    }

    @Override
    public void hideLogin() {
        Log.e("hide","hideLogin");

    }

    @Override
    public void showSignup() {
        Log.e("show","showSignup");
        textViewHeader.setText("please register now :");
        actionNowBtn.setText("Register now");
        goToBtn.setText("Go to Login");
        setListenerForActionNowBtn(1);
        setListenerForGoToBtn(0);

    }

    @Override
    public void hideSignup() {
        Log.e("hide","hideSignup");

    }

    @Override
    public void showLoginSuccess() {
        Toast.makeText(getContext().getApplicationContext(), "Login : success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoginFailure() {
        Toast.makeText(getContext().getApplicationContext(), "Login : failure", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSignupSuccess() {
        Toast.makeText(getContext().getApplicationContext(), "signup : success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSignupFailure() {
        Toast.makeText(getContext().getApplicationContext(), "signup : failure", Toast.LENGTH_LONG).show();
    }







    public void setListenerForActionNowBtn(final int what){
        actionNowBtn.setOnClickListener(null);
        Log.e("ListeForActionNow :: ","what = "+ Integer.toString(what));


        if (what == 0){ // login

            actionNowBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.e("ListeForActionNow :: ","go = login");
                    String userName = userNameIn.getText().toString();
                    String userPass = userPassIn.getText().toString();

                    presenter.checkUserLoginCredentials(userName, userPass);

                }

            });

        }else if (what == 1) { // signup

            actionNowBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.e("ListeForActionNow :: ","go = signup");
                    String userName = userNameIn.getText().toString();
                    String userPass = userPassIn.getText().toString();

                    presenter.checkUserSignupCredentials(userName, userPass);

                }

            });



        }




    }


    public void setListenerForGoToBtn(final int what){
        goToBtn.setOnClickListener(null);
        Log.e("ListeForGoTo :: ","what = "+ Integer.toString(what));

        if (what == 0){ // login

            goToBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.e("ListeForGoTo :: ","go = login");
                    presenter.goToLogin();

                }
            });



        }else if (what == 1) { // signup

            goToBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.e("ListeForGoTo :: ","go = signup");
                    presenter.goToSignup();

                }
            });

        }




    }








}
