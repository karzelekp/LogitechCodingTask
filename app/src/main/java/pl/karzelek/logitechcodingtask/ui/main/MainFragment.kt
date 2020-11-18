package pl.karzelek.logitechcodingtask.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pl.karzelek.logitechcodingtask.App
import pl.karzelek.logitechcodingtask.R
import pl.karzelek.logitechcodingtask.db.CLASS_STRUCTURE_TAG
import pl.karzelek.logitechcodingtask.db.SEARCH_PHRASE

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            requireActivity(),
            MainViewModel.Factory(requireActivity().application as App)
        ).get(MainViewModel::class.java)

        viewModel.johnEmployeesLiveData.observe(viewLifecycleOwner, {
            Log.d(CLASS_STRUCTURE_TAG, "search result for phrase '$SEARCH_PHRASE':$it")
        })

        viewModel.onActivityCreated()
    }
}
