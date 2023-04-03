import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.worldcup.databinding.FragmentMatchsBinding
import com.example.worldcup.ui.base.BaseFragment
import com.example.worldcup.ui.matches.adapter.MatchAdapter

class MatchFragment:BaseFragment<FragmentMatchsBinding>(){
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMatchsBinding
        get() = FragmentMatchsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        val adapter = MatchAdapter(dataManager.matches())
        binding.recyclerMatches.adapter =adapter
    }


}