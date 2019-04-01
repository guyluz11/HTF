package com.htf.ui.main.fr.login;

import com.htf.util.TextUtils;

class ValidationResult {
    private String pwdMsg;
    private String emailMsg;

    void setPasswordValidation(String msg) {
        pwdMsg = msg;
    }

    void setEmailValidation(String msg) {
        emailMsg = msg;
    }

    boolean isInvalid() {
        return !TextUtils.isEmpty(pwdMsg) || !TextUtils.isEmpty(emailMsg);
    }

    String getEmailMsg() {
        return emailMsg;
    }

    String getPasswordMsg() {
        return pwdMsg;
    }
}
