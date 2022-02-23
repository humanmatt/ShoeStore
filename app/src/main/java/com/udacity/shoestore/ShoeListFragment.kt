package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.ShoeViewModel

class ShoeListFragment : Fragment(){

    // Create a field for ViewModel
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        // Action Bar Share
        setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        // Observer creating views based on items in list
        viewModel.shoeListLive.observe(viewLifecycleOwner, Observer { shoeList ->

            for (shoe in shoeList) {

                val shoeItemBinding = ShoeListItemBinding.inflate(layoutInflater)

                shoeItemBinding.shoeViewModel = shoe
                binding.listOfShoesLinerLayout.addView(shoeItemBinding.root)

            }

        })

        binding.addShoeFab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Sharing from the Menu
        when (item.itemId) {
            R.id.logout_menu_item -> {

                findNavController().navigate(R.id.loginFragment)

            }
        }
        return super.onOptionsItemSelected(item)
    }

}