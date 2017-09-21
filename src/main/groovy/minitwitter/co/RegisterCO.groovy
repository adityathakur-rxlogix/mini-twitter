package minitwitter.co

import grails.validation.Validateable
import minitwitter.User

class RegisterCO implements Validateable{

    String fullName
    String email
    String password

}
