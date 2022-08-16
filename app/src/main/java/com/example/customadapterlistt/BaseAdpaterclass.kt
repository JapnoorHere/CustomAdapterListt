package com.example.customadapterlistt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.FieldPosition

class BaseAdpaterclass(var studentInfo: ArrayList<StudentInfo>,var clickInterface: ClickInterface) : BaseAdapter() {

    override fun getCount(): Int {
        return studentInfo.size
    }

    override fun getItem(p0: Int): Any {
        return studentInfo[p0]
    }

    override fun getItemId(p0: Int): Long {
        return (studentInfo[p0].id?:0).toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
    var initView = LayoutInflater.from(p2?.context).inflate(R.layout.student_info_layout,p2,false)
        var tvId = initView.findViewById<TextView>(R.id.tvId)
        var tvName = initView.findViewById<TextView>(R.id.tvName)
        var tvPhone = initView.findViewById<TextView>(R.id.tvPhone)

        tvId.setText(studentInfo[position].id.toString())
        tvName.setText(studentInfo[position].name)
        tvPhone.setText(studentInfo[position].phn)

        initView.setOnClickListener{
            clickInterface.OnClick(position,studentInfo[position])
        }
        return initView
    }
}