package com.rightbuy.hackerkerneltask.network.utils

import android.content.Context
import android.widget.Toast
import com.google.gson.Gson
import com.rightbuy.hackerkerneltask.network.pojo.ErrorResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class NetworkHelper<Responce : MyResponce> (var context: Context){


    fun postRequest(
        call: Call<Responce>,
        callback: Callback<Responce>
    ) {
        call.enqueue(getCallback(callback))
    }

    private fun getCallback(callback: Callback<Responce>): retrofit2.Callback<Responce>? {
        return object : retrofit2.Callback<Responce> {
            override fun onResponse(
                call: Call<Responce?>,
                response: Response<Responce?>
            ) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if (response.body()!!.getStatus()!!) {
                            callback.onResponce(response.body()!!)
                        } else {
                            callback.onError("Failed.")
                            Toast.makeText(
                                context,
                                "Failed. ",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        callback.onError("body null")
                        Toast.makeText(context, "Failed.", Toast.LENGTH_SHORT).show()
                    }
                } else if(response.code()==400) {
                    if (response.errorBody() != null) try {
                        val gson = Gson()
                        val customObject: ErrorResponse = gson.fromJson(
                            response.errorBody()!!.string(),
                            ErrorResponse::class.java
                        )
                        if (customObject!=null){

                            if(customObject.errors.email!=null&&customObject.errors.email.size>0){
                                Toast.makeText(context, customObject.errors.email[0], Toast.LENGTH_SHORT).show()
                                callback.onError(customObject.errors.email[0])
                            }
                            else  if(customObject.errors.message!=null&&customObject.errors.message.size>0){
                                Toast.makeText(context, customObject.errors.message[0], Toast.LENGTH_SHORT).show()
                                callback.onError(customObject.errors.message[0])
                            }
                            else{
                                callback.onError("Failed. " )
                                Toast.makeText(context, "Failed.", Toast.LENGTH_SHORT).show()
                            }
                        }


                    } catch (e: IOException) {
                        e.printStackTrace()
                        callback.onError("Failed. " + e.message)
                        Toast.makeText(context, "Failed.", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    callback.onError("Failed. " )
                    Toast.makeText(context, "Failed.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Responce?>, t: Throwable) {
                callback.onFailed(t.toString())
                Toast.makeText(context, "Failed : ${t.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }


    interface Callback<Responce> {
        fun onResponce(responce: Responce)
        fun onError(responce: String?)
        fun onFailed(responce: String?)
    }


}

