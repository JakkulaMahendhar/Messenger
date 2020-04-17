package com.example.kotlinpractice

import android.content.ContentResolver
import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ContactFetcher
import com.example.kotlinpractice.Adapter.ContactsAdapter


class ContactsFragment : Fragment() {

   // var contactList = ArrayList<Contact>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View? = null
        view = inflater.inflate(R.layout.card, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            super.onViewCreated(view, savedInstanceState)
            val recyclerView = view.findViewById(R.id.allContacts) as RecyclerView
            val contactslist = ContactFetcher(context!!).fetchAll()
//            contactList = getContacts()


            //adding a layoutmanager
            recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

            //creating our adapter
            val adapter = ContactsAdapter(contactslist!!)

            //now adding the adapter to recyclerview
            recyclerView.adapter = adapter
        } catch (e: Exception) {
            e.message
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        fun newInstance(): ContactsFragment {
            var fragmentContacts = ContactsFragment()
            var args = Bundle()
            fragmentContacts.arguments = args
            return fragmentContacts

        }


    }


//    fun getContacts(): ArrayList<Contact> {
//        val contactList = ArrayList<Contact>()
//        try {
//            val cr: ContentResolver = context!!.contentResolver
//            val cur = cr.query(
//                ContactsContract.Contacts.CONTENT_URI,
//                null,
//                null,
//                null,
//                ContactsContract.Contacts.DISPLAY_NAME + " ASC "
//            )
//            var lastnumber: String? = "0"
//            val mobileNoSet = HashSet<String>()
//            if (cur!!.count > 0) {
//                while (cur.moveToNext()) {
//                    var number: String? = null
//                    val id =
//                        cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID))
//                    val name =
//                        cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
//                    if (cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)).toInt() > 0) {
//                        val pCur = cr.query(
//                            Phone.CONTENT_URI,
//                            null,
//                            Phone.CONTACT_ID + " = ?",
//                            arrayOf(id),
//                            null
//                        )
//                        while (pCur!!.moveToNext()) {
//                            number =
//                                pCur.getString(pCur.getColumnIndex(Phone.NUMBER))
//                            Log.e("lastnumber ", lastnumber)
//                            Log.e("number", number)
//                            if (number.trim() == lastnumber!!.trim()) {
//                            } else {
//                                lastnumber = number.trim()
//                                Log.e("lastnumber ", lastnumber)
//                                val type = pCur.getInt(pCur.getColumnIndex(Phone.TYPE))
//                                when (type) {
//                                    Phone.TYPE_HOME -> Log.e("Not Inserted", "Not inserted")
//                                    Phone.TYPE_MOBILE ->
//                                        contactList.add(Contact(name, lastnumber))
//                                    Phone.TYPE_WORK -> Log.e("Not Inserted", "Not inserted")
//                                }
//                            }
//                        }
//                        pCur.close()
//                    }
//                }
//            }
//
//        } catch (e: Exception) {
//            e.message
//        }
//        return contactList
//    }


}
