package com.rightbuy.hackerkerneltask.utils

import android.util.Patterns
import android.widget.EditText
import java.util.regex.Pattern

object ValidationsUtils {

    val MOBILE_NUMBER_PATTERN =
        Pattern.compile("^[0-9]{10,14}$")

    /**
     * method for email validation
     */
    fun checkEmail(editText: EditText): Boolean {
        val text = editText.text.toString()
        return if (!text.isEmpty()) {
            if (Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
                true
            } else {
                editText.error = "Please enter valid Email"
                false
            }
        } else {
            editText.error = "Field Required"
            false
        }
    }

    /**
     * method for mobile_app number validation
     */
    fun checkMobile(mobile: String): Boolean {
        var mobile = mobile
        return try {
            mobile = mobile.replace("[^0-9]".toRegex(), "")
            if (MOBILE_NUMBER_PATTERN.matcher(mobile).matches()) true else false
        } catch (exception: Exception) {
            false
        }
    }

    // validating password with retype password
    fun isValidPassword(etpass: EditText): Boolean {
        val pass = etpass.text.toString()
        return if (!pass.isEmpty()) {
            if (pass != null && pass.length > 5) {
                true
            } else {
                etpass.error = "password length is too short"
                false
            }
        } else {
            etpass.error = "Field Required"
            false
        }
    }

    fun isValidEditTextInput(editText: EditText): Boolean {
        val text = editText.text.toString()
        if (text.isEmpty()) {
            editText.error = "Field Required"
            return false
        }
        return true
    }

}