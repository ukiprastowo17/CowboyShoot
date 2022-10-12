package com.catnip.cowboyshoot.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.catnip.cowboyshoot.R
import com.catnip.cowboyshoot.databinding.FragmentEnterNameBinding
import com.catnip.cowboyshoot.ui.main.MainActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EnterNameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EnterNameFragment : Fragment(), OnFinishNavigateListener {

private lateinit var binding : FragmentEnterNameBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentEnterNameBinding.inflate(inflater, container, false)
        return binding.root
    }




    private fun navigateToMenu(name: String) {
        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra("player", name)
        startActivity(intent)
    }

    override fun onFinishNavigateListener() {
        val name = binding.etName.text.toString().trim()
        if(name.isEmpty()){
            Toast.makeText(requireContext(),"Please input your name!", Toast.LENGTH_SHORT).show()
        }else{
            navigateToMenu(name)
        }
    }


}


