package com.ezra.firebase

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            firebaseUI(LocalContext.current)

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun firebaseUI(context: Context) {

    // on below line creating variable for course name,
    // course duration and course description.
    val DID = remember {
        mutableStateOf("")
    }

    val LastName = remember {
        mutableStateOf("")
    }

    val PhoneNumber = rememberSaveable {
        mutableStateOf("")
    }
    val EmailAddress = remember {
        mutableStateOf("")
    }
    val County = remember {
        mutableStateOf("")
    }
    val School = remember {
        mutableStateOf("")
    }
    val Level = remember {
        mutableStateOf("")
    }


    // on below line creating a column
    // to display our retrieved image view.
    var dID by remember { mutableStateOf(TextFieldValue("")) }
    var lastName by remember { mutableStateOf(TextFieldValue("")) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
    var emailAddress by remember { mutableStateOf(TextFieldValue("")) }
    var county by remember { mutableStateOf(TextFieldValue("")) }
    var school by remember { mutableStateOf(TextFieldValue("")) }
    var level by remember { mutableStateOf(TextFieldValue("")) }

    val goto = LocalContext.current


    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.LightGray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.prof), contentDescription = null,
                Modifier
                    .size(100.dp)
                    .padding(10.dp)
                    .clip(
                        CircleShape
                    )
            )
            Spacer(modifier = Modifier.width(40.dp))
            Column {
                Text(text = "ICT CLUB APP", fontSize = 40.sp)
                Text(text = "Register and meet other I.C.T members across the world.")
            }

        }
        LazyColumn() {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Image(
                            painter = painterResource(R.drawable.prof), contentDescription = null,
                            Modifier
                                .size(100.dp)
                                .clip(
                                    CircleShape
                                )
                        )
                        Text(text = "REGISTER", fontSize = 40.sp)


                        TextField(
                            value = dID,
                            onValueChange = {
                                dID = it
                            },
                            label = { Text(text = "Details ID") },
                            placeholder = { Text(text = "DetailsID") },
                        )

                        TextField(
                            value = lastName,
                            onValueChange = {
                                lastName = it
                            },
                            label = { Text(text = "Last Name") },
                            placeholder = { Text(text = "Last Name") },
                        )

                        TextField(
                            value = phoneNumber,
                            onValueChange = {
                                phoneNumber = it
                            },
                            label = { Text(text = "Phone Number") },
                            placeholder = { Text(text = "Phone Number") },
                        )
                        TextField(
                            value = emailAddress,
                            onValueChange = {
                                emailAddress = it
                            },
                            label = { Text(text = "Email Address") },
                            placeholder = { Text(text = "Email Address") },
                        )
                        TextField(
                            value = county,
                            onValueChange = {
                                county = it
                            },
                            label = { Text(text = "County") },
                            placeholder = { Text(text = "Ccounty") },
                        )
                        TextField(
                            value = school,
                            onValueChange = {
                                school = it
                            },
                            label = { Text(text = "School") },
                            placeholder = { Text(text = "School") },
                        )
                        TextField(
                            value = level,
                            onValueChange = {
                                level = it
                            },
                            label = { Text(text = "Level") },
                            placeholder = { Text(text = "Level") },
                        )
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(30.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(

                            onClick = {

                                if (TextUtils.isEmpty(DID.value.toString())) {

                                    Toast.makeText(
                                        context,
                                        "Please Enter Your dID",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                } else if (TextUtils.isEmpty(LastName.value.toString())) {

                                    Toast.makeText(
                                        context,
                                        "Please Enter Your Last Name",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                } else if (TextUtils.isEmpty(PhoneNumber.value.toString())) {

                                    Toast.makeText(
                                        context,
                                        "Please Enter Your Phone Number",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                } else if (TextUtils.isEmpty(EmailAddress.value.toString())) {

                                    Toast.makeText(
                                        context,
                                        "Please Enter Your Email Address",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                } else if (TextUtils.isEmpty(County.value.toString())) {

                                    Toast.makeText(
                                        context,
                                        "Please Enter Your County Name",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                } else if (TextUtils.isEmpty(School.value.toString())) {

                                    Toast.makeText(
                                        context,
                                        "Please Enter School",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                } else if (TextUtils.isEmpty(Level.value.toString())) {

                                    Toast.makeText(
                                        context,
                                        "Please Enter Your Level Of Education",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                } else {

                                    // on below line adding data to
                                    // firebase firestore database.
                                    addDataToFirebase(
                                        DID.value,
                                        LastName.value,
                                        PhoneNumber.value,
                                        EmailAddress.value,
                                        County.value,
                                        School.value,
                                        Level.value,
                                        context
                                    )
                                }
                            },
                            // on below line we are
                            // adding modifier to our button.
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(text = "Register", modifier = Modifier.padding(8.dp))
                        }

                        Spacer(modifier = Modifier.width(30.dp))
                        Column {
                            Text(text = "Already have an account?", fontSize = 15.sp)


                        }


                    }

                }
            }
        }

    }
}




    fun addDataToFirebase(
        dID: String,
        lastName: String,
        phoneNumber: String,
        emailAddress:String,
        county: String,
        school: String,
        level: String,
        context: Context) {
        // on below line creating an instance of firebase firestore.
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()

        //creating a collection reference for our Firebase Firestore database.
        val dbIctClub: CollectionReference = db.collection("details")

        //adding our data to our courses object class.
        val Details = Details(dID,lastName,phoneNumber,emailAddress,county,school,level)

        //below method is use to add data to Firebase Firestore.
        dbIctClub.add(Details).addOnSuccessListener {
            // after the data addition is successful
            // we are displaying a success toast message.
            Toast.makeText(
                context,
                "Data added successfully!",
                Toast.LENGTH_SHORT
            ).show()

        }.addOnFailureListener {
            // this method is called when the data addition process is failed.
            // displaying a toast message when data addition is failed.
            Toast.makeText(context, "Fail to add course", Toast.LENGTH_SHORT).show()
        }

    }









