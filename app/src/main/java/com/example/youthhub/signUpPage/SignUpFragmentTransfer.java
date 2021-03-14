package com.example.youthhub.signUpPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Ragul Raj on 2/8/2019.
 */

public interface SignUpFragmentTransfer {
    void fragmentTransferListener(Fragment fragment, int loadNumber, Bundle bundle);
}
