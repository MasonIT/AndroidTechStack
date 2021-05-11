package com.punkstudio.aidl.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * Date:2021/5/7-2:03 PM
 * @author Mason
 */
class User() : Parcelable {

    var name: String? = ""
    var age: Int = 0

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        age = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "User(name=$name, age=$age)"
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}