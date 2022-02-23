package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeListFragment : Fragment(){

    // Create a field for ViewModel
    //private lateinit var viewModel: ShoeViewModel by activityViewModels()

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater, R.layout.fragment_shoe_list, container, false)

        // Request the current ShoeViewModel using the ViewModelProvider class
        //viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)



        // Pass in the view model to the GameFragmentBinding
        //binding.shoeViewModel = viewModel

        binding.lifecycleOwner = this

        // Observer creating views based on items in list
        viewModel.shoeListLive.observe(viewLifecycleOwner, Observer { shoeList ->

            for (shoe in shoeList){

                val shoeItemBinding = ShoeListItemBinding.inflate(layoutInflater)

                shoeItemBinding.shoeNameTextView.text = shoe.name
                shoeItemBinding.shoeSizeTextView.text = shoe.size.toString()
                shoeItemBinding.shoeCompanyTextView.text = shoe.company
                shoeItemBinding.shoeDescriptionTextView.text = shoe.description

                binding.listOfShoesLinerLayout.addView(shoeItemBinding.root)

            }

        })

        binding.addShoeFab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }


        return binding.root
    }




}