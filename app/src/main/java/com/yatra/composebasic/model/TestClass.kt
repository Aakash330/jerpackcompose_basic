package com.yatra.composebasic.model

class TestClass {

    companion object{
        fun  getUserDataList():MutableList<UserData>
        {
            val list= mutableListOf<UserData>()

            list.add(UserData("Vikash","Hi I am Vikash","07:8"))
            list.add(UserData("Aakash","Hi I am jacky","09:8"))
            list.add(UserData("jacky","Hi I am mohan","07:8"))
            list.add(UserData("Rohan","Hi I am Rohan","07:8"))
            list.add(UserData("manish","Hi I am manish","07:8"))
            list.add(UserData("sonu","Hi I am  sonu","07:8"))
            list.add(UserData("jitendra","Hi I am jitendra","07:8"))
            list.add(UserData("Rajesh","Hi I am Rajesh","07:8"))
            list.add(UserData("Aakash","Hi I am Manjesh","08:8"))
            list.add(UserData("Aakash","Hi I am Manjay","09:8"))
            list.add(UserData("Aakash","Hi I am  Modi","07:8"))
            list.add(UserData("Aakash","Hi I am Arun","07:8"))
            list.add(UserData("Aakash","Hi I am Vikash","07:8"))
            list.add(UserData("Aakash","Hi I am Vikash","07:8"))
            list.add(UserData("Aakash","Hi I am Vikash","07:8"))
            list.add(UserData("Aakash","Hi I am Vikash","07:8"))
            list.add(UserData("Aakash","Hi I am Vikash","02:8"))

            return list

        }
    }
}