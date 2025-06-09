package org.demo.multiplatform.presentation.login

import org.demo.multiplatform.domain.model.Credentials

class LoginViewModel {
    fun onLoginClick() {
        // Any login function
    }

    fun checkCredentials(creds: Credentials) = creds.isNotEmpty() && creds.login == "admin"

}