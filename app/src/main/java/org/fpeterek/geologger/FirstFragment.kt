package org.fpeterek.geologger

import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        GeoLogger.context = context
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            if (GeoLogger.enabled) {
                it.findViewById<Button>(R.id.button_first).text = "Start"
                GeoLogger.disable()
            } else {
                it.findViewById<Button>(R.id.button_first).text = "Stop"
                GeoLogger.enable()
            }
            // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}