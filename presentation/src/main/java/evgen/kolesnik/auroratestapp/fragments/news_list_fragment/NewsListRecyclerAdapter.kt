package evgen.kolesnik.auroratestapp.fragments.news_list_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import evgen.kolesnik.auroratestapp.R
import evgen.kolesnik.auroratestapp.base.adapter.BaseAdapter
import evgen.kolesnik.domain.dto.SourceDTO

class NewsListRecyclerAdapter : BaseAdapter<SourceDTO>() {

    class NewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: AppCompatTextView = itemView.findViewById(R.id.title)
        val description: AppCompatTextView = itemView.findViewById(R.id.description)
        val category: AppCompatTextView = itemView.findViewById(R.id.category)
        val country: AppCompatTextView = itemView.findViewById(R.id.country)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_news_list, parent, false)
        return NewsItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NewsItemViewHolder) {
            val item = dataList[position]

            holder.title.text = item.title
            holder.description.text = item.description
            holder.category.text = item.category
            holder.country.text = item.country

            holder.itemView.setOnClickListener {
                onItemClickListener?.invoke(item)
            }
        }
    }
}