package pl.edu.agh.tyche;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.auth0.android.Auth0;
import com.auth0.android.lock.AuthenticationCallback;
import com.auth0.android.lock.Lock;
import com.auth0.android.lock.LockCallback;
import com.auth0.android.lock.utils.LockException;
import com.auth0.android.result.Credentials;
import com.auth0.android.lock.*;

public class LockActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Auth0 auth0 = new Auth0(YOUR_CLIENT_ID, YOUR_AUTH0_DOMAIN);
        lock = Lock.newBuilder(auth0, callback)
                // Add parameters to the Lock Builder
                .build(this);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        // Your own Activity code
        lock.onDestroy(this);
        lock = null;
    }


    // lock czy auth0? przy auhentitation
    private LockCallback callback = new AuthenticationCallback()
    {
        @Override
        public void onAuthentication(Credentials credentials)
        {
            // Login Success response
        }

        @Override
        public void onCanceled()
        {
            // Login Cancelled response
        }

        @Override
        public void onError(LockException error)
        {
            // Login Error response
        }
    };

//    startActivity(lock.newIntent(this));



}
