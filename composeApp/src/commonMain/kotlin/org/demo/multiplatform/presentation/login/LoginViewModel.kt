package org.demo.multiplatform.presentation.login

import org.demo.multiplatform.domain.model.Credentials

/**
 * ViewModel for the login screen.
 *
 * This class handles the logic for the login screen, including handling user input and validating credentials.
 */
class LoginViewModel {
    fun onLoginClick() {
        // Any login function
    }

    /**
     * Checks if the provided credentials are valid.
     *
     * This function currently implements a simplified check where:
     * 1. The credentials must not be empty (both login and password fields must have values).
     * 2. The login field must be exactly "admin".
     *
     * @param creds The [Credentials] object containing the login and password to check.
     * @return `true` if the credentials are valid according to the current rules, `false` otherwise.
     */
    fun checkCredentials(creds: Credentials) = creds.isNotEmpty() && creds.login == "admin"

}