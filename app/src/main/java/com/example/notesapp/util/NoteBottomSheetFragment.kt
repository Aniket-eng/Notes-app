package com.example.notesapp.util

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.notesapp.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_notes.*

class NoteBottomSheetFragment: BottomSheetDialogFragment() {
    var selectedColor = "#171C26"
    companion object {
        var noteId = -1
        fun newInstance(id:Int): NoteBottomSheetFragment{
            val args  = Bundle()
            val fragment = NoteBottomSheetFragment()
            fragment.arguments = args
            noteId = id
            return fragment
        }
    }


    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_bottom_notes,null)
        dialog.setContentView(view)

        val param = (view.parent as View).layoutParams as CoordinatorLayout.LayoutParams

        val behavior = param.behavior

        if(behavior is BottomSheetBehavior<*>){
            behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    TODO("Not yet implemented")
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    var state = ""
                    when(newState){
                        BottomSheetBehavior.STATE_DRAGGING -> {
                            state = "DRAGGING"
                        }
                        BottomSheetBehavior.STATE_SETTLING -> {
                            state = "SETTLING"
                        }
                        BottomSheetBehavior.STATE_EXPANDED -> {
                            state = "EXPANDED"
                        }
                        BottomSheetBehavior.STATE_COLLAPSED -> {
                            state = "COLLAPSED"
                        }

                        BottomSheetBehavior.STATE_HIDDEN -> {
                            state = "HIDDEN"
                            dismiss()
                            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                        }
                    }
                }



            })

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_notes,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener(){

        fNote1.setOnClickListener {
            imgNote_1.setImageResource(R.drawable.ic_check)
            imgNote_2.setImageResource(0)
            imgNote_3.setImageResource(0)
            imgNote_4.setImageResource(0)
            imgNote_5.setImageResource(0)
            imgNote_6.setImageResource(0)
            selectedColor = "#2196F3"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Blue")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }


        fNote2.setOnClickListener {
            imgNote_1.setImageResource(0)
            imgNote_2.setImageResource(R.drawable.ic_check)
            imgNote_3.setImageResource(0)
            imgNote_4.setImageResource(0)
            imgNote_5.setImageResource(0)
            imgNote_6.setImageResource(0)
            selectedColor = "#ffffff"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","White")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

        fNote3.setOnClickListener {
            imgNote_1.setImageResource(0)
            imgNote_2.setImageResource(0)
            imgNote_3.setImageResource(R.drawable.ic_check)
            imgNote_4.setImageResource(0)
            imgNote_5.setImageResource(0)
            imgNote_6.setImageResource(0)
            selectedColor = "#ffd633"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Yellow")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

        fNote4.setOnClickListener {
            imgNote_1.setImageResource(0)
            imgNote_2.setImageResource(0)
            imgNote_3.setImageResource(0)
            imgNote_4.setImageResource(R.drawable.ic_check)
            imgNote_5.setImageResource(0)
            imgNote_6.setImageResource(0)
            selectedColor = "#B2FF59"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Green")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

        fNote5.setOnClickListener {
            imgNote_1.setImageResource(0)
            imgNote_2.setImageResource(0)
            imgNote_3.setImageResource(0)
            imgNote_4.setImageResource(0)
            imgNote_5.setImageResource(R.drawable.ic_check)
            imgNote_6.setImageResource(0)
            selectedColor = "#7C4DFF"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Purple")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }
        fNote6.setOnClickListener {
            imgNote_1.setImageResource(0)
            imgNote_2.setImageResource(0)
            imgNote_3.setImageResource(0)
            imgNote_4.setImageResource(0)
            imgNote_5.setImageResource(0)
            imgNote_6.setImageResource(R.drawable.ic_check)
            selectedColor = "#FF6E40"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Orange")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }
        layoutImage.setOnClickListener{
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Image")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        layoutWebUrl.setOnClickListener{
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","WebUrl")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
    }

}