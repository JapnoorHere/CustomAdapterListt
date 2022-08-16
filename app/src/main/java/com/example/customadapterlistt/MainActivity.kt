package com.example.customadapterlistt

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.customadapterlistt.databinding.ActivityMainBinding
import com.example.customadapterlistt.databinding.AddItemBinding
import com.example.customadapterlistt.databinding.UpdateItemLayoutBinding

class MainActivity : AppCompatActivity(), ClickInterface {
    lateinit var binding : ActivityMainBinding
    lateinit var adapterClass : BaseAdpaterclass
     var studentInfo: ArrayList<StudentInfo> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabButton.setOnClickListener{
            var dialogBinding = AddItemBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
            dialog.setCancelable(false)
            dialogBinding.btnSubmit.setOnClickListener {
                if (dialogBinding.etId.text.toString().isNullOrEmpty()) {
                    dialogBinding.etId.error = "Enter Id"
                } else if (dialogBinding.etName.text.toString().isNullOrEmpty()) {
                    dialogBinding.etName.error = "Enter Name"
                } else if (dialogBinding.etPhone.text.toString().isNullOrEmpty()) {
                    dialogBinding.etPhone.error = "Enter Phone number"
                } else {
                    studentInfo.add(
                        StudentInfo(
                            dialogBinding.etId.text.toString().toInt(),
                            dialogBinding.etName.text.toString(),
                            dialogBinding.etPhone.text.toString()
                        )
                    )
                    dialog.dismiss()
                }
            }


        dialog.show()}

        studentInfo.add(StudentInfo(1,"Japnoor","1234567890"))
        adapterClass= BaseAdpaterclass(studentInfo,this)
     binding.listView.adapter=adapterClass
    }

    override fun OnClick(position: Int,studentInfo1: StudentInfo) {
        var dialog = Dialog(this)
        var dialogBinding = UpdateItemLayoutBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        dialogBinding.btnUpdate.setOnClickListener {
            if (dialogBinding.etId.text.toString().isNullOrEmpty()) {
                dialogBinding.etId.error = "Enter Id"
            } else if (dialogBinding.etName.text.toString().isNullOrEmpty()) {
                dialogBinding.etName.error = "Enter Name"
            } else if (dialogBinding.etPhone.text.toString().isNullOrEmpty()) {
                dialogBinding.etPhone.error = "Enter Phone number"
            } else {
                studentInfo.set(position,StudentInfo((dialogBinding.etId.text.toString()).toInt(),
                    dialogBinding.etName.text.toString(),dialogBinding.etPhone.text.toString()))
                dialog.dismiss()
            }
        }
        dialog.show()

}
}