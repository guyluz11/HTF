package com.htf.ui.Fragments.login;

import com.htf.util.TextUtils;

class ValidationResult {
    private String pwdMsg;
    private String emailMsg;
    private String nameMsg;

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

    void setFullNameValidation(String msg) {
        nameMsg = msg;
    }

    String getNameMsg() {
        return nameMsg;
    }
}
