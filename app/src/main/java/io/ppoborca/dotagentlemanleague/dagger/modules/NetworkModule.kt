package io.ppoborca.dotagentlemanleague.dagger.modules

import com.firebase.client.DataSnapshot
import com.firebase.client.Firebase
import com.firebase.client.FirebaseError
import com.firebase.client.ValueEventListener

public object NetworkModule {


    public fun trial() {
        val myFirebase = Firebase("https://io.ppoborca.dml.firebaseio.com/users")

        myFirebase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

            }

            override fun onCancelled(firebaseError: FirebaseError) {

            }
        })
    }
}
