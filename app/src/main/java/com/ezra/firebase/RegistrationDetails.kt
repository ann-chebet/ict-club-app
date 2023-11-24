package com.ezra.firebase

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore

class RegistrationDetails : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            firebaseUI(
                LocalContext.current,
                intent.getStringExtra("dID"),
                intent.getStringExtra("LastName"),
                intent.getStringExtra("PhoneNumber"),
                intent.getStringExtra("EmailAddress"),
                intent.getStringExtra("County"),
                intent.getStringExtra("School"),
                intent.getStringExtra("Level")
            )

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun firebaseUI(
        context: Context,
       dID: String?,
        lastname: String?,
        phonenumber: String?,
        emailaddress: String?,
        county: String?,
        school: String?,
        level: String?
    ) {

        // on below line creating variable for course name,
        // course duration and course description.
        val dID = remember {
            mutableStateOf(dID)
        }

        val lastname = remember {
            mutableStateOf(lastname)
        }

        val phonenumber = remember {
            mutableStateOf(phonenumber)
        }
        val emailaddress = remember {
            mutableStateOf(emailaddress)
        }
        val county = remember {
            mutableStateOf(county)
        }
        val school= remember {
            mutableStateOf(school)
        }
        val level = remember {
            mutableStateOf(level)
        }

        // on below line creating a column
        Column(
            // adding modifier for our column
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.White),
            // on below line adding vertical and
            // horizontal alignment for column.
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            TextField(
                // on below line we are specifying
                // value for our course name text field.
                value = dID.value.toString(),

                // on below line we are adding on
                // value change for text field.
                onValueChange = { dID.value = it },

                // on below line we are adding place holder
                // as text as "Enter your course name"
                placeholder = { Text(text = "Enter Your First Name") },

                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

                // on below line we are adding
                // single line to it.
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                // on below line we are specifying
                // value for our course duration text field.
                value = lastname.value.toString(),

                // on below line we are adding on
                // value change for text field.
                onValueChange = { lastname.value = it },

                // on below line we are adding place holder
                // as text as "Enter your course duration"
                placeholder = { Text(text = "Enter Your Last Name") },

                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

                // on below line we are adding
                // single line to it.
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                // on below line we are specifying
                // value for our course description text field.
                value = phonenumber.value.toString(),

                // on below line we are adding on
                // value change for text field.
                onValueChange = { phonenumber.value = it },

                // on below line we are adding place holder
                // as text as "Enter your course description"
                placeholder = { Text(text = "Enter Your Phone Number") },

                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

                // on below line we are adding
                // single line to it.
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                // on below line we are specifying
                // value for our course description text field.
                value = emailaddress.value.toString(),

                // on below line we are adding on
                // value change for text field.
                onValueChange = { emailaddress.value = it },

                // on below line we are adding place holder
                // as text as "Enter your course description"
                placeholder = { Text(text = "Enter Your Email Address") },

                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

                // on below line we are adding
                // single line to it.
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))


            TextField(
                // on below line we are specifying
                // value for our course description text field.
                value = county.value.toString(),

                // on below line we are adding on
                // value change for text field.
                onValueChange = { county.value = it },

                // on below line we are adding place holder
                // as text as "Enter your course description"
                placeholder = { Text(text = "Enter Your County") },

                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

                // on below line we are adding
                // single line to it.
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))


            TextField(
                // on below line we are specifying
                // value for our course description text field.
                value = school.value.toString(),

                // on below line we are adding on
                // value change for text field.
                onValueChange = { school.value = it },

                // on below line we are adding place holder
                // as text as "Enter your course description"
                placeholder = { Text(text = "Enter Your School") },

                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

                // on below line we are adding
                // single line to it.
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))


            TextField(
                // on below line we are specifying
                // value for our course description text field.
                value = level.value.toString(),

                // on below line we are adding on
                // value change for text field.
                onValueChange = {level.value = it },

                // on below line we are adding place holder
                // as text as "Enter your course description"
                placeholder = { Text(text = "Enter Your level of Education") },

                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

                // on below line we are adding
                // single line to it.
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))




            // on below line creating button to add data
            // to firebase firestore database.
            Button(
                onClick = {
                    // on below line we are validating user input parameters.
                    if (TextUtils.isEmpty(dID.value.toString())) {
                        Toast.makeText(context, "Please enter first name", Toast.LENGTH_SHORT)
                            .show()
                    } else if (TextUtils.isEmpty(lastname.value.toString())) {
                        Toast.makeText(
                            context,
                            "Please enter last name",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (TextUtils.isEmpty(phonenumber.value.toString())) {
                        Toast.makeText(
                            context,
                            "Please enter phone number",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (TextUtils.isEmpty(emailaddress.value.toString())) {
                        Toast.makeText(
                            context,
                            "Please enter email address",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }else if (TextUtils.isEmpty(county.value.toString())) {
                        Toast.makeText(
                            context,
                            "Please enter county name",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }else if (TextUtils.isEmpty(school.value.toString())) {
                        Toast.makeText(
                            context,
                            "Please enter school name",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }else if (TextUtils.isEmpty(level.value.toString())) {
                        Toast.makeText(
                            context,
                            "Please enter level of education",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }

                    else {
                        // on below line adding data to
                        // firebase firestore database.
                        updateDataToFirebase(
                           dID.value,
                            lastname.value,
                           phonenumber.value,
                           emailaddress.value,
                            county.value,
                            school.value,
                            level.value,
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
                // on below line we are adding text for our button
                Text(text = "Update Data", modifier = Modifier.padding(8.dp))
            }

            Spacer(modifier = Modifier.height(10.dp))

            // on below line creating button to delete the course.
            Button(
                onClick = {
                    // on below line calling delete course
                    // method to delete our course.
                    deleteDataFromFirebase(dID.value, context)
                },
                // on below line we are
                // adding modifier to our button.
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // on below line we are adding text for our button
                Text(text = "Delete Course", modifier = Modifier.padding(8.dp))
            }
        }
    }

    private fun deleteDataFromFirebase(firstname: String?, context: Context) {

        // getting our instance from Firebase Firestore.
        val db = FirebaseFirestore.getInstance();

        // below line is for getting the collection
        // where we are storing our courses.
        db.collection("RegistrationDetails").document(firstname.toString()).delete().addOnSuccessListener {
            // displaying toast message when our course is deleted.
            Toast.makeText(context, " Deleted successfully..", Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, CoursesActivity::class.java))
        }.addOnFailureListener {
            // on below line displaying toast message when
            // we are not able to delete the course
            Toast.makeText(context, "Fail to delete...", Toast.LENGTH_SHORT).show()
        }

    }


    private fun updateDataToFirebase(
        dID: String?,
        lastname: String?,
        phonenumber: String?,
        emailaddress: String?,
        county: String?,
        school: String?,
        level: String?,
        context: Context
    ) {
        // inside this method we are passing our updated values
        // inside our object class and later on we
        // will pass our whole object tofirebase Firestore.
        val Details = Details(dID,lastname,phonenumber,emailaddress,county,school,level)

        // getting our instance from Firebase Firestore.
        val db = FirebaseFirestore.getInstance();
        db.collection("Details").document(dID.toString()).set(Details)
            .addOnSuccessListener {
                // on below line displaying toast message and opening
                // new activity to view courses.
                Toast.makeText(context, "Details Updated successfully..", Toast.LENGTH_SHORT).show()
                context.startActivity(Intent(context, CoursesActivity::class.java))
                finish()

            }.addOnFailureListener {
                Toast.makeText(context, "Fail to update details : " + it.message, Toast.LENGTH_SHORT)
                    .show()
            }
    }
}
