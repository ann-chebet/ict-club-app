package com.ezra.firebase
import com.google.firebase.firestore.Exclude
import java.time.Duration


// on below line creating
// a data class for course,
data class Details(
    // on below line creating variables.
    @Exclude var dID: String? = "",
    var lastName: String? = "",
    var phoneNumber: String? = "",
    var emailaddress: String? = "",
    var county: String? = "",
    var school: String? = "",
    var level: String? = ""
)


