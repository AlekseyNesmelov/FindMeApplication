package com.nesmelovalexey.authlib.data

/**
 * Exception that throws if registration was not completed, because user is already exist.
 *
 * @author Alexey Nesmelov
 */
class UserAlreadyExistsException : Exception()

/**
 * Exception that throws if registration was not completed, because of network error
 *
 * @author Alexey Nesmelov
 */
class NetworkException : Exception()

/**
 * Exception that throws if registration was not completed, because of some unknown error
 *
 * @author Alexey Nesmelov
 */
class UnknownException : Exception()

