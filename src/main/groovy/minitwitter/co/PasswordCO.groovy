package minitwitter.co

import grails.validation.Validateable

class PasswordCO implements Validateable{

    String currentPassword
    String newPassword
    String confirmPassword

    static constraints = {
        currentPassword nullable: false, blank: false
        newPassword nullable: false, blank: false
        confirmPassword validator: {val, obj ->
            val.equals(obj.newPassword)
        }
    }
}
