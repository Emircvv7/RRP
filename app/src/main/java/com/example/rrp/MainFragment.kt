package com.example.rrp

import SecondFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView

class MainFragment : Fragment() {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private var count = 0
    private var isIncrementing = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        textView = view.findViewById(R.id.textView)
        button = view.findViewById(R.id.button)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            if (isIncrementing) {
                count++
                if (count >= 10) {
                    button.text = "-1"
                    isIncrementing = false
                }
            } else {
                count--
                if (count <= 0) {
                    val secondFragment = SecondFragment()
                    val transaction = requireActivity().supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainer, secondFragment)
                    transaction.commit()
                }
                if (count <= -1) {
                    count = 0
                }
            }
            textView.text = count.toString()
        }
    }
}
