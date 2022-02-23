package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment(){

    // Create a field for ViewModel
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false)

        // Request the current ShoeViewModel using the ViewModelProvider class
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)



        // Onclick Listener go back to shoeList
        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigateUp()
        }


        // Onclick Listener send new data to viewModel and return to shoe list
        binding.saveDetailButton.setOnClickListener { view: View ->
            viewModel.addNewShoe(Shoe(binding.detailsEditText.toString(), 2.0, "Company", "Description"))
           view.findNavController().navigateUp()
        }

        return binding.root
    }

}