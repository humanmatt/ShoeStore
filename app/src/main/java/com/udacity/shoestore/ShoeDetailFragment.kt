package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment(){

    // Create a field for ViewModel
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false)


        // Onclick Listener go back to shoeList
        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigateUp()
        }


        // Onclick Listener send new data to viewModel and return to shoe list
        binding.saveDetailButton.setOnClickListener { view: View ->
            viewModel.addNewShoe(
                Shoe(
                    binding.shoeNameEditText.text.toString(),
                    binding.shoeSizeEditText.text.toString().toDouble(),
                    binding.shoeCompanyEditText.text.toString(),
                    binding.shoeDetailEditText.text.toString()
                )
            )
            view.findNavController().navigateUp()
        }

        return binding.root
    }

}