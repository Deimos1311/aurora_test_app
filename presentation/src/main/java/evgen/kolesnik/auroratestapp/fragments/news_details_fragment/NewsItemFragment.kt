package evgen.kolesnik.auroratestapp.fragments.news_details_fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import evgen.kolesnik.auroratestapp.R
import evgen.kolesnik.auroratestapp.databinding.FragmentNewsItemBinding
import evgen.kolesnik.domain.DESCRIPTION
import evgen.kolesnik.domain.STRING_NOT_AVAILABLE
import evgen.kolesnik.domain.TITLE
import evgen.kolesnik.domain.URL
import kotlinx.android.synthetic.main.fragment_news_item.view.*

class NewsItemFragment : Fragment(R.layout.fragment_news_item) {

    private var _binding: FragmentNewsItemBinding? = null
    private val binding get() = _binding!!

    private var title: String? = null
    private var description: String? = null
    private var url: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsItemBinding.inflate(inflater, container, false)

        title = arguments?.getString(TITLE, STRING_NOT_AVAILABLE)
        description = arguments?.getString(DESCRIPTION, STRING_NOT_AVAILABLE)
        url = arguments?.getString(URL, STRING_NOT_AVAILABLE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.text = title
        binding.description.text = description
        binding.url.text = url

        binding.url.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(url)
            startActivity(openURL)
        }
    }
}