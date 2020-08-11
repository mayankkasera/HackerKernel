package com.rightbuy.hackerkerneltask.ui.main.home.post

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.network.utils.HomeDataHelper
import com.rightbuy.hackerkerneltask.ui.main.home.adapter.PostAdapter
import com.rightbuy.hackerkerneltask.utils.SpacingItemDecoration
import com.rightbuy.hackerkerneltask.utils.Util
import com.rightbuy.hackerkerneltask.utils.createFactory
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_post.view.*
import javax.security.auth.login.LoginException

/**
 * A simple [Fragment] subclass.
 */
class PostFragment : Fragment() {

    lateinit var mView: View
    lateinit var postViewModel: PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_post, container, false)

        init()
        setObserver()

        mView.loader.visibility = View.VISIBLE
        postViewModel.getPost()

        return mView
    }

    private fun init() {


        mView.recyclerView.setLayoutManager(LinearLayoutManager(context))


        val factory = PostViewModel(HomeDataHelper().postRepositoryI).createFactory()
        postViewModel = ViewModelProvider(this, factory).get(PostViewModel::class.java)
    }

    private fun setObserver() {
        postViewModel.mutableLiveData.observe(activity!!, Observer {
            mView.loader.visibility = View.GONE
            when(it){
                is PostState.AllPostSucces -> {
                    mView.recyclerView.adapter = PostAdapter(context!!,it.data,object : PostAdapter.OnClickCallback{
                        override fun onClick(id: Int) {
                            mView.loader.visibility = View.VISIBLE
                            postViewModel.getPostById("${id}")
                        }
                    })
                }
                is PostState.PostSucces -> {


                    val dialog = Dialog(activity!!)
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    dialog.setCancelable(false)
                    dialog.setContentView(R.layout.post_dialog)

                    val body = dialog.findViewById(R.id.description) as TextView
                    body.text = "Title : "+it.data.body

                    val text = dialog.findViewById(R.id.text) as TextView
                    text.text = "Description : "+it.data.title


                    val clear = dialog.findViewById(R.id.clear) as ImageView

                    clear.setOnClickListener {
                        dialog.dismiss()
                    }

                    dialog.show()
                }
                is PostState.Failure -> {
                    Toast.makeText(context,"Failed.", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }


}
